package com.hiocs.module.analysis.controller.model.subjectanalysis.subjecttrend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "趋势分析参数")
public class Trend {
    @ApiModelProperty(value = "学科代码")
    private String subjectCode;
    @ApiModelProperty(value = "指标类型")
    private String type;
    @ApiModelProperty(value = "指标项(多个指标项用,号分隔)")
    private String selects;
}
