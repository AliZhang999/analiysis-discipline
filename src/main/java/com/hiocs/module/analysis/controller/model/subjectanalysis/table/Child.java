package com.hiocs.module.analysis.controller.model.subjectanalysis.table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "子表头")
public class Child {
    @ApiModelProperty(value = "名称")
    private String text;
    @ApiModelProperty(value = "绑定数据名")
    private String value;
}
