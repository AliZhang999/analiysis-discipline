package com.hiocs.module.analysis.dao;

import com.hiocs.module.analysis.config.MutipleSqlManager;
import com.hiocs.module.analysis.controller.model.FSchool;
import com.hiocs.module.analysis.controller.model.Subject;
import com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview.JYBSubjectAssetmentResult;
import com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview.SubjectRankingItem;
import com.hiocs.module.analysis.controller.model.subjectanalysis.subjecttrend.IndicatorItem;
import com.hiocs.module.analysis.controller.model.subjectanalysis.subjecttrend.SubjectTrendEchartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SubjectDao {

    @Autowired
    MutipleSqlManager mutipleSqlManager;

    public List<Subject> getNewSubjectList() {
        return mutipleSqlManager.getBaseSQLManager().select("Subject.subjectList", Subject.class);
    }

    public List<JYBSubjectAssetmentResult> getNewSubjectAssessment(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.newSubjectAssessment", JYBSubjectAssetmentResult.class, map);
    }

    public List<Map> getNewSubjectInfo(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.newSubjectInfo", Map.class, map);
    }

    public List<Map> getNew高层次人才统计(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new高层次人才统计", Map.class, map);
    }

    public List<FSchool> get外校列表(){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new外校列表", FSchool.class);
    }

    public List<SubjectRankingItem> getNew各学科第四轮学科排名情况(){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new各学科第四轮学科排名情况", SubjectRankingItem.class);
    }

    public List<IndicatorItem> getNew各学科高层次人才类型(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new各学科高层次人才类型", IndicatorItem.class, map);
    }

    public List<SubjectTrendEchartItem> getNew各学科各类型高层次人才三年数据(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new各学科各类型高层次人才三年数据", SubjectTrendEchartItem.class, map);
    }

    public List<Map> getNew单个学科分类型高层次三年数据统计(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new单个学科分类型高层次三年数据统计", Map.class, map);
    }

    public List<Map> getNew单个学科高层次人才分类统计(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new单个学科高层次人才分类统计", Map.class, map);
    }

    public List<Map> getNew本校学科外校学科高层次人才分类统计(Map<String, Object> map){
        return mutipleSqlManager.getBaseSQLManager().select("Subject.new本校学科外校学科高层次人才分类统计", Map.class, map);
    }
}
