package assignment_1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.lang.reflect.Field;

import javax.xml.XMLConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlLib implements SqlRunner{
    //login info
    private String dburl;
    private String username;
    private String password;
    
    //file info
    private String filename;
    
    //connection info
    private String jdbcDriver="com.mysql.cj.jdbc.Driver";
    Connection dbCon=null;
    Statement stmt=null;
    //query info after reading the file
    private Map<String,String> sqlCommands;
    private Map<String,String> sqlParam;

    //Logger
    private static final Logger logger=Logger.getLogger("SQLLIB");

    SqlLib(String dburl,String username,String password,String filename){
        //update the appropriate variables
        logger.setLevel(Level.INFO);
        logger.info("The Constructor has been Invoked");
        this.dburl=dburl;
        this.username=username;
        this.password=password;
        this.filename=filename;
        this.sqlCommands=new HashMap<>();
        this.sqlParam=new HashMap<>();

        //read the xmlfile
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        String feature="http://apache.org/xml/features/disallow-doctype-decl";
        try{
            logger.log(Level.INFO,()->"Trying to parse the xml file: "+filename);
            dbf.setFeature(feature,true);
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.parse(new File(this.filename));
            doc.getDocumentElement().normalize();
            NodeList list=doc.getElementsByTagName("sql");
            logger.info("Getting all the <sql> tags");
            for(int count=0;count<list.getLength();count++){
                Node node=list.item(count);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    String id=element.getAttribute("id");
                    String paramType=element.getAttribute("paramType");
                    String command=list.item(count).getTextContent().trim();
                    String logInfo=String.format("Read the query.Query id: %s query: %s paramType: %s",id,command,paramType);
                    logger.info(logInfo);
                    sqlCommands.put(id,command);
                    sqlParam.put(id,paramType);
                }
            }
            logger.info("Succesfully read the XML file");
        }
        catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
        try{
            Class.forName(jdbcDriver);
            //getting database connection to MySQL server

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String getString(Object propX, Class<?> classtype){
        String output="";
        if (classtype==Integer.class){
            output=propX.toString();
        }
        else if(classtype==String.class || classtype==Character.class){
            output="'"+propX+"'";
        }
        else if(classtype==ArrayList.class){
            output=output.concat("(");
            ArrayList<?> list=(ArrayList<?>) propX;
            for(int i=0;i<list.size();i++){
                if(i==0) output=output.concat(getString(list.get(i),list.get(i).getClass()));
                else output=output.concat(","+getString(list.get(i),list.get(i).getClass()));
            }
            output=output.concat(")");
        }
        return output;
    }
    private String getString(Object propX){
        Class<?> classtype=propX.getClass();
        String output="";
        if (classtype==Integer.class){
            output=propX.toString();
        }
        else if(classtype==Character.class){
            output="'"+propX+"'";
        }
        else if(classtype==String.class ){
            output="\""+propX+"\"";
        }
        else if(classtype==ArrayList.class){
            output=output.concat("(");
            ArrayList<?> list=(ArrayList<?>) propX;
            for(int i=0;i<list.size();i++){
                if(i==0) output=output.concat(getString(list.get(i),list.get(i).getClass()));
                else output=output.concat(","+getString(list.get(i),list.get(i).getClass()));
            }
            output=output.concat(")");
        }
        return output;
    }
    //TO do 
    private String constructQuery(String queryId,Object pram){
        Param params=(Param) pram;
        logger.log(Level.INFO,()->"Started Constructing the query with queryId: "+queryId);
        String query=this.sqlCommands.get(queryId);
        String paramType=this.sqlParam.get(queryId);
        logger.log(Level.INFO,query);
        logger.log(Level.INFO,()-> "ParamType: "+paramType);
        List<Object> prop=params.getProp();
        int index=0;
        while(Pattern.matches("^(.)*\\$\\{(\\w)+(\\[\\])?\\}(.)*$", query)){
            query=query.replaceFirst("\\$\\{(\\w)+(\\[\\])?\\}", getString(prop.get(index)));
            index++;
        }
        return query;
    }

    private ResultSet executeQuery(String query){
        logger.log(Level.INFO,()->"Executing the query "+query);
        try{
            dbCon=DriverManager.getConnection(dburl,username,password);
            stmt=dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet result=stmt.executeQuery(query); 
            logger.log(Level.INFO,"Succesfully executed the query");
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    private int executeUpdate(String query){
        logger.log(Level.INFO,()->"Executing the query "+query);
        try{
            dbCon=DriverManager.getConnection(dburl,username,password);
            stmt=dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            int result=stmt.executeUpdate(query);
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
    //return the number of rows in the ResultSet object
    private int noOfRows(ResultSet rs){
        int count=0;
        if(rs==null){
            logger.log(Level.SEVERE,"NO RESULT SET HAS BEEN PASSED");
        }
        try{
            while(rs.next()){count++;}
            rs.beforeFirst();
        }
        catch (SQLException | NullPointerException e){
            e.printStackTrace();
            return 0;
        }
        return count;
    }

    private List<String> getColumns(ResultSet rs){
        List<String> columnNames=new ArrayList<>();
        try{
            ResultSetMetaData rsmd=rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++){
                columnNames.add(rsmd.getColumnName(i));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return columnNames;
    }
    
    @Override
    public Object selectOne(String queryId, Object queryParam, Class<?> resultType){
        String query=constructQuery(queryId, queryParam);
        ResultSet rs=executeQuery(query);
        if (rs==null){
            logger.log(Level.SEVERE,"Result Set is null");
            return new ArrayList<>();
        }
        int rowCount=noOfRows(rs);
        if(rowCount==1){
            if (resultType==null){
                logger.log(Level.INFO, "Error: The passed resultType is not a valid Class");
                return null;
            }
            List<String> columnNames=getColumns(rs);
            try{
                rs.first();
                Object required=Class.forName(resultType.getName()).getDeclaredConstructor().newInstance();
                Class<?> clas=required.getClass();
                for(int each=0;each<columnNames.size();each++){
                    String colName=columnNames.get(each);
                    String colVal=rs.getString(each+1);
                    Field field=clas.getDeclaredField(colName);
                    logger.log(Level.INFO,()->colName +": "+colVal);
                    field.set(required,colVal);
                }
                return required;

            }
            catch (Exception e ){
                logger.log(Level.INFO,()->"Error: Unable to create the object fromt the class : "+resultType.getName());
                e.printStackTrace();
                return null;
            }
        }
        else{
            logger.log(Level.INFO,()->"The query has returned "+rowCount+" rows, excpeted 1");
            return null;
        }
    }

    @Override
    public List<Object> selectMany(String queryId,Object queryParam,Class<?> resultType){
        String query=constructQuery(queryId, queryParam);
        ResultSet rs=executeQuery(query);
        if (rs==null){
            logger.log(Level.WARNING,"Result Set is null");
            return new ArrayList<>();
        }
        int rowCount=noOfRows(rs);
        if(rowCount==0){
            logger.log(Level.INFO,()->"The query has returned "+rowCount+" rows");
        }
        List<Object> required=new ArrayList<>();
        List<String> columnNames=getColumns(rs);
        try{
            rs.first();
            for (int obj=0;obj<rowCount;obj++){
                Object temp=Class.forName(resultType.getName()).getDeclaredConstructor().newInstance();
                Class<?> clas=temp.getClass();
                System.out.println(clas.descriptorString());
                for(int each=0;each<columnNames.size();each++){
                    String colName=columnNames.get(each);
                    String colVal=rs.getString(each+1);
                    Field field=clas.getDeclaredField(colName);
                    logger.log(Level.INFO,()->colName +": "+colVal);
                    field.set(temp,colVal);
                }
                rs.next();
                required.add(temp);
            }
            rs.first();
        }
        catch (Exception e){
            logger.log(Level.SEVERE,"Unable to create the object");
            e.printStackTrace();
        }
        return required;
    }

    @Override
    public int update(String queryId,Object queryParam){
        String query=constructQuery(queryId, queryParam);
        int result=executeUpdate(query);
        if (result==-1){
            logger.log(Level.SEVERE, "Update query error, may not have run properly");
        }
        return result;
    }

    @Override
    public int insert(String queryId,Object queryParam){
        String query=constructQuery(queryId, queryParam);
        int result=executeUpdate(query);
        if (result==-1){
            logger.log(Level.SEVERE, "Insert query error, may not have run properly");
        }
        return result;
    }

    @Override
    public int delete(String queryId,Object queryParam){
        String query=constructQuery(queryId, queryParam);
        int result=executeUpdate(query);
        if (result==-1){
            logger.log(Level.SEVERE, "Delete query error, may not have run properly");
        }
        return result;
    }

    public void closeDbConnection(){
        try{
            if(dbCon!=null) dbCon.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

/*class Param{
    private int count;
    private List<Object> prop;

    Param(){
        count=0;
        prop=new ArrayList<>();
    }
    Param(List<?> propX){
        count=propX.size();
        prop=new ArrayList<>();
        for (int i=0;i<count;i++){
            prop.add(propX.get(i));
        }        
    }

    public int getCount(){return count;}
    public List<Object> getProp(){return prop;}
    public void addprop(Object propZ){
        prop.add(propZ);
        count++;
    }
}*/