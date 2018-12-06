package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.homepageschoolinfo.*;
import com.hiocs.module.analysis.dao.HomePageInfoDao;
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
@RequestMapping("home")
@Api(tags = "学校综合数据")
public class HomePageInfoController {

    @Autowired
    HomePageInfoDao homePageInfoDao;

    @GetMapping("schoolinfo")
    @ApiOperation(value = "学校综合数据")
    public SchoolInfo getSchoolViewData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");

        SchoolInfo schoolInfo = new SchoolInfo();

        //高校情况
        List<GXQK> gxqkData = homePageInfoDao.getGXQKData("HomePageInfo.首页高校情况", GXQK.class, paras);
        if(gxqkData.size()>0){
            GXQK gxqk = gxqkData.get(0);
            schoolInfo.setGxqk(gxqk);
        }
        //教学成果
        List<JXCG> jxcgData;
        if(year.equals("2016")){
            jxcgData = homePageInfoDao.getJXCGData("HomePageInfo.首页教学成果2016", JXCG.class, paras);
        }else{
            jxcgData = homePageInfoDao.getJXCGData("HomePageInfo.首页教学成果2017", JXCG.class, paras);
        }
        if(jxcgData.size()>0){
            JXCG jxcg = jxcgData.get(0);
            schoolInfo.setJxcg(jxcg);
        }

        //办学条件
        List<BXTJ> bxtjData = homePageInfoDao.getBXTJData("HomePageInfo.首页办学条件", BXTJ.class, paras);
        if(bxtjData.size()>0){
            BXTJ bxtj = bxtjData.get(0);
            schoolInfo.setBxtj(bxtj);
        }

        //学生情况
        List<XSQK> xsqkData = homePageInfoDao.getXSQKData("HomePageInfo.首页学生情况", XSQK.class, paras);
        if(xsqkData.size()>0){
            XSQK xsqk = xsqkData.get(0);
            schoolInfo.setXsqk(xsqk);
        }

        //师资情况
        List<SZQK> szqkData;
        if(year.equals("2016")){
            szqkData = homePageInfoDao.getSZQKData("HomePageInfo.首页师资情况2016", SZQK.class, paras);
        }else{
            szqkData = homePageInfoDao.getSZQKData("HomePageInfo.首页师资情况2017", SZQK.class, paras);
        }
        if(szqkData.size()>0){
            SZQK szqk = szqkData.get(0);
            schoolInfo.setSzqk(szqk);
        }

        //学科专业
        List<XKZY> xkzyData = homePageInfoDao.getXKZYData("HomePageInfo.首页学科专业", XKZY.class, paras);
        if(xkzyData.size()>0){
            XKZY xkzy = xkzyData.get(0);
            schoolInfo.setXkzy(xkzy);
        }

        //科研水平
        List<KYSP> kyspData = homePageInfoDao.getKYSPData("HomePageInfo.首页科研水平", KYSP.class, paras);
        if(kyspData.size()>0){
            KYSP kysp = kyspData.get(0);
            schoolInfo.setKysp(kysp);
        }

        return schoolInfo;
    }

}
