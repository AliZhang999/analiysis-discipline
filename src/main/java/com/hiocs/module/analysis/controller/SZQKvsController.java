package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.VSDataModel;
import com.hiocs.module.analysis.dao.SZQKvsDao;
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
@RequestMapping("home/szkqvs")
@Api(tags = "首页师资情况对标")
public class SZQKvsController {

    @Autowired
    SZQKvsDao szqKvsDao;

    @GetMapping("jzgs")
    @ApiOperation(value = "教职工数")
    public List<VSDataModel> getSZQKJZGSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况教职工数对标", paras);
        return data;
    }

    @GetMapping("sysz")
    @ApiOperation(value = "实验师资")
    public List<VSDataModel> getSZQKSYSZCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况实验师资对标", paras);
        return data;
    }

    @GetMapping("gccrc")
    @ApiOperation(value = "高层次人才")
    public List<VSDataModel> getSZQKGCCRCCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况高层次人才对标", paras);
        return data;
    }

    @GetMapping("jsstjkbl")
    @ApiOperation(value = "教授上台讲课比例")
    public List<VSDataModel> getSZQKJSSTJKBLCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况教授上台讲课比例对标", paras);
        return data;
    }

    @GetMapping("zrjs")
    @ApiOperation(value = "专任教师")
    public List<VSDataModel> getSZQKZRJSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data;
        if(year.equals("2016")){
            data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况专任教师对标2016", paras);
        }else{
            data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况专任教师对标2017", paras);
        }
        return data;
    }

    @GetMapping("bsfgl")
    @ApiOperation(value = "博硕覆盖率")
    public List<VSDataModel> getSZQKBSFGLCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data;
        if(year.equals("2016")){
            data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况博硕覆盖率对标2016", paras);
        }else{
            data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况博硕覆盖率对标2017", paras);
        }
        return data;
    }

    @GetMapping("ssb")
    @ApiOperation(value = "生师比")
    public List<VSDataModel> getSZQKSSBCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data;
        if(year.equals("2016")){
            data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况生师比对标2016", paras);
        }else{
            data = szqKvsDao.getVSDataBySqlIdWithParams("SZQKvs.首页师资情况生师比对标2017", paras);
        }
        return data;
    }

}
