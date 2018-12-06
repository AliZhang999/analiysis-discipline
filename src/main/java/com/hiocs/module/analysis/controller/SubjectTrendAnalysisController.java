package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.subjectanalysis.subjecttrend.*;
import com.hiocs.module.analysis.dao.SubjectDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("subjecttrendanalysis")
@Api(tags = "趋势分析")
public class SubjectTrendAnalysisController {

    @Autowired
    SubjectDao subjectDao;

    @GetMapping("indicators")
    @ApiOperation(value = "指标组与指标")
    public IndicatorGroup getIndicators(String subjectCode){
        Map<String,List<String>> maplist = new HashMap<>();
        maplist.put("人才培养", Arrays.asList("本科生","博士生","硕士生"));
        maplist.put("学术论文", Arrays.asList("SCI","SSCI","EI"));
        maplist.put("成果获奖", Arrays.asList("一等奖","二等奖","三等奖"));
        maplist.put("科研项目", Arrays.asList("国家级","省级","部委级"));

        IndicatorGroup indicatorGroup = new IndicatorGroup();
        List<Indicator> indicatorList = new ArrayList<>();

        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",subjectCode);
        List<IndicatorItem> indicatorItems = subjectDao.getNew各学科高层次人才类型(paras);
        Indicator indicator1 = new Indicator();
        indicator1.setIndicatorItemList(indicatorItems);
        indicator1.setName("高层次人才");
        indicatorList.add(indicator1);

        String[] arrs = new String[]{"人才培养","学术论文","成果获奖","科研项目"};
        for (String arr : arrs) {
            Indicator indicator = new Indicator();
            indicator.setName(arr);

            List<IndicatorItem> indicatorItemList = new ArrayList<>();
            List<String> strings = maplist.get(arr);
            for (String string : strings) {
                IndicatorItem indicatorItem = new IndicatorItem();
                indicatorItem.setType(string);
                indicatorItemList.add(indicatorItem);
            }
            indicator.setIndicatorItemList(indicatorItemList);
            indicatorList.add(indicator);
        }

        indicatorGroup.setIndicatorList(indicatorList);

        return indicatorGroup;
    }

    @GetMapping("echartdata")
    @ApiOperation(value = "echart数据")
    public List<SubjectTrendEchart> getEchartData(Trend trend){
        List<SubjectTrendEchart> subjectTrendEchartList = new ArrayList<>();

        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",trend.getSubjectCode());
        if(trend.getType().equals("高层次人才")){
            String selects = trend.getSelects();
            String[] strings = selects.split(",");
            for (String string : strings) {
                paras.put("type",string);
                List<SubjectTrendEchartItem> trendEchartItems = subjectDao.getNew各学科各类型高层次人才三年数据(paras);
                SubjectTrendEchart subjectTrendEchart = new SubjectTrendEchart();
                subjectTrendEchart.setSubjectTrendEchartItemList(trendEchartItems);
                subjectTrendEchart.setType(string);
                subjectTrendEchartList.add(subjectTrendEchart);
            }
        }else{
            String selects = trend.getSelects();
            String[] strings = selects.split(",");
            for (String string : strings) {
                paras.put("type",string);
                List<Map> info = subjectDao.getNewSubjectInfo(paras);
                Map map1 = info.get(0);

                SubjectTrendEchartItem subjectTrendEchartItem = new SubjectTrendEchartItem();
                subjectTrendEchartItem.setSubject_code(trend.getSubjectCode());
                subjectTrendEchartItem.setSubject_name(map1.get("subject_name").toString());
                subjectTrendEchartItem.setType(string);
                subjectTrendEchartItem.set人才数2018("5");
                subjectTrendEchartItem.set人才数2017("13");
                subjectTrendEchartItem.set人才数2016("8");

                List<SubjectTrendEchartItem> subjectTrendEchartItemList = new ArrayList<>();
                subjectTrendEchartItemList.add(subjectTrendEchartItem);
                SubjectTrendEchart subjectTrendEchart = new SubjectTrendEchart();
                subjectTrendEchart.setType(string);
                subjectTrendEchart.setSubjectTrendEchartItemList(subjectTrendEchartItemList);
                subjectTrendEchartList.add(subjectTrendEchart);
            }
        }
        return subjectTrendEchartList;
    }

}
