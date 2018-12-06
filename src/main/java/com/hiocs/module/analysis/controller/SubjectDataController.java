package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.subjectanalysis.subjectdata.*;
import com.hiocs.module.analysis.controller.model.subjectanalysis.table.Child;
import com.hiocs.module.analysis.controller.model.subjectanalysis.table.Column;
import com.hiocs.module.analysis.controller.model.subjectanalysis.table.Columns;
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
@RequestMapping("subjectdata")
@Api(tags = "学科数据")
public class SubjectDataController {

    @Autowired
    SubjectDao subjectDao;

    @GetMapping("echart")
    @ApiOperation(value = "echart数据")
    public SubjectData getEchartsData(String subjectCode,String type){
        SubjectData model = new SubjectData();

        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",subjectCode);
        List<Map> subjectInfo = subjectDao.getNewSubjectInfo(paras);
        String showName = "";
        if(subjectInfo.size() > 0){
            Map map = subjectInfo.get(0);
            showName = map.get("name").toString();
        }
        model.setSubjectName(showName);

        Echart echart;
        if(type.equals("ttl")){//雷达图
            echart = getRadarData(subjectCode);
        }else{//矩形图
            echart = getRectangleData(subjectCode);
        }
        model.setEchart(echart);

        return model;
    }

    @GetMapping("table")
    @ApiOperation(value = "表格数据")
    public SubjectDataTable getTableData(String subjectCode){
        SubjectDataTable table = new SubjectDataTable();
        table.setColumns(mockTableColumns());
        table.setDatas(mockTableDatas(subjectCode));
        return table;
    }

    private Columns mockTableColumns() {
        Columns columns = new Columns();
        List<Column> columnList = new ArrayList<>();
        //---------------
        Column column1 = new Column();
        column1.setText("指标维度");
        column1.setValue("indicator");
        columnList.add(column1);
        //---------------
        Column column2 = new Column();
        column2.setText("总量");
        List<Child> children = new ArrayList<>();

        Child child1 = new Child();
        child1.setText("年份");
        child1.setValue("zlyear");
        children.add(child1);

        Child child2 = new Child();
        child2.setText("数据");
        child2.setValue("zldata");
        children.add(child2);

        Child child3 = new Child();
        child3.setText("得分");
        child3.setValue("zlscore");
        children.add(child3);

        Child child4 = new Child();
        child4.setText("百分比得分");
        child4.setValue("zlscorepercent");
        children.add(child4);

        Child child5 = new Child();
        child5.setText("排名");
        child5.setValue("zlranking");
        children.add(child5);

        column2.setChildren(children);
        columnList.add(column2);
        //--------------
        Column column3 = new Column();
        column3.setText("增量");
        List<Child> children3 = new ArrayList<>();

        Child child6 = new Child();
        child6.setText("年份");
        child6.setValue("zelyear");
        children3.add(child6);

        Child child7 = new Child();
        child7.setText("数据");
        child7.setValue("zeldata");
        children3.add(child7);

        Child child8 = new Child();
        child8.setText("得分");
        child8.setValue("zelscore");
        children3.add(child8);

        Child child9 = new Child();
        child9.setText("百分比得分");
        child9.setValue("zelscorepercent");
        children3.add(child9);

        Child child10 = new Child();
        child10.setText("排名");
        child10.setValue("zelranking");
        children3.add(child10);

        column3.setChildren(children3);
        columnList.add(column3);
        //---------------
        Column column4 = new Column();
        column4.setText("趋势");
        column4.setValue("trend");
        columnList.add(column4);

        columns.setColumns(columnList);

        return columns;
    }

