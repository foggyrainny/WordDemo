import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestLast {

    public static void readWantedText(String url) {
        try {
//            InputStreamReader fr = new InputStreamReader(new FileInputStream(url),"utf-8");
            InputStreamReader fr=null;
            if(url.endsWith(".docx")||url.endsWith(".doc")){
                 fr = new InputStreamReader(new FileInputStream(url),"UTF-16");
            }else{
                fr=new InputStreamReader(new FileInputStream(url),"gbk");
            }

            BufferedReader br = new BufferedReader(fr);
            String temp = "";// 用于临时保存每次读取的内容
            while (temp != null) {
                temp = br.readLine();
              System.out.println(temp);
                if (temp != null && temp.contains("合计金额")) {
                    StringTokenizer token=new StringTokenizer(temp,"：");
                    System.out.println(token.nextToken());
                }
            }
        } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public  static  void  main(String[] args){

        File f = new File("D:\\文档");
        // 文件总数
        final List<File> filePathsList = new ArrayList<File>();
        File[] filePaths = f.listFiles();
        for(int i=0;i<filePaths.length;i++){

           TestLast.readWantedText(filePaths[i].toString());
        }
    }
}
