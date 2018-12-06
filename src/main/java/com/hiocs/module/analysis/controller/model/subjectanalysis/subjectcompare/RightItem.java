package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "右列数据组")
public class RightItem {
    private List<Item> itemList;
}
