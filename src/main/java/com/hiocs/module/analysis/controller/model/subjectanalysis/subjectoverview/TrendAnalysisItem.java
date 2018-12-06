package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "趋势分析结果")
public class TrendAnalysisItem {

    @ApiModelProperty(value = "年份")
    private String year;

    @ApiModelProperty(value = "值")
    private Double value;
}
