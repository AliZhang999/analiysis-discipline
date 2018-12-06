package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/*
    学科全景/学科信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科信息")
public class SubjectInfo {

    @ApiModelProperty(value = "学科代码")
    private String subjectCode;

    @ApiModelProperty(value = "学科名称")
    private String subjectName;

    @ApiModelProperty(value = "授权级别")
    private String 授权级别;

    @ApiModelProperty(value = "软科排名")
    private String 软科排名;

    @ApiModelProperty(value = "教育部评估结果")
    private List<JYBSubjectAssetmentResults> jybSubjectAssetmentResults;
}
