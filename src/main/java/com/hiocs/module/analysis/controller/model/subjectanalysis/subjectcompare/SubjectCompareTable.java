package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare;

import com.hiocs.module.analysis.controller.model.subjectanalysis.table.Columns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "表格")
public class SubjectCompareTable {
    @ApiModelProperty(value = "表头组")
    private Columns columns;
    @ApiModelProperty(value = "数据组")
    private List<SubjectCompareTableData> datas;
}
