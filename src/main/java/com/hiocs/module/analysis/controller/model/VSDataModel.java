package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "对标")
public class VSDataModel {
    @ApiModelProperty(value = "学校名称")
    private String 学校名称;
    @ApiModelProperty(value = "学校值")
    private String 学校值;
}
