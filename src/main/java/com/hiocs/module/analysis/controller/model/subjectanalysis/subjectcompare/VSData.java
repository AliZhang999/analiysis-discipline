package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "对比数据")
public class VSData {
    @ApiModelProperty(value = "参数原始数据")
    private Map<String,Object> oparam;
    @ApiModelProperty(value = "左列显示名称")
    private String leftName;
    @ApiModelProperty(value = "右列显示名称")
    private String rightName;
    @ApiModelProperty(value = "左列数据组")
    private LeftItem leftItem;
    @ApiModelProperty(value = "右列数据组")
    private RightItem rightItem;
}
