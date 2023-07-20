package test;

import java.util.ArrayList;

public class D extends C{
    public static void main(String[] args){
        A a = new C();
        a.method();

        ArrayList<String> list = new ArrayList<String>() ;
        list.add( "apple" );
        list.add( "banana" );
        list.add( "carrot" );
        list.add( 0, "mango" );
        System.out.println(list.get(2));
    }
}
