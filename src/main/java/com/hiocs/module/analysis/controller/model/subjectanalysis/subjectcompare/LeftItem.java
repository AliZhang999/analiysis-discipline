package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "左列数据组")
public class LeftItem {
    private List<Item> itemList;
}
