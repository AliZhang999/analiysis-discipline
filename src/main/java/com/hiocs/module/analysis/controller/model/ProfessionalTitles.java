package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "专业技术职称")
public class ProfessionalTitles {
    @ApiModelProperty(value = "专业技术职称")
    private String 专业技术职称;
    @ApiModelProperty(value = "人数")
    private Integer 人数;
}
