package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "师资情况")
public class SZQK {
    @ApiModelProperty(value = "教职工人数")
    private String 教职工人数;
    @ApiModelProperty(value = "实验师资")
    private String 实验师资;
    @ApiModelProperty(value = "高层次人才总数")
    private String 高层次人才总数;
    @ApiModelProperty(value = "折合学生数")
    private String 折合学生数;
    @ApiModelProperty(value = "上课教授数")
    private String 上课教授数;
    @ApiModelProperty(value = "教授总数")
    private String 教授总数;
    @ApiModelProperty(value = "专任教师数")
    private String 专任教师数;
    @ApiModelProperty(value = "博硕专任教师数")
    private String 博硕专任教师数;
    @ApiModelProperty(value = "其他教师总数")
    private String 其他教师总数;
    @ApiModelProperty(value = "生师比")
    private String 生师比;
    @ApiModelProperty(value = "博硕覆盖率")
    private String 博硕覆盖率;
    @ApiModelProperty(value = "教授上台讲课比例")
    private String 教授上台讲课比例;
}
