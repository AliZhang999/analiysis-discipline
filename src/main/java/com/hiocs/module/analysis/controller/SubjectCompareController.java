package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare.*;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("subjectcompare")
@Api(tags = "学科对比")
public class SubjectCompareController {

    @Autowired
    SubjectDao subjectDao;

    @GetMapping("vsdata")
    @ApiOperation(value = "对比数据")
    public VSData getVSData(String leftSubjectCode, String rightType, String rightSchoolCode, String rightSubjectCode){
        VSData vsData = new VSData();

        Map<String,Object> oMap = new HashMap<>();
        oMap.put("leftSubjectCode",leftSubjectCode);
        oMap.put("rightType",rightType);
        oMap.put("rightSchoolCode",rightSchoolCode);
        oMap.put("rightSubjectCode",rightSubjectCode);
        Map<String,Object> paras1 = new HashMap<>();
        paras1.put("subjectCode",rightSubjectCode);
        List<Map> subjectInfo1 = subjectDao.getNewSubjectInfo(paras1);
        String showName1;
        if(subjectInfo1.size() > 0){
            Map map1 = subjectInfo1.get(0);
            showName1 = map1.get("code").toString()+"-"+map1.get("name").toString();
            oMap.put("rightSelectItem",showName1);
        }
        vsData.setOparam(oMap);

        Map<String,Object> paras = new HashMap<>();
        paras.put("subjectCode",leftSubjectCode);
        List<Map> subjectInfo = subjectDao.getNewSubjectInfo(paras);
        String showName = "";
        if(subjectInfo.size() > 0){
            Map map = subjectInfo.get(0);
            showName = map.get("code").toString()+"-"+map.get("name").toString();
        }
        vsData.setLeftName(showName);
        vsData.setRightName(rightType);
        vsData.setLeftItem(getLeftVsData(leftSubjectCode));
        vsData.setRightItem(getRightVsData(leftSubjectCode,rightType,rightSchoolCode,rightSubjectCode));

        return vsData;
    }

    @GetMapping("incredata")
    @ApiOperation(value = "增量数据")
    public IncrementData getIncreData(String leftSubjectCode, String rightType, String rightSchoolCode, String rightSubjectCode){
        IncrementData incrementData = new IncrementData();
        incrementData.setLeftItem(getLeftIncreData(leftSubjectCode));
        incrementData.setRightItem(getRightIncreData(leftSubjectCode,rightType,rightSchoolCode,rightSubjectCode));
        return incrementData;
    }

    @GetMapping("tabledata")
    @ApiOperation(value = "表格数据")
    public SubjectCompareTable gettableData(String leftSubjectCode, String rightType, String rightSchoolCode, String rightSubjectCode){
        SubjectCompareTable table = new SubjectCompareTable();
        table.setColumns(getTableColumns());
        table.setDatas(getTableDatas(leftSubjectCode, rightType, rightSchoolCode, rightSubjectCode));
        return table;
    }

    private LeftItem getLeftVsData(String leftSubjectCode){
        LeftItem leftItem = new LeftItem();
        List<Item> leftItemList = new ArrayList<>();
        //本校高层次人才18年的值
        Map<String,Object> paras1 = new HashMap<>();
        paras1.put("year",2018);
        paras1.put("schoolcode",10593);
        List<Map> list1 = subjectDao.getNew高层次人才统计(paras1);
        Map<String, Double> map1 = DatabaseDataUtil.calulateAvgAndSelfValue(leftSubjectCode, list1);
        Item item1 = new Item();
        item1.setItemName("高层次人才");
        item1.setItemValue(map1.get("val"));
        leftItemList.add(item1);

        String[] arr = new String[]{"科研项目","成果获奖","学术论文","人才培养","平台建设"};
        for (String s : arr) {
            Item item = new Item();
            item.setItemName(s);
            item.setItemValue(50+Math.random()*50);
            leftItemList.add(item);
        }

        leftItem.setItemList(leftItemList);

        return leftItem;
    }

