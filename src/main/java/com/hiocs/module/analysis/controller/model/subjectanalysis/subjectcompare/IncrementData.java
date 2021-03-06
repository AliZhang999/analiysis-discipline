package com.hiocs.module.analysis.controller.model.subjectanalysis.subjectcompare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncrementData {
    private LeftItem leftItem;
    private RightItem rightItem;
}
