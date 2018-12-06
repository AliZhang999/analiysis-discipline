package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学生情况")
public class XSQK {
    @ApiModelProperty(value = "本科生")
    private String 本科生;
    @ApiModelProperty(value = "专科生")
    private String 专科生;
    @ApiModelProperty(value = "硕士研究生")
    private String 硕士研究生;
    @ApiModelProperty(value = "博士研究生")
    private String 博士研究生;
    @ApiModelProperty(value = "留学生")
    private String 留学生;
    @ApiModelProperty(value = "招生人数")
    private String 招生人数;
    @ApiModelProperty(value = "毕业生人数")
    private String 毕业生人数;
    @ApiModelProperty(value = "就业人数")
    private String 就业人数;
    @ApiModelProperty(value = "本省就业生数")
    private String 本省就业生数;
}
