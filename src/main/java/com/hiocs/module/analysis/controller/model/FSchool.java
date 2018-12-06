package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "对标学校")
public class FSchool {
    @ApiModelProperty(value = "学校代码")
    private String schoolcode;
    @ApiModelProperty(value = "学校名称")
    private String schoolname;
}
