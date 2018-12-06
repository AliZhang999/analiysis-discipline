package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "排名结果")
public class SubjectRankingItem {
    @ApiModelProperty(value = "学科代码")
    private String 学科代码;

    @ApiModelProperty(value = "学科名称")
    private String 学科名称;

    @ApiModelProperty(value = "评估等级")
    private String 评估等级;

    @ApiModelProperty(value = "参评高校数")
    private String 参评高校数;

    @ApiModelProperty(value = "排名百分位")
    private String 排名百分位;

    @ApiModelProperty(value = "排名")
    private String 排名;
}
