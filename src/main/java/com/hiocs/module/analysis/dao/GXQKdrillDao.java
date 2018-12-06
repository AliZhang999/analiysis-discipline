package com.hiocs.module.analysis.dao;

import com.hiocs.module.analysis.config.MutipleSqlManager;
import com.hiocs.module.analysis.controller.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GXQKdrillDao {

    @Autowired
    MutipleSqlManager mutipleSqlManager;

    public List<SchoolUnit> getSchoolUnitDrillData(String sqlId, Class<SchoolUnit> schoolUnitClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<SchoolUnit> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, schoolUnitClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, schoolUnitClass, paras);
        }
        return result;
    }

    public List<KeyDisciplines> getKeyDisciplinesDrillData(String sqlId, Class<KeyDisciplines> keyDisciplinesClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<KeyDisciplines> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, keyDisciplinesClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, keyDisciplinesClass, paras);
        }
        return result;
    }

    public List<StudentsNumber> getStudentsNumberDrillData(String sqlId, Class<StudentsNumber> studentsNumberClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<StudentsNumber> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, studentsNumberClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, studentsNumberClass, paras);
        }
        return result;
    }

    public List<HighestDegree> getHighestDegreeDrillData(String sqlId, Class<HighestDegree> highestDegreeClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<HighestDegree> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, highestDegreeClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, highestDegreeClass, paras);
        }
        return result;
    }

    public List<ProfessionalTitles> getProfessionalTitlesDrillData(String sqlId, Class<ProfessionalTitles> professionalTitlesClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<ProfessionalTitles> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, professionalTitlesClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, professionalTitlesClass, paras);
        }
        return result;
    }

    public List<AreaCovered> getAreaCoveredDrillData(String sqlId, Class<AreaCovered> areaCoveredClass, Map<String, Object> paras) {
        String year = paras.get("year").toString();
        List<AreaCovered> result = null;
        if (year.equals("2016")){
            result = mutipleSqlManager.getMaster2016SQLManager().select(sqlId, areaCoveredClass, paras);
        }else if (year.equals("2017")){
            result = mutipleSqlManager.getMaster2017SQLManager().select(sqlId, areaCoveredClass, paras);
        }
        return result;

    }
}
