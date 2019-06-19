package com.rainny.controller;

import com.rainny.object.TxtInfo;
import com.rainny.service.TxtInfoService;
import com.rainny.utils.GetTxtInfo;
import com.rainny.utils.TestRight;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
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

    @RequestMapping(value="/insertList")
    public String list(HttpServletRequest request, @RequestParam("path") String path, ModelMap model) throws Exception {
        //path文档所在的文件夹
         path="D:\\文档";
        File file = new File(path);
        File[] filePaths = file.listFiles();
        List<TxtInfo> list = new ArrayList<>();
        for (File s : filePaths) {
            TxtInfo txtInfo = new TxtInfo();
            //调用工具类方法给txtInfo对象赋值
            GetTxtInfo.readWantedText(s.toString(),txtInfo);
            if (!(StringUtils.isEmpty(txtInfo.getTotalMoney()) || StringUtils.isEmpty(txtInfo.getTotalTax()) || StringUtils.isEmpty(txtInfo.getTotalTM()))) {
                try {
                    boolean flag = TestRight.test(Double.valueOf(txtInfo.getTotalMoney()), Double.valueOf(txtInfo.getTotalTax()), Double.valueOf(txtInfo.getTotalTM()));
                    if (flag) {
                        list.add(txtInfo);
                    } else {
                        //文本解析错误打印日志
                        logger.info(txtInfo.getTxtName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

//           logger.info(list.size());
        }

        txtInfoService.createInsertList(list);
        return "list";
    }

}
