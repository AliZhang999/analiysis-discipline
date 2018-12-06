package com.hiocs.module.analysis.controller.model.subjectanalysis.subjecttrend;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "指标")
public class Indicator {
    @ApiModelProperty(value = "指标类型")
    private String name;
    @ApiModelProperty(value = "指标集")
    private List<IndicatorItem> indicatorItemList;
}
