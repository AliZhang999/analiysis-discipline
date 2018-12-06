package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "办学条件")
public class BXTJ {
    @ApiModelProperty(value = "教育经费总额")
    private String 教育经费总额;
    @ApiModelProperty(value = "教学经费总额")
    private String 教学经费总额;
    @ApiModelProperty(value = "教学经费支出")
    private String 教学经费支出;
    @ApiModelProperty(value = "实践教学经费")
    private String 实践教学经费;
    @ApiModelProperty(value = "固定资产总值")
    private String 固定资产总值;
    @ApiModelProperty(value = "教学仪器设备值")
    private String 教学仪器设备值;
}
