package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.*;
import com.hiocs.module.analysis.dao.GXQKdrillDao;
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
@RequestMapping("home/gxqkdrill")
@Api(tags = "首页高校情况下钻")
public class GXQKdrillController {

    @Autowired
    GXQKdrillDao gxqKdrillDao;

    @GetMapping("dzdw")
    @ApiOperation(value = "党政单位")
    public List<SchoolUnit> getDZDWDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");
        List<SchoolUnit> data = gxqKdrillDao.getSchoolUnitDrillData("GXQKdrill.首页高校情况党政单位钻取", SchoolUnit.class, paras);
        return data;
    }

    @GetMapping("jxdw")
    @ApiOperation(value = "教学单位")
    public List<SchoolUnit> getJXDWDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");
        List<SchoolUnit> data = gxqKdrillDao.getSchoolUnitDrillData("GXQKdrill.首页高校情况教学单位钻取", SchoolUnit.class, paras);
        return data;
    }

    @GetMapping("zdxk")
    @ApiOperation(value = "重点学科")
    public List<KeyDisciplines> getZDXKDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");
        List<KeyDisciplines> data = gxqKdrillDao.getKeyDisciplinesDrillData("GXQKdrill.首页高校情况重点学科钻取", KeyDisciplines.class, paras);
        return data;
    }

    @GetMapping("zxss")
    @ApiOperation(value = "在校生数")
    public List<StudentsNumber> getZXSSDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");
        List<StudentsNumber> data = gxqKdrillDao.getStudentsNumberDrillData("GXQKdrill.首页高校情况在校生数钻取", StudentsNumber.class, paras);
        return data;
    }

    @GetMapping("jzgzgxw")
    @ApiOperation(value = "教职工总数最高学位")
    public List<HighestDegree> getJZGZGXWDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");
        List<HighestDegree> data = gxqKdrillDao.getHighestDegreeDrillData("GXQKdrill.首页高校情况教职工总数最高学位钻取", HighestDegree.class, paras);
        return data;
    }

    @GetMapping("jzgzyjszc")
    @ApiOperation(value = "职工总数专业技术职称")
    public List<ProfessionalTitles> getJZGZTJSZCDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");
        List<ProfessionalTitles> data = gxqKdrillDao.getProfessionalTitlesDrillData("GXQKdrill.首页高校情况教职工总数专业技术职称钻取", ProfessionalTitles.class, paras);
        return data;
    }

    @GetMapping("zzdmj")
    @ApiOperation(value = "总占地面积")
    public List<AreaCovered> getZZDMJDrillData(String year){
        Map<String,Object> paras = new HashMap<>();
        paras.put("year",year);
        paras.put("sqlNoParam","true");
        List<AreaCovered> data = gxqKdrillDao.getAreaCoveredDrillData("GXQKdrill.首页高校情况总占地面积钻取", AreaCovered.class, paras);
        return data;
    }

}
