package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "教学成果")
public class JXCG {
    @ApiModelProperty(value = "国家级教学成果奖")
    private String 国家级教学成果奖;
    @ApiModelProperty(value = "国家级教育教学研究与改革项目")
    private String 国家级教育教学研究与改革项目;
    @ApiModelProperty(value = "国家级本科教学工程")
    private String 国家级本科教学工程;
    @ApiModelProperty(value = "省部级本科教学工程")
    private String 省部级本科教学工程;
    @ApiModelProperty(value = "人才培养模式创新实验区")
    private String 人才培养模式创新实验区;
    @ApiModelProperty(value = "国家级教学基地")
    private String 国家级教学基地;
    @ApiModelProperty(value = "牵头建设国家级实践育人创新创业基地")
    private String 牵头建设国家级实践育人创新创业基地;
}
