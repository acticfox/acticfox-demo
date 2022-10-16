/**
 * 
 */
package com.github.acticfox.provider.service;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.DubboService;

import com.github.acticfox.api.model.Student;
import com.github.acticfox.api.service.StudentService;
import com.github.acticfox.common.api.idempotence.Idempotent;
import com.github.acticfox.common.api.result.ResultDTO;
import com.github.acticfox.distributed.common.DistributedLockTemplate;
import com.github.acticfox.distributed.common.IdempotentTemplate;
import com.github.acticfox.distributed.idempotent.utils.IdempotentRequest;
import com.github.acticfox.provider.biz.StudentBiz;

/**
 * @author kfy
 *
 */
@DubboService
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentBiz studentBiz;

    @Resource
    private IdempotentTemplate idempotentTemplate;

    @Override
    // 幂等注解示例
    @Idempotent(spelKey = "#student.studentNo", firstLevelExpireDate = 7, secondLevelExpireDate = 30)
    public ResultDTO<?> saveStudent(Student student) {
        studentBiz.saveStudent(student);
        return ResultDTO.buildSuccessResult();
    }

    @Override
    public ResultDTO<Student> queryStudentByStudentNo(String studentNo) {

        return ResultDTO.buildSuccessResult(studentBiz.queryStudentByStudentNo(studentNo));
    }

    @Override
    public ResultDTO<?> updateStudentScore(String studentNo, Integer score) {
        // 分布式锁控制sample
        DistributedLockTemplate.execute(studentNo, () -> studentBiz.updateStudentScore(studentNo, score));

        return ResultDTO.buildSuccessResult();
    }

    @Override
    public ResultDTO<?> deleteStudentByStudentNo(String studentNo) {
        IdempotentRequest idRequest = new IdempotentRequest();
        idRequest.setTxId(studentNo);
        idRequest.setParams(studentNo);
        // 幂等编程式sample
        idempotentTemplate.execute(idRequest, () -> studentBiz.deleteStudentByStudentNo(studentNo));

        return ResultDTO.buildSuccessResult();
    }

    @Override
    public ResultDTO<?> deleteStudentById(Long idNo) {
        studentBiz.deleteStudentById(idNo);
        return ResultDTO.buildSuccessResult();
    }

}
