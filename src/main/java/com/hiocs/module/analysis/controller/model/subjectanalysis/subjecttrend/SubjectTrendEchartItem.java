package com.hiocs.module.analysis.controller.model.subjectanalysis.subjecttrend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "指标组数据")
public class SubjectTrendEchartItem {
    @ApiModelProperty(value = "学科代码")
    private String subject_code;
    @ApiModelProperty(value = "学科名称")
    private String subject_name;
    @ApiModelProperty(value = "指标类型")
    private String type;
    @ApiModelProperty(value = "18年数据")
    private String 人才数2018;
    @ApiModelProperty(value = "17年数据")
    private String 人才数2017;
    @ApiModelProperty(value = "16年数据")
    private String 人才数2016;
}
