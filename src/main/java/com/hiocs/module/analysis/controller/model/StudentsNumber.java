package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学生数量")
public class StudentsNumber {
    @ApiModelProperty(value = "普通本科学生数")
    private Integer 普通本科学生数;
    @ApiModelProperty(value = "硕士研究生数全日制")
    private Integer 硕士研究生数全日制;
    @ApiModelProperty(value = "博士研究生数全日制")
    private Integer 博士研究生数全日制;
    @ApiModelProperty(value = "留学生数")
    private Integer 留学生数;
}
