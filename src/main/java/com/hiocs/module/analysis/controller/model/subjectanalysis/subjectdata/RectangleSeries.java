package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "矩形图数据")
public class RectangleSeries {
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "数据")
    private Double value;
}
