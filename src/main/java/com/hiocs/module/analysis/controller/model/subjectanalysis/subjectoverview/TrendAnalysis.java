package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    学科全景/趋势分析
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "趋势分析")
public class TrendAnalysis {
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "趋势分析结果")
    private List<TrendAnalysisItem> trendAnalysisItems;

}
