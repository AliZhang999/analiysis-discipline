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
@ApiModel(value = "表头组")
public class Columns {
    @ApiModelProperty(value = "表头")
    private List<Column> columns;
}
