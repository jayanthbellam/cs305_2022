package assignment_1;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.XMLConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public final class XmlDomParser {
    
    private XmlDomParser(){}
    
    private static final String FILENAME="C:\\Users\\jayan\\Study\\SEM 6\\CS305 Software Engineering\\assignments\\assignment_1\\lib\\src\\main\\resources\\Queries.xml";

    public static List<Map<String,String>> read(){
        List<Map<String,String>> data=new ArrayList<>();
        Map<String, String> sqlParamType=new HashMap<>();
        Map<String, String> sqlCommand=new HashMap<>();
        data.add(sqlParamType);
        data.add(sqlCommand);
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        String feature = "http://apache.org/xml/features/disallow-doctype-decl";
        try{
            dbf.setFeature(feature, true);
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING,true);
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList list=doc.getElementsByTagName("sql");
            for(int temp=0;temp<list.getLength();temp++){
                Node node=list.item(temp);
                if (node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;

                    String id=element.getAttribute("id");
                    String paramType=element.getAttribute("paramType");
                    list.item(temp).normalize();
                    String command=list.item(temp).getTextContent().trim();
                    sqlCommand.put(id,command);
                    sqlParamType.put(id,paramType);
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
        return data;
    }

}
