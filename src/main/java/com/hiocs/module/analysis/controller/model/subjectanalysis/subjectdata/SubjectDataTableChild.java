package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科数据子数据")
public class SubjectDataTableChild {
    @ApiModelProperty(value = "指标名称")
    private String indicator;

    @ApiModelProperty(value = "总量年份")
    private String zlyear;
    @ApiModelProperty(value = "总量数据")
    private Double zldata;
    @ApiModelProperty(value = "总量排名")
    private Integer zlranking;
    @ApiModelProperty(value = "总量得分")
    private Double zlscore;
    @ApiModelProperty(value = "总量得分百分比")
    private Double zlscorepercent;

    @ApiModelProperty(value = "增量年份")
    private String zelyear;
    @ApiModelProperty(value = "增量数据")
    private Double zeldata;
    @ApiModelProperty(value = "增量排名")
    private Integer zelranking;
    @ApiModelProperty(value = "增量得分")
    private Double zelscore;
    @ApiModelProperty(value = "增量得分百分比")
    private Double zelscorepercent;

    @ApiModelProperty(value = "趋势")
    private String trend;

}
