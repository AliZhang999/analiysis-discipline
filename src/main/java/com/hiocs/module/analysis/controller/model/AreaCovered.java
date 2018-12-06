package com.hiocs.module.analysis.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "占地面积")
public class AreaCovered {
    @ApiModelProperty(value = "占地总面积")
    private String 占地总面积;
    @ApiModelProperty(value = "占地面积学校产权")
    private String 占地面积学校产权;
    @ApiModelProperty(value = "学校产权绿化用地")
    private String 学校产权绿化用地;
    @ApiModelProperty(value = "学校产权运动场地")
    private String 学校产权运动场地;
    @ApiModelProperty(value = "占地非学校产权")
    private String 占地非学校产权;
    @ApiModelProperty(value = "非学校产权独立使用")
    private String 非学校产权独立使用;
    @ApiModelProperty(value = "非学校产权共同使用")
    private String 非学校产权共同使用;
    @ApiModelProperty(value = "非学校产权绿化用地")
    private String 非学校产权绿化用地;

}
