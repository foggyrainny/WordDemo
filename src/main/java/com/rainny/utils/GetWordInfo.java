package com.rainny.utils;

import com.rainny.object.TxtInfo;
import org.apache.log4j.Logger;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.StringTokenizer;

public class GetWordInfo {
    private static final Logger logger = Logger.getLogger(GetWordInfo.class.getName());

    public static String readWord(String path) {
        String buffer = "";
        try {
            if (path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            } else if (path.endsWith(".docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                extractor.close();
            }/* else {
               logger.error("此文件不是word文件！");
            }*/
        } catch (Exception e) {
           logger.error(e);
        }
        return buffer;
    }

    public static void readWanted(String content, TxtInfo txtInfo) throws Exception {
        StringTokenizer token = new StringTokenizer(content, "\n");
        while (token.hasMoreTokens()) {
            String temp = token.nextToken();
            if (temp.contains("合计金额")) {
                txtInfo.setTotalMoney(temp.substring(5));
            } else if (temp.contains("合计税额")) {
                txtInfo.setTotalTax(temp.substring(5));
            } else if (temp.contains("价税合计(小写)")) {
                txtInfo.setTotalTM(temp.substring(9));
            } else if (temp.contains("销货方名称")) {
                txtInfo.setSellerName(temp.substring(6));
            } else if (temp.contains("开票日期")) {
                txtInfo.setBillTime(temp.substring(5).replace("年", "").replace("月", "")
                        .replace("日", ""));
            }
        }

    }


    public static void main(String[] args) {
        //	String content = tp.readWord("D:\\20180807.doc");
        String content = GetWordInfo.readWord("D:\\文档\\发票种类名称.docx");
        StringTokenizer token = new StringTokenizer(content, "\n");

        while (token.hasMoreTokens()) {
            String temp = token.nextToken();
//                System.out.println(temp+"11111");
            if (temp.contains("合计金额")) {
                String[] str = temp.split(":");
                System.out.println("合计金额=" + str[1]);
            } else if (temp.contains("合计税额")) {
                String[] str = temp.split(":");
                System.out.println("合计税额=" + str[1]);
            } else if (temp.contains("价税合计(小写)")) {
                String[] str = temp.split(":");
                System.out.println("价税合计(小写)=" + str[1]);
            } else if (temp.contains("销货方名称")) {
                String[] str = temp.split(":");
                System.out.println("销货方名称=" + str[1]);
            } else {

            }
        }
    }
}
