package com.rainny.utils;

import com.rainny.object.TxtInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
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
                String str = "";//临时string变量
                if (temp != null && temp.contains("合计金额")) {
                    str = temp.substring(5);
                    txtInfo.setTotalMoney(str);
                    logger.info("合计金额=" + str);
                } else if (temp != null && temp.contains("合计税额")) {
                    str = temp.substring(5);
                    txtInfo.setTotalTax(str);
                    logger.info("合计税额=" + str);
                } else if (temp != null && temp.contains("价税合计(小写)")) {
                    str = temp.substring(9);
                    txtInfo.setTotalTM(str);
                    logger.info("价税合计(小写)=" + str);
                } else if (temp != null && temp.contains("销货方名称")) {
                    str = temp.substring(6);
                    txtInfo.setSellerName(str);
                    logger.info("销货方名称=" + str);
                } else if (temp != null && temp.contains("开票日期")) {
                    str = temp.substring(5);
                    if (!StringUtils.isEmpty(str)) {
                        String str2 = str.replace("年", "").replace("月", "").replace("日", "");
                        txtInfo.setBillTime(str2);
                        logger.info("开票日期=" + txtInfo.getBillTime());
                    }


                }

            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        File file = new File("D:\\文档");
        File[] filePaths = file.listFiles();
        List<TxtInfo> list = new ArrayList<>();
        for (File s : filePaths) {
            TxtInfo txtInfo = new TxtInfo();
            GetTxtInfo.readWantedText(s.toString(), txtInfo);
            if (!(StringUtils.isEmpty(txtInfo.getTotalMoney()) || StringUtils.isEmpty(txtInfo.getTotalTax()) || StringUtils.isEmpty(txtInfo.getTotalTM()))) {
                try {
                    boolean flag = TestRight.test(Double.valueOf(txtInfo.getTotalMoney()), Double.valueOf(txtInfo.getTotalTax()), Double.valueOf(txtInfo.getTotalTM()));
                    if (flag) {
                        list.add(txtInfo);
                    } else {
                        Log4JLogger logger = new Log4JLogger();
                        logger.info(txtInfo.getTxtName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            logger.info(list.size());
        }

    }
}
