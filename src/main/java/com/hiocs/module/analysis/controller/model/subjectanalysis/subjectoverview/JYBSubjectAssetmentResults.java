package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "教育部评估结果")
public class JYBSubjectAssetmentResults {
    @ApiModelProperty(value = "评估批次")
    private String 评估轮次;
    @ApiModelProperty(value = "教育部批次评估结果")
    private JYBSubjectAssetmentResult jybSubjectAssetmentResult;
}
