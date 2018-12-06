package com.hiocs.module.analysis.controller;

import com.hiocs.module.analysis.controller.model.FSchool;
import com.hiocs.module.analysis.controller.model.Subject;
import com.hiocs.module.analysis.dao.SubjectDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("common")
@Api(tags = "通用接口")
public class CommonController {

    @Autowired
    SubjectDao baseDao;

    @GetMapping("subjectList")
    @ApiOperation(value = "学科列表")
    public List<Subject> getSchoolViewData(){
        return baseDao.getNewSubjectList();
    }

    @GetMapping("fschoolList")
    @ApiOperation(value = "外校列表")
    public List<FSchool> getFSchoolList(){
        return baseDao.get外校列表();
    }

}
