package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.VSDataModel;
import com.hiocs.module.analysis.dao.KYSPvsDao;
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
@RequestMapping("kyspvs")
@Api(tags = "首页科研水平对标")
public class KYSPvsController {

    @Autowired
    KYSPvsDao kysPvsDao;

    @GetMapping("zlzzqs")
    @ApiOperation(value = "专利著作权数")
    public List<VSDataModel> getKYSPZLZZQSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = kysPvsDao.getVSDataBySqlIdWithParams("KYSPvs.首页科研水平专利著作权数对标", paras);
        return data;
    }

    @GetMapping("cbzzs")
    @ApiOperation(value = "出版专著数")
    public List<VSDataModel> getKYSPCBZZSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = kysPvsDao.getVSDataBySqlIdWithParams("KYSPvs.首页科研水平出版专著数对标", paras);
        return data;
    }

    @GetMapping("fblws")
    @ApiOperation(value = "发表论文数")
    public List<VSDataModel> getKYSPFBLWSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = kysPvsDao.getVSDataBySqlIdWithParams("KYSPvs.首页科研水平发表论文数对标", paras);
        return data;
    }

    @GetMapping("zxxms")
    @ApiOperation(value = "纵向项目数")
    public List<VSDataModel> getKYSPZXXMSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = kysPvsDao.getVSDataBySqlIdWithParams("KYSPvs.首页科研水平纵向项目数对标", paras);
        return data;
    }

    @GetMapping("hxxms")
    @ApiOperation(value = "横向项目数")
    public List<VSDataModel> getKYSPHXXMSCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = kysPvsDao.getVSDataBySqlIdWithParams("KYSPvs.首页科研水平横向项目数对标", paras);
        return data;
    }

    @GetMapping("hxxmjf")
    @ApiOperation(value = "横向项目经费")
    public List<VSDataModel> getKYSPHXXMJFCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = kysPvsDao.getVSDataBySqlIdWithParams("KYSPvs.首页科研水平横向项目经费对标", paras);
        return data;
    }

    @GetMapping("zxxmjf")
    @ApiOperation(value = "纵向项目经费")
    public List<VSDataModel> getKYSPZXXMJFCmpData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("14school","true");
        List<VSDataModel> data = kysPvsDao.getVSDataBySqlIdWithParams("KYSPvs.首页科研水平纵向项目经费对标", paras);
        return data;
    }

}
