package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.VSDataModel;
import com.hiocs.module.analysis.dao.JXCGvsDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("jxcgvs")
@Api(tags = "首页教学成果对标")
public class JXCGvsController {

    @Autowired
    JXCGvsDao jxcGvsDao;

    @GetMapping("gjjjxcgj")
    @ApiOperation(value = "国家级教学成果奖")
    public List<VSDataModel> getJXCGGJJJXCGJCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = jxcGvsDao.getVSDataBySqlIdWithParams("JXCGvs.首页教学成果国家级教学成果奖对标", paras);
        return data;
    }

    @GetMapping("gjjjyjxyjyggxm")
    @ApiOperation(value = "国家级教育教学研究与改革项目")
    public List<VSDataModel> getJXCGGJJJYJXYJYGGXMCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = jxcGvsDao.getVSDataBySqlIdWithParams("JXCGvs.首页教学成果国家级教育教学研究与改革项目对标", paras);
        return data;
    }

    @GetMapping("gjjbkjxgc")
    @ApiOperation(value = "国家级本科教学工程")
    public List<VSDataModel> getJXCGGJJBKJXGCCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = jxcGvsDao.getVSDataBySqlIdWithParams("JXCGvs.首页教学成果国家级本科教学工程对标", paras);
        return data;
    }

    @GetMapping("sbjbkjxgc")
    @ApiOperation(value = "省部级本科教学工程")
    public List<VSDataModel> getJXCGSBJBKJXGCCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = jxcGvsDao.getVSDataBySqlIdWithParams("JXCGvs.首页教学成果省部级本科教学工程对标", paras);
        return data;
    }

    @GetMapping("rcpymscxsyq")
    @ApiOperation(value = "人才培养模式创新实验区")
    public List<VSDataModel> getJXCGRCPYMSCXSYQCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = jxcGvsDao.getVSDataBySqlIdWithParams("JXCGvs.首页教学成果人才培养模式创新实验区对标", paras);
        return data;
    }

    @GetMapping("gjjjxjd")
    @ApiOperation(value = "国家级教学基地")
    public List<VSDataModel> getJXCGGJJJXJDCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = jxcGvsDao.getVSDataBySqlIdWithParams("JXCGvs.首页教学成果国家级教学基地对标", paras);
        return data;
    }

    @GetMapping("gjjsjyrcxcyjd")
    @ApiOperation(value = "牵头建设国家级实践育人创新创业基地")
    public List<VSDataModel> getJXCGGJJSJYRCXCYJDCmpData(String year){
        if(year.equals("2016")){
            VSDataModel model = new VSDataModel();
            model.set学校值("2016年无此数据");
            model.set学校名称("2016年无此数据");
            List<VSDataModel> list = new ArrayList<>();
            list.add(model);
            return list;
        }
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = jxcGvsDao.getVSDataBySqlIdWithParams("JXCGvs.首页教学成果牵头建设国家级实践育人创新创业基地对标", paras);
        return data;
    }

}