    private RightItem getRightVsData(String leftSubjectCode, String rightType, String rightSchoolCode, String rightSubjectCode){
        RightItem rightItem = new RightItem();
        List<Item> rightItemList = new ArrayList<>();
        Map<String,Object> paras2 = new HashMap<>();
        List<Map> list2;
        Map<String, Double> map2;
        double val2;
        if(rightType.equals("本校均值")){
            paras2.put("year",2018);
            paras2.put("schoolcode",10593);
            list2 = subjectDao.getNew高层次人才统计(paras2);
            map2 = DatabaseDataUtil.calulateAvgAndSelfValue(leftSubjectCode, list2);
            val2 = map2.get("avg");
        }else if(rightType.equals("本校学科")){
            paras2.put("year",2018);
            paras2.put("schoolcode",10593);
            list2 = subjectDao.getNew高层次人才统计(paras2);
            map2 = DatabaseDataUtil.calulateAvgAndSelfValue(rightSubjectCode, list2);
            val2 = map2.get("val");
        }else{
            paras2.put("year",2018);
            paras2.put("schoolcode",rightSchoolCode);
            list2 = subjectDao.getNew高层次人才统计(paras2);
            map2 = DatabaseDataUtil.calulateAvgAndSelfValue(rightSubjectCode, list2);
            val2 = map2.get("val");
        }

        Item item1 = new Item();
        item1.setItemName("高层次人才");
        item1.setItemValue(val2);
        rightItemList.add(item1);

        String[] arr = new String[]{"科研项目","成果获奖","学术论文","人才培养","平台建设"};
        for (String s : arr) {
            Item item = new Item();
            item.setItemName(s);
            item.setItemValue(50+Math.random()*50);
            rightItemList.add(item);
        }

        rightItem.setItemList(rightItemList);

        return rightItem;
    }

    private LeftItem getLeftIncreData(String leftSubjectCode){
        LeftItem leftItem = new LeftItem();
        List<Item> leftItemList = new ArrayList<>();
        //本校高层次人才18年同比17年结果
        Map<String,Object> paras1 = new HashMap<>();
        paras1.put("year",2018);
        paras1.put("schoolcode",10593);
        List<Map> list1 = subjectDao.getNew高层次人才统计(paras1);
        Map<String, Double> map1 = DatabaseDataUtil.calulateAvgAndSelfValue(leftSubjectCode, list1);
        Double val18 = map1.get("val");

        paras1.put("year",2017);
        List<Map> list2 = subjectDao.getNew高层次人才统计(paras1);
        Map<String, Double> map2 = DatabaseDataUtil.calulateAvgAndSelfValue(leftSubjectCode, list2);
        Double val17 = map2.get("val");

        double rate = val17 == 0 ? 0 : val18/val17*100;
        Item item1 = new Item();
        item1.setItemName("高层次人才");
        item1.setItemValue(rate);
        leftItemList.add(item1);

        String[] arr = new String[]{"科研项目","成果获奖","学术论文","人才培养","平台建设"};
        for (String s : arr) {
            Item item = new Item();
            item.setItemName(s);
            item.setItemValue(Math.random()*100);
            leftItemList.add(item);
        }

        leftItem.setItemList(leftItemList);

        return leftItem;
    }