    private List<SubjectDataTableData> mockTableDatas(String subjectCode) {
        List<SubjectDataTableData> datas = new ArrayList<>();
        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",subjectCode);
        List<Map> mapList = subjectDao.getNew单个学科分类型高层次三年数据统计(paras);
        for (Map map : mapList) {
            Double 人才数2018 = Double.valueOf(map.get("人才数2018").toString());
            Double 人才数2017 = Double.valueOf(map.get("人才数2017").toString());
            Double 人才数2016 = Double.valueOf(map.get("人才数2016").toString());

            Map<String,Double> yearVal = new HashMap<>();
            yearVal.put("2018",人才数2018);
            yearVal.put("2017",人才数2017);
            yearVal.put("2016",人才数2016);

            String[] years = new String[]{"2018","2017","2016"};
            for (String year : years) {

                Double percent;
                if(getIndicatorScoreInAllSubject(year,yearVal.get(year),subjectCode) == 0){
                    percent = 0.0;
                }else if(getSubjectScoreInAllSubject(year,subjectCode) == 0){
                    percent = 0.0;
                }else{
                    percent = getIndicatorScoreInAllSubject(year,yearVal.get(year),subjectCode)/getSubjectScoreInAllSubject(year,subjectCode);
                }

                Integer thisYear = Integer.valueOf(year);
                Integer lastYear = thisYear-1;
                Double aDouble = yearVal.get("" + thisYear) == null ? 0.0 : yearVal.get("" + thisYear);
                Double bDouble = yearVal.get("" + lastYear) == null ? 0.0 : yearVal.get("" + lastYear);

                SubjectDataTableData subjectDataTableData = new SubjectDataTableData();

                subjectDataTableData.setIndicator(map.get("type").toString());
                subjectDataTableData.setZlyear(year);
                subjectDataTableData.setZldata(yearVal.get(year));
                subjectDataTableData.setZlranking(3);
                subjectDataTableData.setZlscore(getIndicatorScoreInAllSubject(year,yearVal.get(year),subjectCode));
                subjectDataTableData.setZlscorepercent(percent);

                subjectDataTableData.setZelyear(year);
                subjectDataTableData.setZeldata((aDouble-bDouble));
                subjectDataTableData.setZelranking(4);
                subjectDataTableData.setZelscore(getIndicatorScoreInAllSubject(year,(aDouble-bDouble),subjectCode));
                subjectDataTableData.setZelscorepercent(getIndicatorScoreInAllSubject(year,(aDouble-bDouble),subjectCode)/getSubjectScoreInAllSubject(year,subjectCode));

                subjectDataTableData.setTrend((人才数2018-人才数2017) > 0 ? "up" : "down");

                datas.add(subjectDataTableData);
            }
        }

        if(datas.size()<=0){
            String[] indicators = new String[]{"万人计划","新世纪优秀人才","百千万人才工程","省级高层次人才","文化名家暨“四个一批”人才","省部级突出贡献专家"};
            String[] years = new String[]{"2018","2017","2016"};
            String indicatorName = indicators[(int)(1+Math.random()*5)];
            for (String indicator : indicators) {

                Map<String,Object> topData = new HashMap<>();
                topData.put("indicator",indicatorName);
                //学科值
                topData.put("zlyear",2018);
                topData.put("zldata",(int)(1+Math.random()*10));
                topData.put("zlscore",(int)(50+Math.random()*50));
                topData.put("zlscorepercent",Math.random()*100);
                topData.put("zlranking",3);
                //增量值
                topData.put("zelyear",2018);
                topData.put("zeldata",(int)(1+Math.random()*10));
                topData.put("zelscore",(int)(50+Math.random()*50));
                topData.put("zelscorepercent",Math.random()*100);
                topData.put("zelranking",(int)(1+Math.random()*10));
                //趋势
                topData.put("trend","up");

                SubjectDataTableData topSubjectDataTableData = new SubjectDataTableData();

                topSubjectDataTableData.setIndicator(indicatorName);
                topSubjectDataTableData.setZlyear("2018");
                topSubjectDataTableData.setZldata(1+Math.random()*10);
                topSubjectDataTableData.setZlranking((int)(1+Math.random()*10));
                topSubjectDataTableData.setZlscore(50+Math.random()*50);
                topSubjectDataTableData.setZlscorepercent(Math.random()*100);

                topSubjectDataTableData.setZelyear("2018");
                topSubjectDataTableData.setZeldata(1+Math.random()*10);
                topSubjectDataTableData.setZelranking((int)(1+Math.random()*10));
                topSubjectDataTableData.setZelscore(50+Math.random()*50);
                topSubjectDataTableData.setZelscorepercent(Math.random()*100);

                topSubjectDataTableData.setTrend("up");

                List<SubjectDataTableChild> childrendatas = new ArrayList<>();
                for (String year : years){
                    SubjectDataTableChild subjectDataTableChild = new SubjectDataTableChild();

                    subjectDataTableChild.setIndicator(indicatorName);
                    subjectDataTableChild.setZlyear(year);
                    subjectDataTableChild.setZldata(1+Math.random()*10);
                    subjectDataTableChild.setZlranking((int)(1+Math.random()*10));
                    subjectDataTableChild.setZlscore(50+Math.random()*50);
                    subjectDataTableChild.setZlscorepercent(Math.random()*100);

                    subjectDataTableChild.setZelyear("2018");
                    subjectDataTableChild.setZeldata(1+Math.random()*10);
                    subjectDataTableChild.setZelranking((int)(1+Math.random()*10));
                    subjectDataTableChild.setZelscore(50+Math.random()*50);
                    subjectDataTableChild.setZelscorepercent(Math.random()*100);

                    subjectDataTableChild.setTrend("up");

                    childrendatas.add(subjectDataTableChild);
                }
                topSubjectDataTableData.setSubjectDataTableChildList(childrendatas);
                datas.add(topSubjectDataTableData);
            }
        }
        return datas;
    }

