package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/*
    学科全景/趋势分析组
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "趋势分析组")
public class TrendAnalysisGroup {
    private List<TrendAnalysis> trendAnalyses;
}