    private RightItem getRightIncreData(String leftSubjectCode, String rightType, String rightSchoolCode, String rightSubjectCode){
        RightItem rightItem = new RightItem();
        List<Item> rightItemList = new ArrayList<>();
        Map<String,Object> paras2 = new HashMap<>();
        List<Map> list2;
        Map<String, Double> map2;
        List<Map> list3;
        Map<String, Double> map3;
        double val2;

        if(rightType.equals("本校均值")){
            paras2.put("schoolcode",10593);

            paras2.put("year",2018);
            list2 = subjectDao.getNew高层次人才统计(paras2);
            map2 = DatabaseDataUtil.calulateAvgAndSelfValue(leftSubjectCode, list2);
            double val18 = map2.get("avg");

            paras2.put("year",2017);
            list3 = subjectDao.getNew高层次人才统计(paras2);
            map3 = DatabaseDataUtil.calulateAvgAndSelfValue(leftSubjectCode, list3);
            double val17 = map3.get("avg");

            val2 = val17 == 0 ? 0 : val18/val17*100;

        }else if(rightType.equals("本校学科")){
            paras2.put("schoolcode",10593);

            paras2.put("year",2018);
            list2 = subjectDao.getNew高层次人才统计(paras2);
            map2 = DatabaseDataUtil.calulateAvgAndSelfValue(rightSubjectCode, list2);
            double val18 = map2.get("val");

            paras2.put("year",2017);
            list3 = subjectDao.getNew高层次人才统计(paras2);
            map3 = DatabaseDataUtil.calulateAvgAndSelfValue(rightSubjectCode, list3);
            double val17 = map3.get("val");

            val2 = val17 == 0 ? 0 : val18/val17*100;

        }else{
            paras2.put("schoolcode",rightSchoolCode);

            paras2.put("year",2018);
            list2 = subjectDao.getNew高层次人才统计(paras2);
            map2 = DatabaseDataUtil.calulateAvgAndSelfValue(rightSubjectCode, list2);
            double val18 = map2.get("val");

            paras2.put("year",2017);
            list3 = subjectDao.getNew高层次人才统计(paras2);
            map3 = DatabaseDataUtil.calulateAvgAndSelfValue(rightSubjectCode, list3);
            double val17 = map3.get("val");

            val2 = val17 == 0 ? 0 : val18/val17*100;
        }

        Item item1 = new Item();
        item1.setItemName("高层次人才");
        item1.setItemValue(val2);
        rightItemList.add(item1);

        String[] arr = new String[]{"科研项目","成果获奖","学术论文","人才培养","平台建设"};
        for (String s : arr) {
            Item item = new Item();
            item.setItemName(s);
            item.setItemValue(50+Math.random()*50);
            rightItemList.add(item);
        }

        rightItem.setItemList(rightItemList);

        return rightItem;
    }

    private Columns getTableColumns(){
        Columns columns = new Columns();
        List<Column> columnList = new ArrayList<>();
        //---------------
        Column column1 = new Column();
        column1.setText("指标维度");
        column1.setValue("indicator");
        columnList.add(column1);

        //---------------
        Column column2 = new Column();
        column2.setText("年份");
        column2.setValue("year");
        columnList.add(column2);

        //---------------
        Column column3 = new Column();
        column3.setText("本校数据");
        column3.setValue("schoolval");
        columnList.add(column3);

        //---------------
        Column column4 = new Column();
        column4.setText("标杆数据");
        column4.setValue("fschoolval");
        columnList.add(column4);

        //---------------
        Column column5 = new Column();
        column5.setText("前三中值");
        column5.setValue("middlethree");
        columnList.add(column5);

        //---------------
        Column column6 = new Column();
        column6.setText("前5%值");
        column6.setValue("middle5percent");
        columnList.add(column6);

        //---------------
        Column column7 = new Column();
        column7.setText("前10%值");
        column7.setValue("middle10percent");
        columnList.add(column7);

        //---------------
        Column column8 = new Column();
        column8.setText("前25%值");
        column8.setValue("middle25percent");
        columnList.add(column8);

        columns.setColumns(columnList);

        return columns;
    }

