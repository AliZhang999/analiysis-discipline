package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "最高学位")
public class HighestDegree {
    @ApiModelProperty(value = "最高学位")
    private String 最高学位;
    @ApiModelProperty(value = "人数")
    private Integer 人数;
}
