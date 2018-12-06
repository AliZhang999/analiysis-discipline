package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "雷达图数据")
public class RadarSeries {
    @ApiModelProperty(value = "数据")
    private List<Double> value;
    @ApiModelProperty(value = "名称")
    private String name;
}
