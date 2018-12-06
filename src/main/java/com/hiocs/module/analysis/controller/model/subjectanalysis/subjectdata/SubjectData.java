package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科数据")
public class SubjectData {
    @ApiModelProperty(value = "学科名称")
    private String subjectName;

    @ApiModelProperty(value = "echart图")
    private Echart echart;
}
