package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.VSDataModel;
import com.hiocs.module.analysis.dao.BXTJvsDao;
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
@RequestMapping("home/bxtjvs")
@Api(tags = "首页办学条件对标")
public class BXTJvsController {

    @Autowired
    BXTJvsDao bxtJvsDao;

    @GetMapping("jxyqsbz")
    @ApiOperation(value = "教学仪器设备值")
    public List<VSDataModel> getBXTJJXYQSBZCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = bxtJvsDao.getVSDataBySqlIdWithParams("BXTJvs.首页办学条件教学仪器设备值对标", paras);
        return data;
    }

    @GetMapping("jyjfze")
    @ApiOperation(value = "教育经费总额")
    public List<VSDataModel> getBXTJJYJFZECmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = bxtJvsDao.getVSDataBySqlIdWithParams("BXTJvs.首页办学条件教育经费总额对标", paras);
        return data;
    }

    @GetMapping("jxjfze")
    @ApiOperation(value = "教学经费总额")
    public List<VSDataModel> getBXTJJXJFZECmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = bxtJvsDao.getVSDataBySqlIdWithParams("BXTJvs.首页办学条件教学经费总额对标", paras);
        return data;
    }

    @GetMapping("jxjfzz")
    @ApiOperation(value = "教学经费支出")
    public List<VSDataModel> getBXTJJXJFZZCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = bxtJvsDao.getVSDataBySqlIdWithParams("BXTJvs.首页办学条件教学经费支出对标", paras);
        return data;
    }

    @GetMapping("SJJXJF")
    @ApiOperation(value = "实践教学经费")
    public List<VSDataModel> getBXTJSJJXJFCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = bxtJvsDao.getVSDataBySqlIdWithParams("BXTJvs.首页办学条件实践教学经费对标", paras);
        return data;
    }

    @GetMapping("gdzczz")
    @ApiOperation(value = "固定资产总值")
    public List<VSDataModel> getBXTJGDZCZZCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = bxtJvsDao.getVSDataBySqlIdWithParams("BXTJvs.首页办学条件固定资产总值对标", paras);
        return data;
    }

}
