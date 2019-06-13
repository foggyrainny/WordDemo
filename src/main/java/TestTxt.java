import java.io.*;

/**
 * Created by Administrator on 2019/6/13.
 */
public class TestTxt {

    public static void readWantedText(String url, String wanted) {
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream(url),"gbk");
            BufferedReader br = new BufferedReader(fr);
            String temp = "";// 用于临时保存每次读取的内容
            while (temp != null) {
                temp = br.readLine();
                System.out.println(temp);
                if (temp != null && temp.contains(wanted)) {
                    System.out.println(temp);
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

    public static void main(String[] args){
       TestTxt.readWantedText("C:\\Users\\Administrator\\Downloads\\三日重复数据查询.txt","我爱你");

    }
}