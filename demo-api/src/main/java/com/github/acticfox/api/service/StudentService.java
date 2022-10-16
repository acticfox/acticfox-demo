/**
 * 
 */
package com.github.acticfox.api.service;

import com.github.acticfox.api.model.Student;
import com.github.acticfox.common.api.annotation.RpcValidator;
import com.github.acticfox.common.api.result.ResultDTO;

import jakarta.validation.Valid;

/**
 * @author kfy
 *
 */
@RpcValidator
public interface StudentService {

    @RpcValidator
    ResultDTO<?> saveStudent(@Valid Student student);

    ResultDTO<?> updateStudentScore(String studentNo, Integer score);

    ResultDTO<?> deleteStudentByStudentNo(String studentNo);

    ResultDTO<?> deleteStudentById(Long idNo);

    ResultDTO<Student> queryStudentByStudentNo(String studentNo);

}
