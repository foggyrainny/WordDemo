import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/13.
 */
public class TestTxt {


    public static String readWantedText(String url, String wanted) {
        String temps = "" ;
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream(url),"gbk");
            BufferedReader br = new BufferedReader(fr);
            String temp = "";// 用于临时保存每次读取的内容

            while (temp != null) {
                temp = br.readLine();
//                System.out.println(temp);
                if (temp != null && temp.contains(wanted)) {
                   temps= temp;
                }
            }
        } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temps;
    }

    public static void main(String[] args){

//        File file=new File("d:\\文档");
//        final List<File> filePathsList = new ArrayList<File>();
//        File[] filePaths = file.listFiles();
////        System.out.println(filePaths[0]+"  11111");
//        for (File s : filePaths) {
//        String  aa=TestTxt.readWantedText(s.toString(),"我爱你");
//        System.out.println(aa+" 11");
//        }

//       TestTxt.readWantedText("C:\\Users\\Administrator\\Downloads\\三日重复数据查询.txt","我爱你");
        System.out.println(("4_微信图片_20190613184505.jpg_2019-06-13_18-46-40(1).txt").endsWith(".txt"));

    }
}