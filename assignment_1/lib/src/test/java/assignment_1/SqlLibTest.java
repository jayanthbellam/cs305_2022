package assignment_1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment_1.TableHolders.*;

public class SqlLibTest {
    private SqlLib testObj;
    
    @BeforeEach
    void setUp(){
        String dbUrl="jdbc:mysql://localhost:3306/sakila";
        String username="root";
        String password="mysql";
        String filename="src\\test\\resources\\Queries.xml";
        testObj=new SqlLib(dbUrl,username,password,filename);
    }
    @Test
    @DisplayName("selectOne")
    void selectOne(){
        Param queryParam=new Param();
        String queryId="getMovieById";
        queryParam.addprop(12);
        Film test=new Film();
        Class<?> cls=test.getClass();
        test=(Film) testObj.selectOne(queryId,queryParam,cls);
        System.out.println(test.title);
    }
    @Test
    @DisplayName("selectMany")
    void selectMany(){
        Param queryParam=new Param();
        String queryId="getMoviesById";
        ArrayList<Integer> ids=new ArrayList<>();
        ids.add(12);
        ids.add(13);
        queryParam.addprop(ids);
        List<Object> whatever=new ArrayList<>();
        Film test=new Film();
        Class<?> cls= test.getClass();
        whatever=testObj.selectMany(queryId,queryParam,cls);
        for(int i=0;i<whatever.size();i++){
            Film filmobject=(Film) whatever.get(i);
            System.out.println(filmobject.title);
        }
        queryParam= new Param();
        queryId="selectCountries";
        whatever=new ArrayList<>();
        Country te=new Country();
        cls= te.getClass();
        whatever=testObj.selectMany(queryId,queryParam,cls);
        for(int i=0;i<whatever.size();i++){
            Country countryobject=(Country) whatever.get(i);
            System.out.println(countryobject.country);
        }
    }
    @Test
    @DisplayName("Update")
    void update(){
        Param queryParam=new Param();
        queryParam.addprop(1925);
        queryParam.addprop(20);
        String queryId="updateFilmYear";
        int temp=testObj.update(queryId,queryParam);
        System.out.println(temp);

    }
    /*
    @Test
    @DisplayName("")
    void insert(){}

    @Test
    @DisplayName("")
    void delete(){}*/
}
