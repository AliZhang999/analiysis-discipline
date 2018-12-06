package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    教育部学科评估结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "教育部批次评估结果")
public class JYBSubjectAssetmentResult {

    @ApiModelProperty(value = "评估批次")
    private String 评估批次;

    @ApiModelProperty(value = "排名")
    private String 排名;

    @ApiModelProperty(value = "排名百分位")
    private String 排名百分位;

    @ApiModelProperty(value = "评估等级")
    private String 评估等级;

    @ApiModelProperty(value = "参评高校数")
    private String 参评高校数;
}
