package assignment_1;

import java.util.ArrayList;
import java.util.List;

public class Param{
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
}