package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "数据对比")
public class SubjectCompare {
    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "本学科值")
    private Double subjectValue;

    @ApiModelProperty(value = "平均值")
    private Double AverageValue;
}
