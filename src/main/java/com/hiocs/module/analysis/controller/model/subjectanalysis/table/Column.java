package com.hiocs.module.analysis.controller.model.subjectanalysis.table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "表头")
public class Column {
    @ApiModelProperty(value = "名称")
    private String text;
    @ApiModelProperty(value = "绑定数据名")
    private String value;
    @ApiModelProperty(value = "子表头")
    private List<Child> children;
}
