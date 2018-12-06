package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "雷达图指标")
public class RadarIndicator {
    @ApiModelProperty(value = "指标名")
    private String name;
    @ApiModelProperty(value = "指标最大值")
    private Double max;
}
