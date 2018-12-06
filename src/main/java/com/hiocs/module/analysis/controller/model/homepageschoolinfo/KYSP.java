package com.hiocs.module.analysis.controller.model.homepageschoolinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "科研水平")
public class KYSP {
    @ApiModelProperty(value = "专利著作权数")
    private String 专利著作权数;
    @ApiModelProperty(value = "出版专著数")
    private String 出版专著数;
    @ApiModelProperty(value = "发表论文数")
    private String 发表论文数;
    @ApiModelProperty(value = "纵向项目数")
    private String 纵向项目数;
    @ApiModelProperty(value = "横向项目数")
    private String 横向项目数;
    @ApiModelProperty(value = "纵向项目经费")
    private String 纵向项目经费;
    @ApiModelProperty(value = "横向项目经费")
    private String 横向项目经费;
}