    private List<SubjectCompareTableData> getTableDatas(String leftSubjectCode, String rightType, String rightSchoolCode, String rightSubjectCode){
        Map<String,Object> paras = new HashMap<>();
        paras.put("leftSubjectCode",leftSubjectCode);
        if(!rightType.equals("本校均值")){
            paras.put("rightSchoolCode",rightSchoolCode);
            paras.put("rightSubjectCode",rightSubjectCode);
        }
        List<Map> mapList = subjectDao.getNew本校学科外校学科高层次人才分类统计(paras);

        List<SubjectCompareTableData> datas = new ArrayList<>();
        String lastIndicator="";
        for (Map map : mapList) {
            String nowIndicator = map.get("type").toString();
            SubjectCompareTableData subjectCompareTableData = new SubjectCompareTableData();
            if(!map.get("type").toString().equals(lastIndicator)){
                lastIndicator = nowIndicator;

                subjectCompareTableData.setIndicator(nowIndicator);
                subjectCompareTableData.setYear(map.get("year").toString());
                subjectCompareTableData.setSchoolval(Double.valueOf(map.get("本校数据").toString()));
                subjectCompareTableData.setFschoolval(Double.valueOf(map.get("标杆数据").toString()));
                subjectCompareTableData.setMiddlethree(5.0);
                subjectCompareTableData.setMiddle5percent(3.0);
                subjectCompareTableData.setMiddle10percent(2.0);
                subjectCompareTableData.setMiddle25percent(2.0);

                datas.add(subjectCompareTableData);
            }else{
                for (SubjectCompareTableData data1 : datas) {
                    if(data1.getIndicator().equals(nowIndicator)){

                        SubjectCompareTableChild subjectCompareTableChild = new SubjectCompareTableChild();
                        subjectCompareTableChild.setIndicator(data1.getIndicator());
                        subjectCompareTableChild.setYear(map.get("year").toString());
                        subjectCompareTableChild.setSchoolval(1+Math.random()*10);
                        subjectCompareTableChild.setSchoolval(1+Math.random()*10);
                        subjectCompareTableChild.setMiddlethree(5.0);
                        subjectCompareTableChild.setMiddle5percent(3.0);
                        subjectCompareTableChild.setMiddle10percent(2.0);
                        subjectCompareTableChild.setMiddle25percent(2.0);

                        if(data1.getSubjectCompareTableChildList().size() > 0){
                            List<SubjectCompareTableChild> subjectCompareTableChildList = data1.getSubjectCompareTableChildList();
                            subjectCompareTableChildList.add(subjectCompareTableChild);
                            subjectCompareTableData.setSubjectCompareTableChildList(subjectCompareTableChildList);
                        }else{
                            List<SubjectCompareTableChild> subjectCompareTableChildList = new ArrayList<>();
                            subjectCompareTableChildList.add(subjectCompareTableChild);
                            subjectCompareTableData.setSubjectCompareTableChildList(subjectCompareTableChildList);
                        }
                    }
                }
                datas.add(subjectCompareTableData);
            }
        }
        if(datas.size()<=0){
            String[] indicators = new String[]{"万人计划","新世纪优秀人才","百千万人才工程","省级高层次人才","省部级突出贡献专家"};

            String[] years = new String[]{"2018","2017","2016"};
            for (String indicator : indicators) {
                SubjectCompareTableData subjectCompareTableData = new SubjectCompareTableData();
                subjectCompareTableData.setIndicator(indicator);
                subjectCompareTableData.setYear("2018");
                subjectCompareTableData.setSchoolval(1+Math.random()*10);
                subjectCompareTableData.setFschoolval(1+Math.random()*10);
                subjectCompareTableData.setMiddlethree(5.0);
                subjectCompareTableData.setMiddle5percent(3.0);
                subjectCompareTableData.setMiddle10percent(2.0);
                subjectCompareTableData.setMiddle25percent(2.0);

                List<SubjectCompareTableChild> compareTableChildList = new ArrayList<>();
                for (String year : years){
                    SubjectCompareTableChild subjectCompareTableChild = new SubjectCompareTableChild();
                    subjectCompareTableChild.setIndicator(indicator);
                    subjectCompareTableChild.setYear(year);
                    subjectCompareTableChild.setSchoolval(1+Math.random()*10);
                    subjectCompareTableChild.setFschoolval(1+Math.random()*10);
                    subjectCompareTableChild.setMiddlethree(5.0);
                    subjectCompareTableChild.setMiddle5percent(3.0);
                    subjectCompareTableChild.setMiddle10percent(2.0);
                    subjectCompareTableChild.setMiddle25percent(2.0);
                    compareTableChildList.add(subjectCompareTableChild);
                }
                subjectCompareTableData.setSubjectCompareTableChildList(compareTableChildList);
                datas.add(subjectCompareTableData);
            }
        }
        return datas;
    }
}
