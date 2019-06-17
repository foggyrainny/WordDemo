import java.util.StringTokenizer;

public class TestStringToken {


    public static void main(String[] args){
        String str="java:doc\\n love:prefect\\n go";

        StringTokenizer token=new StringTokenizer(str,"\\n");
//        while(token.hasMoreElements()){
//            Object object=(Object)token.nextElement();
//            System.out.println(String.valueOf(object));
//            System.out.println(String.valueOf(object).contains("java"));
//            String temp=String.valueOf(object);
//        }
        while(token.hasMoreTokens()){
            String object=token.nextToken();
            System.out.println(object+"111");
            System.out.println(object.contains("java"));
            String temp=String.valueOf(object);
        }
    }
}
