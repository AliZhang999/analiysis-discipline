package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科专业")
public class XKZY {
    @ApiModelProperty(value = "本科专业总数")
    private String 本科专业总数;
    @ApiModelProperty(value = "重点学科数")
    private String 重点学科数;
    @ApiModelProperty(value = "博士学位授权一级学科点")
    private String 博士学位授权一级学科点;
    @ApiModelProperty(value = "博士学位授权二级学科点")
    private String 博士学位授权二级学科点;
    @ApiModelProperty(value = "硕士学位授权一级学科点")
    private String 硕士学位授权一级学科点;
    @ApiModelProperty(value = "硕士学位授权二级学科点")
    private String 硕士学位授权二级学科点;
    @ApiModelProperty(value = "博士后流动站")
    private String 博士后流动站;
}
