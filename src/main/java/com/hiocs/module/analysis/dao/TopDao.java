package com.hiocs.module.analysis.dao;

import com.hiocs.module.analysis.config.MutipleSqlManager;
import com.hiocs.module.analysis.controller.model.VSDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TopDao {

    @Autowired
    MutipleSqlManager mutipleSqlManager;

    public List<VSDataModel> getVSDataBySqlIdWithParams(String sqlId, Map<String,Object> paras){
        String year = paras.get("year").toString();
        List<VSDataModel> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016_14schoolSQLManager().select(sqlId, VSDataModel.class, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017_14schoolSQLManager().select(sqlId, VSDataModel.class, paras);
        }
        return result;
    }
}
