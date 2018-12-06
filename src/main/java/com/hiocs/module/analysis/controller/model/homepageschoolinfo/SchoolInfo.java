package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "首页学校信息")
public class SchoolInfo {
    private BXTJ bxtj;
    private GXQK gxqk;
    private JXCG jxcg;
    private KYSP kysp;
    private SZQK szqk;
    private XKZY xkzy;
    private XSQK xsqk;
}
