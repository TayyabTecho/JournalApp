package Collection;

import java.util.ArrayList;
import java.util.List;

public class coll{
    public static void main(String[] args) {


    List<String> strlist=new ArrayList<>();

    ArrayList<String> arrList=new ArrayList<>();

    arrList.add("sdf");
    arrList.add("gul syed");
    arrList.add("huss");
    arrList.add(1,"tayyab");
    arrList.get(1);
    arrList.set(2,"arbaaz");


 strlist.add("tayay");
strlist.add("aman");

        System.out.println(arrList);
        for( String s:arrList) {
            System.out.println(s);
        }
    }
}