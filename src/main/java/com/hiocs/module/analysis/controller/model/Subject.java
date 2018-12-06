package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科")
public class Subject {
    @ApiModelProperty(value = "学科代码")
    private String subject_code;
    @ApiModelProperty(value = "学科名称")
    private String subject_name;
}
