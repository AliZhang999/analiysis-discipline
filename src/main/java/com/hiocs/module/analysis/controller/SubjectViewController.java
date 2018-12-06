package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview.*;
import com.hiocs.module.analysis.dao.SubjectDao;
import com.hiocs.module.analysis.util.DatabaseDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("subjectview")
@Api(tags = "学科全景")
public class SubjectViewController {

    @Autowired
    SubjectDao subjectDao;

    @GetMapping("xkxx")
    @ApiOperation(value = "学科信息")
    public SubjectInfo getXKXX(String subjectCode){
        SubjectInfo subjectInfo = new SubjectInfo();
        subjectInfo.set软科排名("");
        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",subjectCode);
        //基本信息
        List<Map> info = subjectDao.getNewSubjectInfo(paras);
        if(info.size()>0){
            Map map = info.get(0);
            subjectInfo.setSubjectCode(map.get("code").toString());
            subjectInfo.setSubjectName(map.get("name").toString());
            subjectInfo.set授权级别(map.get("level").toString());
        }
        //教育部评估结果
        List<JYBSubjectAssetmentResult> list = subjectDao.getNewSubjectAssessment(paras);
        List<JYBSubjectAssetmentResults> jybSubjectAssetmentResults = new ArrayList<>();
        for (JYBSubjectAssetmentResult jybSubjectAssetmentResult : list) {
            JYBSubjectAssetmentResults subjectAssetmentResults = new JYBSubjectAssetmentResults();
            subjectAssetmentResults.set评估轮次(jybSubjectAssetmentResult.get评估批次());
            subjectAssetmentResults.setJybSubjectAssetmentResult(jybSubjectAssetmentResult);
            jybSubjectAssetmentResults.add(subjectAssetmentResults);
        }
        subjectInfo.setJybSubjectAssetmentResults(jybSubjectAssetmentResults);
        return subjectInfo;
    }

    @GetMapping("xkpm")
    @ApiOperation(value = "学科排名")
    public SubjectRankingGroup getXKPM(){
        SubjectRankingGroup subjectRankingGroup = new SubjectRankingGroup();

        SubjectRanking subjectRanking = new SubjectRanking();
        subjectRanking.set排名类型("第四轮学科评估");
        List<SubjectRankingItem> rankingItems = subjectDao.getNew各学科第四轮学科排名情况();
        subjectRanking.setSubjectRankingItems(rankingItems);

        SubjectRanking softSubjectRanking = new SubjectRanking();
        softSubjectRanking.set排名类型("软科排名");
        softSubjectRanking.setSubjectRankingItems(mockSoftRanking(rankingItems));

        List<SubjectRanking> list = new ArrayList<>();
        list.add(subjectRanking);
        list.add(softSubjectRanking);
        subjectRankingGroup.setSubjectRankings(list);

        return subjectRankingGroup;
    }

    @GetMapping("sjdb")
    @ApiOperation(value = "数据对比")
    public List<SubjectCompare> getSJDB(String subjectCode){
        List<SubjectCompare> list = new ArrayList<>();

        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",subjectCode);
        paras.put("year","2018");
        paras.put("schoolcode",10593);
        List<Map> mapList = subjectDao.getNew高层次人才统计(paras);
        SubjectCompare compare1 = new SubjectCompare();
        Map<String, Double> valueMap = DatabaseDataUtil.calulateAvgAndSelfValue(subjectCode, mapList);
        compare1.setType("高层次人才");
        compare1.setSubjectValue(valueMap.get("val"));
        compare1.setAverageValue(valueMap.get("avg"));
        list.add(compare1);

        String[] strs = new String[]{"科研项目","成果获奖","学术论文","人才培养","平台建设"};
        for (String str : strs) {
            SubjectCompare compare = new SubjectCompare();
            compare.setType(str);
            compare.setSubjectValue(50*Math.random()+50);
            compare.setAverageValue(50*Math.random()+50);
            list.add(compare);
        }

        return list;
    }

    @GetMapping("qsfx")
    @ApiOperation(value = "趋势分析")
    public TrendAnalysisGroup getQSFX(String subjectCode){
        //高层次人才
        String[] years = new String[]{"2016","2017","2018"};
        TrendAnalysisGroup group = new TrendAnalysisGroup();

        List<TrendAnalysis> trendAnalysisList = new ArrayList<>();

        List<TrendAnalysisItem> trendAnalysisItems = new ArrayList<>();
        for (String year : years) {
            Map<String,Object> paras = new HashMap<>();
            paras.put("year",year);
            paras.put("schoolcode",10593);
            List<Map> list = subjectDao.getNew高层次人才统计(paras);
            Map<String, Double> valueMap = DatabaseDataUtil.calulateAvgAndSelfValue(subjectCode,list);

            TrendAnalysisItem analysisItem = new TrendAnalysisItem();
            analysisItem.setYear(year);
            analysisItem.setValue(valueMap.get("val"));

            trendAnalysisItems.add(analysisItem);
        }
        TrendAnalysis trendAnalysis1 = new TrendAnalysis();
        trendAnalysis1.setType("高层次人才");
        trendAnalysis1.setTrendAnalysisItems(trendAnalysisItems);
        trendAnalysisList.add(trendAnalysis1);

        String[] items = new String[]{"科研项目","成果获奖","学术论文","人才培养","平台建设"};
        for (String item : items) {
            List<TrendAnalysisItem> trendAnalysisItems2 = new ArrayList<>();
            for (String year : years) {
                TrendAnalysisItem trendAnalysisItem = new TrendAnalysisItem();
                trendAnalysisItem.setYear(year);
                trendAnalysisItem.setValue(50*Math.random()+50);
                trendAnalysisItems2.add(trendAnalysisItem);
            }
            TrendAnalysis trendAnalysis = new TrendAnalysis();
            trendAnalysis.setType(item);
            trendAnalysis.setTrendAnalysisItems(trendAnalysisItems2);
            trendAnalysisList.add(trendAnalysis);
        }

        group.setTrendAnalyses(trendAnalysisList);
        return group;
    }

    private List<SubjectRankingItem> mockSoftRanking(List<SubjectRankingItem> rankingItems){
        String[] level = new String[]{"A","A+","A-","B","B+","B-","C","C+","C-","D","D+","D-"};
        Iterator<SubjectRankingItem> iterator = rankingItems.iterator();
        while (iterator.hasNext()){
            SubjectRankingItem rankingItem = iterator.next();
            rankingItem.set参评高校数(""+(int)(Math.random()*20));
            rankingItem.set排名(""+(int)(Math.random()*20));
            rankingItem.set排名百分位(""+Math.random()*100);
            rankingItem.set评估等级(level[(int)(1+Math.random()*10)]);
        }
        return rankingItems;
    }

}
