/**
 * 
 */
package com.github.acticfox.provider.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.acticfox.api.enums.Sex;
import com.github.acticfox.api.model.Student;
import com.github.acticfox.base.mybatis.orm.dao.BaseDao;
import com.github.acticfox.base.mybatis.orm.filter.Filter;
import com.github.acticfox.base.mybatis.orm.filter.impl.FilterFactory;

/**
 * @author kfy
 *
 */
@Repository
public class StudentDAO extends BaseDao<Student> {

    public Student queryStudentByStudentNo(String studentNo) {
        Filter filter = FilterFactory.getSimpleFilter("studentNo", studentNo);

        return queryOne(filter);
    }

    public List<Student> queryStudentList(Sex sex) {
        Filter filter = FilterFactory.getSimpleFilter("sex", sex);

        return queryList(filter);
    }

    public int deleteStudentByStudentNo(String studentNo) {

        return updateDAO.execute("Student-manual.deleteByStudentNo", studentNo);
    }

}
