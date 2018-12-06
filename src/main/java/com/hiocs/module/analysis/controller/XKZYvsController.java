package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.VSDataModel;
import com.hiocs.module.analysis.dao.XKZYvsDao;
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
@RequestMapping("xkzyvs")
@Api(tags = "首页学科专业对标")
public class XKZYvsController {

    @Autowired
    XKZYvsDao xkzYvsDao;

    @GetMapping("bsxwsqyjxkd")
    @ApiOperation(value = "博士学位授权一级学科点")
    public List<VSDataModel> getBSXWSQYJXKDDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xkzYvsDao.getVSDataBySqlIdWithParams("XKZYvs.首页学科专业博士学位授权一级学科点对标", paras);
        return data;
    }

    @GetMapping("bsxwsqejxkd")
    @ApiOperation(value = "博士学位授权二级学科点")
    public List<VSDataModel> getXKZYBSXWSQEJXKDCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xkzYvsDao.getVSDataBySqlIdWithParams("XKZYvs.首页学科专业博士学位授权二级学科点对标", paras);
        return data;
    }

    @GetMapping("ssxwsqyjxkd")
    @ApiOperation(value = "硕士学位授权一级学科点")
    public List<VSDataModel> getXKZYSSXWSQYJXKDCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xkzYvsDao.getVSDataBySqlIdWithParams("XKZYvs.首页学科专业硕士学位授权一级学科点对标", paras);
        return data;
    }

    @GetMapping("ssxwsqejxkd")
    @ApiOperation(value = "硕士学位授权二级学科点")
    public List<VSDataModel> getXKZYSSXWSQEJXKDCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xkzYvsDao.getVSDataBySqlIdWithParams("XKZYvs.首页学科专业硕士学位授权二级学科点对标", paras);
        return data;
    }

    @GetMapping("bshldz")
    @ApiOperation(value = "博士后流动站")
    public List<VSDataModel> getXKZYBSHLDZCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xkzYvsDao.getVSDataBySqlIdWithParams("XKZYvs.首页学科专业博士后流动站对标", paras);
        return data;
    }

    @GetMapping("bkzyzs")
    @ApiOperation(value = "本科专业总数")
    public List<VSDataModel> getXKZYBKZYZSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xkzYvsDao.getVSDataBySqlIdWithParams("XKZYvs.首页学科专业本科专业总数对标", paras);
        return data;
    }

    @GetMapping("zdxk")
    @ApiOperation(value = "重点学科")
    public List<VSDataModel> getXKZYZDXKCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = xkzYvsDao.getVSDataBySqlIdWithParams("XKZYvs.首页学科专业重点学科对标", paras);
        return data;
    }

}
