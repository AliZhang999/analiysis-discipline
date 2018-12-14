package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.VSDataModel;
import com.hiocs.module.analysis.dao.XSQKvsDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("home/xsqkvs")
@Api(tags = "首页学生情况对标")
public class XSQKvsController {

    @Autowired
    XSQKvsDao xsqKvsDao;

    @GetMapping("bks")
    @ApiOperation(value = "本科生")
    public List<VSDataModel> getXSQKBKSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况本科生对标", paras);
        return data;
    }

    @GetMapping("zks")
    @ApiOperation(value = "专科生")
    public List<VSDataModel> getXSQKZKSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况专科生对标", paras);
        return data;
    }

    @GetMapping("ssyjs")
    @ApiOperation(value = "硕士研究生")
    public List<VSDataModel> getXSQKSSYJSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况硕士研究生对标", paras);
        return data;
    }

    @GetMapping("bsyjs")
    @ApiOperation(value = "博士研究生")
    public List<VSDataModel> getXSQKBSYJSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况博士研究生对标", paras);
        return data;
    }

    @GetMapping("lxs")
    @ApiOperation(value = "留学生")
    public List<VSDataModel> getXSQKLXSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况留学生对标", paras);
        return data;
    }

    @GetMapping("sjlqs")
    @ApiOperation(value = "实际录取数")
    public List<VSDataModel> getXSQKSJLQSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况实际录取数对标", paras);
        return data;
    }

    @GetMapping("jyss")
    @ApiOperation(value = "就业生数")
    public List<VSDataModel> getXSQKJYSSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况就业生数对标", paras);
        return data;
    }

    @GetMapping("byss")
    @ApiOperation(value = "毕业生数")
    public List<VSDataModel> getXSQKBYSSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xsqKvsDao.getVSDataBySqlIdWithParams("XSQKvs.首页学生情况毕业生数对标", paras);
        return data;
    }

}