    private Echart getRadarData(String subjectCode){

        RadarEchart echart = new RadarEchart();

        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",subjectCode);
        List<Map> subjectInfo = subjectDao.getNewSubjectInfo(paras);
        String showName = "";
        if(subjectInfo.size() > 0){
            Map map = subjectInfo.get(0);
            showName = map.get("code").toString()+"-"+map.get("name").toString();
            echart.setLegend(Arrays.asList(showName, "本校均值"));
        }

        //获取高层次人才2018的数据
        paras.put("year",2018);
        paras.put("schoolcode",10593);
        List<Map> list = subjectDao.getNew高层次人才统计(paras);
        Map<String, Double> valueMap = DatabaseDataUtil.calulateAvgAndSelfValue(subjectCode,list);
        Double val = valueMap.get("val");
        Double avg = valueMap.get("avg");

        List<RadarIndicator> radarIndicators = new ArrayList<>();

        RadarIndicator radarIndicator1 = new RadarIndicator();
        radarIndicator1.setName("高层次人才");
        radarIndicator1.setMax(val > avg ? val+50 : avg+50);
        radarIndicators.add(radarIndicator1);

        String[] arr = new String[]{"科研项目","成果获奖","学术论文","人才培养","平台建设"};
        for (String s : arr) {
            RadarIndicator radarIndicator = new RadarIndicator();
            radarIndicator.setName(s);
            radarIndicator.setMax(110.0);
            radarIndicators.add(radarIndicator);
        }

        echart.setIndicators(radarIndicators);

        List<RadarSeries> radarSeries = new ArrayList<>();

        RadarSeries series1 = new RadarSeries();
        series1.setName(showName);
        List<Double> values1 = new ArrayList<>();
        values1.add(val);
        values1.add(65.0);
        values1.add(75.0);
        values1.add(85.0);
        values1.add(70.0);
        values1.add(60.0);
        series1.setValue(values1);
        radarSeries.add(series1);

        RadarSeries series2 = new RadarSeries();
        series2.setName("本校均值");
        List<Double> values2 = new ArrayList<>();
        values2.add(avg);
        values2.add(60.0);
        values2.add(70.0);
        values2.add(80.0);
        values2.add(75.0);
        values2.add(65.0);
        series2.setValue(values2);
        radarSeries.add(series2);

        echart.setSeries(radarSeries);

        return echart;
    }

    private Echart getRectangleData(String subjectCode){
        RectangleEchart echart = new RectangleEchart();
        List<RectangleSeries> seriess = new ArrayList<>();

        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",subjectCode);
        paras.put("year","2018");
        paras.put("schoolcode",10593);
        List<Map> mapList = subjectDao.getNew高层次人才统计(paras);
        List<Map> list = calculateAllSubjectValue(mapList);
        for (Map map : list) {
            RectangleSeries series = new RectangleSeries();
            series.setName(map.get("subject_name").toString());
            series.setValue(Double.valueOf(map.get("val").toString()));
            seriess.add(series);
        }
        echart.setSeries(seriess);

        return echart;
    }

    private List<Map> calculateAllSubjectValue(List<Map> list){
        double max = 0;
        double min = 0;
        if(list.size()>0){
            Map maxMap = list.get(0);
            max = Double.valueOf(maxMap.get("人才数").toString());
            Map minMap = list.get(list.size()-1);
            min = Double.valueOf(minMap.get("人才数").toString());
        }
        for (Map map : list) {
            double x = Double.valueOf(map.get("人才数").toString());
            double val = Double.valueOf(60.0+(x-min)*40.0/(max-min));
            map.put("val",val);
        }
        return list;
    }

    private double getIndicatorScoreInAllSubject(String year,Double value,String subjectCode){//单个指标在所有学科中的分数
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("schoolcode",10593);
        paras.put("subjectCode",subjectCode);
        paras.put("year",year);
        List<Map> mapList = subjectDao.getNew单个学科高层次人才分类统计(paras);
        Double max;
        Double min;
        if(mapList.size()>0){
            Map maxMap = mapList.get(0);
            max = Double.valueOf(maxMap.get("人才数").toString());
            Map minMap = mapList.get(mapList.size()-1);
            min = Double.valueOf(minMap.get("人才数").toString());
        }else{
            max=0.0;
            min=0.0;
        }
        double val = Double.valueOf(60.0+(value-min)*40.0/(max-min));
        double result;
        if(Double.isFinite(val)){
            result = 0.0;
        }else if(Double.isInfinite(val)){
            result = 0.0;
        }else if(Double.isNaN(val)){
            result = 0.0;
        }else{
            result = val;
        }
        return result;
    }

    private double getSubjectScoreInAllSubject(String year,String subjectCode){//单个学科在所有学科中的分数
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("schoolcode",10593);
        List<Map> mapList = subjectDao.getNew高层次人才统计(paras);
        Map maxMap = mapList.get(0);
        Double max = Double.valueOf(maxMap.get("人才数").toString());
        Map minMap = mapList.get(mapList.size()-1);
        Double min = Double.valueOf(minMap.get("人才数").toString());
        Double x = 0.0;
        for (Map map : mapList) {
            if(map.get("subject_code").toString().equals(subjectCode)){
                x = Double.valueOf(map.get("人才数").toString());
            }
        }
        double val = Double.valueOf(60.0+(x-min)*40.0/(max-min));
        return val;
    }

}
