package com.github.acticfox.consumer;

import java.util.Date;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.acticfox.api.enums.Sex;
import com.github.acticfox.api.model.Student;
import com.github.acticfox.api.service.StudentService;
import com.github.acticfox.common.api.result.ResultDTO;

/**
 * 类TairController.java的实现描述：TODO 类实现描述
 * 
 * @author fanyong.kfy Jan 3, 2019 2:25:10 PM
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @DubboReference
    StudentService studentService;

    @RequestMapping("/save")
    @ResponseBody
    public ResultDTO saveStudent(String studentNo, String idNo, String name, int score) {
        Student student = new Student();
        student.setIdNo(idNo);
        student.setName(name);
        student.setScore(score);
        student.setIdType(0);
        student.setSex(Sex.BOY);
        student.setStudentNo(studentNo);
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        ResultDTO<?> result = studentService.saveStudent(student);

        return result;
    }

    @RequestMapping("/updateStudentScore")
    @ResponseBody
    public ResultDTO updateStudentScore(String studentNo, int score) {
        ResultDTO<?> result = studentService.updateStudentScore(studentNo, score);

        return result;
    }

    @RequestMapping("/get")
    @ResponseBody
    public ResultDTO queryStudent(String studentNo) {
        ResultDTO<Student> result = studentService.queryStudentByStudentNo(studentNo);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultDTO deleteStudentByStudentNo(String studentNo) {
        ResultDTO<?> result = studentService.deleteStudentByStudentNo(studentNo);
        return result;
    }

    @RequestMapping("/deleteId")
    @ResponseBody
    public ResultDTO deleteStudentId(Long id) {
        ResultDTO<?> result = studentService.deleteStudentById(id);
        return result;
    }

}
