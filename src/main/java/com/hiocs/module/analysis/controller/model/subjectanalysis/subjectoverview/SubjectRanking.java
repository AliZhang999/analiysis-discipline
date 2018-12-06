package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    学科全景/学科排名
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科排名")
public class SubjectRanking {
    @ApiModelProperty(value = "排名类型")
    private String 排名类型;
    @ApiModelProperty(value = "排名结果")
    private List<SubjectRankingItem> subjectRankingItems;
}
