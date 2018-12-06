package com.hiocs.module.analysis.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseDataUtil {

    public static Map<String,Double> calulateAvgAndSelfValue(String subjectCode,List<Map> list){
        Map<String,Double> data = new HashMap<>();
        double x = 0;
        double avgTotal = 0.0;

        double max = 0;
        double min = 0;
        if(list.size()>0){
            Map maxMap = list.get(0);
            max = Double.valueOf(maxMap.get("人才数").toString());
            Map minMap = list.get(list.size()-1);
            min = Double.valueOf(minMap.get("人才数").toString());
        }
        for (Map map : list) {
            //total += Integer.valueOf(map.get("人才数").toString());
            int y = Integer.valueOf(map.get("人才数").toString());
            avgTotal += Double.valueOf(60.0 + (y - min) * 40.0 / (max - min));
            if(map.get("subject_code").toString().equals(subjectCode)){
                x = Double.valueOf(map.get("人才数").toString());
            }
        }
        double avg = Double.valueOf(avgTotal/list.size());
        double val = Double.valueOf(60.0+(x-min)*40.0/(max-min));
        data.put("avg",avg);
        data.put("val",val);
        return data;
    }
}
