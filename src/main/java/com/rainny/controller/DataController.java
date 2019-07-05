package com.rainny.controller;

import com.rainny.service.DataService;
import com.rainny.utils.GetTxtInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2019/7/4.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    private static final Logger logger = Logger.getLogger(DataController.class);

    @Resource
    private DataService dataService;

    @RequestMapping("/list")
    @ResponseBody
    public  String insert(HttpServletRequest request, @RequestParam("path") String path) throws IOException {
        path="d:\\test";
        GetTxtInfo.traverseFolder(path);
        return "l00";
    }
}
