package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学校单位")
public class SchoolUnit {
    @ApiModelProperty(value = "单位号")
    private String 单位号;
    @ApiModelProperty(value = "单位名称")
    private String 单位名称;
    @ApiModelProperty(value = "单位负责人")
    private String 单位负责人;
}
