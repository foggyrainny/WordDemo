package com.rainny.controller;

import com.rainny.object.TxtInfo;
import com.rainny.service.TxtInfoService;
import com.rainny.utils.GetTxtInfo;
import com.rainny.utils.GetWordInfo;
import com.rainny.utils.TestRight;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by rainny on 2019/6/17.
 */
@Controller
@RequestMapping(value = "/demo")
public class TxtInfoController {

    private static final Logger logger = Logger.getLogger(TxtInfoController.class.getName());

    @Resource
    private TxtInfoService txtInfoService;

    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    @RequestMapping(value = "/insertList")
    @ResponseBody
    public String list(HttpServletRequest request, @RequestParam("path") String path, ModelMap model) throws Exception {
        //path文档所在的文件夹
        path = "D:\\文档";
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(path);
        File[] filePaths = file.listFiles();
        if (filePaths == null) {
            return "error:" + path + " path is invalid";
        }
        List<TxtInfo> list = new ArrayList<>();
        for (File s : filePaths) {
            TxtInfo txtInfo = new TxtInfo();
            //调用获取文本工具类方法给txtInfo对象赋值
            if (s.toString().endsWith(".doc") || s.toString().endsWith(".docx")) {
                //word文档发票内容获取
                String temp = GetWordInfo.readWord(s.toString());
                GetWordInfo.readWanted(temp, txtInfo);
            } else if (s.toString().endsWith(".txt")) {
                //txt文档发票内容获取
                GetTxtInfo.readWantedText(s.toString(), txtInfo);
            } else {
                logger.info(s.toString().replace(path, "").replace("\\", "") + " this document formats are not supported ");
            }


            if (!(StringUtils.isEmpty(txtInfo.getTotalMoney()) || StringUtils.isEmpty(txtInfo.getTotalTax()) || StringUtils.isEmpty(txtInfo.getTotalTM()))) {
                try {
                    //验证数据准确性
                    boolean flag = TestRight.test(Double.valueOf(txtInfo.getTotalMoney()), Double.valueOf(txtInfo.getTotalTax()), Double.valueOf(txtInfo.getTotalTM()));
                    if (flag) {
                        txtInfo.setTxtName(s.toString().replace(path, "").replace("\\", "").replace("/", ""));
                        logger.info("文件名" + txtInfo.getTxtName());
                        txtInfo.setReadTime(format.format(date));
                        logger.info("入库日期" + txtInfo.getReadTime());
                        list.add(txtInfo);
//                        logger.info(list.size());

                    } else {
                        //文本解析错误打印日志
                        stringBuilder.append(txtInfo.getTxtName() + "\\n");
                        logger.info("数据正确性验证不通过的文档：" + stringBuilder);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

//           logger.info(list.size());
        }
        System.out.println("list=" + list.size());
        txtInfoService.createInsertList(list);
        return "commited counts: " + list.size();
    }

    public static void main(String[] args) {


//        txtInfoController.list("d:\\log");

        File file = new File("DFSDFSD");
        System.out.println(file);
    }


}
