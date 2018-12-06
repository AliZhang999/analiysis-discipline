package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "数据")
public class Item {
    @ApiModelProperty(value = "名称")
    private String itemName;
    @ApiModelProperty(value = "值")
    private Double itemValue;
}
