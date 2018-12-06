package com.hiocs.module.analysis.controller.model.subjectanalysis.subjecttrend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "趋势分析echart数据")
public class SubjectTrendEchart {
    @ApiModelProperty(value = "指标组类型")
    private String type;
    @ApiModelProperty(value = "指标组数据")
    private List<SubjectTrendEchartItem> subjectTrendEchartItemList;
}
