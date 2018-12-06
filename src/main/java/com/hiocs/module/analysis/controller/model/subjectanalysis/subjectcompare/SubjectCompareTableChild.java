package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科对比子数据项")
public class SubjectCompareTableChild {
    @ApiModelProperty(value = "指标名称")
    private String indicator;
    @ApiModelProperty(value = "年份")
    private String year;
    @ApiModelProperty(value = "本校数据")
    private Double schoolval;
    @ApiModelProperty(value = "标杆数据")
    private Double fschoolval;
    @ApiModelProperty(value = "前三中值")
    private Double middlethree;
    @ApiModelProperty(value = "前5%值")
    private Double middle5percent;
    @ApiModelProperty(value = "前10%值")
    private Double middle10percent;
    @ApiModelProperty(value = "前25%")
    private Double middle25percent;
}
