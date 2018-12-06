package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "高校情况")
public class GXQK {
    @ApiModelProperty(value = "党政单位")
    private String 党政单位;
    @ApiModelProperty(value = "教学单位")
    private String 教学单位;
    @ApiModelProperty(value = "重点学科数")
    private String 重点学科数;
    @ApiModelProperty(value = "全日制在校生数")
    private String 全日制在校生数;
    @ApiModelProperty(value = "教职工总数")
    private String 教职工总数;
    @ApiModelProperty(value = "占地总面积")
    private String 占地总面积;
    @ApiModelProperty(value = "总建筑面积")
    private String 总建筑面积;
}
