package com.hiocs.module.analysis.dao;

import com.hiocs.module.analysis.config.MutipleSqlManager;
import com.hiocs.module.analysis.controller.model.homepageschoolinfo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class HomePageInfoDao {

    @Autowired
    MutipleSqlManager mutipleSqlManager;

    public List<GXQK> getGXQKData(String sqlId, Class<GXQK> gxqkClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<GXQK> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, gxqkClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, gxqkClass, paras);
        }
        return result;
    }

    public List<JXCG> getJXCGData(String sqlId, Class<JXCG> jxcgClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<JXCG> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, jxcgClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, jxcgClass, paras);
        }
        return result;
    }

    public List<BXTJ> getBXTJData(String sqlId, Class<BXTJ> bxtjClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<BXTJ> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, bxtjClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, bxtjClass, paras);
        }
        return result;
    }

    public List<XSQK> getXSQKData(String sqlId, Class<XSQK> xsqkClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<XSQK> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, xsqkClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, xsqkClass, paras);
        }
        return result;
    }

    public List<SZQK> getSZQKData(String sqlId, Class<SZQK> szqkClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<SZQK> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, szqkClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, szqkClass, paras);
        }
        return result;
    }

    public List<XKZY> getXKZYData(String sqlId, Class<XKZY> xkzyClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<XKZY> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, xkzyClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, xkzyClass, paras);
        }
        return result;
    }

    public List<KYSP> getKYSPData(String sqlId, Class<KYSP> kyspClass, Map<String, Object> paras) {
        paras.remove("sqlNoParam");
        String year = paras.get("year").toString();
        List<KYSP> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, kyspClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, kyspClass, paras);
        }
        return result;
    }
}
