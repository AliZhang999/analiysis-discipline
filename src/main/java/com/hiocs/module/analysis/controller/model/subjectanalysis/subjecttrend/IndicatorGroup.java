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
@ApiModel(value = "指标组")
public class IndicatorGroup {
    @ApiModelProperty(value = "指标")
    List<Indicator> indicatorList;
}
