/*
 * Copyright 2020 cecloud.com All right reserved. This software is the confidential and proprietary information of
 * cecloud.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with cecloud.com .
 */
package com.github.acticfox.provider.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.acticfox.api.model.Student;
import com.github.acticfox.common.api.util.AssertUtils;
import com.github.acticfox.provider.common.ExceptionCode;
import com.github.acticfox.provider.dao.StudentDAO;

/**
 * @Description: TODO
 * @author kfy Sep 8, 2020 2:02:11 PM
 * @version V1.0
 */
@Component
public class StudentBiz {

    @Resource
    private StudentDAO studentDAO;

    public int saveStudent(Student student) {

        return studentDAO.saveOrUpdate(student);
    }

    @Transactional
    public int updateStudentScore(String studentNo, Integer score) {
        Student student = studentDAO.queryStudentByStudentNo(studentNo);
        AssertUtils.assertTrue(student != null, ExceptionCode.STUDENT_NOT_EXIST);
        student.setScore(score);
        int effectCnt = studentDAO.update(student);

        return effectCnt;
    }

    public Student queryStudentByStudentNo(String studentNo) {
        return studentDAO.queryStudentByStudentNo(studentNo);
    }

    /**
     * 
     * @Description: deleteStudent
     * @param studentNo
     */
    @Transactional
    public int deleteStudentByStudentNo(String studentNo) {
        int effectCnt = studentDAO.deleteStudentByStudentNo(studentNo);

        return effectCnt;
    }

    @Transactional
    public int deleteStudentById(Long id) {
        int effectCnt = studentDAO.delete(id);

        return effectCnt;
    }

}
