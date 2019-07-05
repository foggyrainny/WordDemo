package com.rainny.utils;

import com.rainny.object.Data;
import com.rainny.object.TxtInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/17.
 */
public class GetTxtInfo {
    private static final Logger logger = Logger.getLogger(GetTxtInfo.class.getName());

    public static void readWantedText(String url, TxtInfo txtInfo) {

        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream(url), "UTF-8");
            BufferedReader br = new BufferedReader(fr);
            String temp = "";// 用于临时保存每次读取的内容
            while (temp != null) {
                temp = br.readLine();
               logger.error(temp);
                String str = "";//临时string变量
                if (temp != null && temp.contains("合计金额")) {
                    str = temp.substring(5);
                    txtInfo.setTotalMoney(str);
//                    logger.info("合计金额=" + str);
                } else if (temp != null && temp.contains("合计税额")) {
                    str = temp.substring(5);
                    txtInfo.setTotalTax(str);
//                    logger.info("合计税额=" + str);
                } else if (temp != null && temp.contains("价税合计(小写)")) {
                    str = temp.substring(9);
                    txtInfo.setTotalTM(str);
//                    logger.info("价税合计(小写)=" + str);
                } else if (temp != null && temp.contains("销货方名称")) {
                    str = temp.substring(6);
                    txtInfo.setSellerName(str);
//                    logger.info("销货方名称=" + str);
                } else if (temp != null && temp.contains("开票日期")) {
                    str = temp.substring(5);
                    if (!StringUtils.isEmpty(str)) {
                        String str2 = str.replace("年", "").replace("月", "").replace("日", "");
                        txtInfo.setBillTime(str2);
//                        logger.info("开票日期=" + txtInfo.getBillTime());
                    }

                }else if(temp != null &&temp.contains("发票号码")){
                    txtInfo.setBillNumber(temp.substring(5));
                    logger.error("发票号码"+temp);
                }

            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
            logger.error(e);
        } catch (IOException e) {
// TODO Auto-generated catch block
            logger.error(e);
        }
    }

    public  static void readWanted(String path) throws IOException{
                Data data=new Data();
                InputStreamReader fr = new InputStreamReader(new FileInputStream(path));
                BufferedReader br = new BufferedReader(fr);
                String temp = "";// 用于临时保存每次读取的内容
                while (temp != null) {
                    temp = br.readLine();
                    String[] strs=null;
                   if(null!=temp){
                       strs = temp.split("\\t");
                       if(strs.length>0){
                         data.setMiRNA_ID(strs[0]);
                         data.setRead_count(strs[1]);
                         data.setMiRNA_mapped(strs[2]);
                         data.setCross_mapped(strs[3]);
                       }

                   }

                }
                br.close();
                fr.close();
    }

    public static void traverseFolder(String path) throws  IOException {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isFile()&&file2.getAbsolutePath().endsWith("quantification.txt")) {
                    readWanted(file2.getAbsolutePath());
                    fileNum++;

                } else {
                    list.add(file2);
                    folderNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                if(files!=null){
                    for (File file2 : files) {
                        if (file2.isFile()&&file2.getAbsolutePath().endsWith("quantification.txt")) {
                            readWanted(file2.getAbsolutePath());
                            fileNum++;

                        } else {
                            list.add(file2);
                            folderNum++;
                        }
                    }
                }

            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);

    }

    public static void main(String[] args) throws IOException {

//        File file = new File("D:\\文档");
//        File[] filePaths = file.listFiles();
//        List<TxtInfo> list = new ArrayList<>();
//        for (File s : filePaths) {
//            TxtInfo txtInfo = new TxtInfo();
//            GetTxtInfo.readWantedText(s.toString(), txtInfo);
//            if (!(StringUtils.isEmpty(txtInfo.getTotalMoney()) || StringUtils.isEmpty(txtInfo.getTotalTax()) || StringUtils.isEmpty(txtInfo.getTotalTM()))) {
//                try {
//                    boolean flag = TestRight.test(Double.valueOf(txtInfo.getTotalMoney()), Double.valueOf(txtInfo.getTotalTax()), Double.valueOf(txtInfo.getTotalTM()));
//                    if (flag) {
//                        list.add(txtInfo);
//                    } else {
//                        Log4JLogger logger = new Log4JLogger();
//                        logger.info(txtInfo.getTxtName());
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//            logger.info(list.size());
//        }
//
//        File file = new File("D:\\test");
//        File[] filePaths = file.listFiles();
//        for(int i=0;i<filePaths.length;i++){
//           File sfile=filePaths[i];
//           if(sfile.isFile()){
//               InputStreamReader fr = new InputStreamReader(new FileInputStream(sfile.toString()), "UTF-8");
//               BufferedReader br = new BufferedReader(fr);
//               String temp = "";// 用于临时保存每次读取的内容
//               while (temp != null) {
//                   temp = br.readLine();
//                   System.out.println("test:  "+temp);
//               }
//               br.close();
//               fr.close();
//           }else {
//
//           }
//        }

//        for (File s : filePaths) {
//            InputStreamReader fr = new InputStreamReader(new FileInputStream(s.toString()), "UTF-8");
//            BufferedReader br = new BufferedReader(fr);
//            String temp = "";// 用于临时保存每次读取的内容
//            while (temp != null) {
//                temp = br.readLine();
//                System.out.println("test:  "+temp);
//            }
//            br.close();
//            fr.close();
//    }
        GetTxtInfo.traverseFolder("D:\\test");

        String a="hsa-mir-8069-1\t0\t0.000000\tN";
    }
}
