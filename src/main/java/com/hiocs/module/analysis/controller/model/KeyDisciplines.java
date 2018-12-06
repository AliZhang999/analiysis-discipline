package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "重点学科")
public class KeyDisciplines {
    @ApiModelProperty(value = "学科代码")
    private String 学科代码;
    @ApiModelProperty(value = "重点学科名称")
    private String 重点学科名称;
    @ApiModelProperty(value = "级别")
    private String 级别;
}
