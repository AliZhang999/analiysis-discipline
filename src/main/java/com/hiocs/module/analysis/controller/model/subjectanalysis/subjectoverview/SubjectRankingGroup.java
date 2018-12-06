package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectoverview;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/*
    学科全景/学科排名
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学科排名组")
public class SubjectRankingGroup {
    @ApiModelProperty(value = "学科排名")
    private List<SubjectRanking> subjectRankings;
}
