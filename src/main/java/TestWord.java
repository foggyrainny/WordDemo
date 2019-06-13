import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.StringTokenizer;

public class TestWord {
        public static String readWord(String path) {
            String buffer = "";
            try {
                if (path.endsWith(".doc")) {
                    InputStream is = new FileInputStream(new File(path));
                    WordExtractor ex = new WordExtractor(is);
                    buffer = ex.getText();
                    ex.close();
                } else if (path.endsWith("docx")) {
                    OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                    POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                    buffer = extractor.getText();
                    extractor.close();
                } else {
                    System.out.println("此文件不是word文件！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return buffer;
        }
        public static void main(String[] args) {
       //	String content = tp.readWord("D:\\20180807.doc");
            String content = TestWord.readWord("D:\\文档\\发票种类名称.docx");
            StringTokenizer token =new StringTokenizer(content,"\\n");

            if(token.nextToken().indexOf("合计金额")!=-1){
                System.out.println("true");
            }
            String test= content.substring(content.indexOf("合计金额:"),content.indexOf("销货方纳税人识别号"));

//            String test2= content.substring(content.indexOf("价税合计"),content.indexOf("销货方纳税人识别号"));
            System.out.println(test);
//           String s=test.substring(test.indexOf(":"));
//            System.out.println(s);
//            while(token.hasMoreTokens()){
//
//
//            }
//           String[] aa= content.split("\\n");
//            System.out.println(content);
//            System.out.println(aa.length);
//
//            System.out.println("2222===="+aa[9]);
//            System.out.println("333==="+aa[10]);
//            System.out.println(aa[11]);
//            System.out.println(aa[12]);
//            System.out.println(aa[13]);
//            System.out.println(aa[14]);

//            if(aa[9].contains("")||aa[9].contains("")){
//                System.out.println("yes!!!");
//            }else{
//                System.out.println("no!!!");
//            }

//            for(int i=0;i<aa.length;i++){
//                System.out.println(i+"= "+aa[i]);
//            }
        }

}