/**
 * 
 */
package com.github.acticfox.api.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONType;
import com.github.acticfox.api.enums.Sex;
import com.github.acticfox.common.api.BaseObject;
import com.github.acticfox.common.api.annotation.CacheType;
import com.github.acticfox.common.api.annotation.FieldType;
import com.github.acticfox.common.api.annotation.rpclog.SecurityField;
import com.github.acticfox.common.api.enums.CacheTypeEnum;
import com.github.acticfox.common.api.enums.FieldTypeEnum;
import com.github.acticfox.common.api.enums.SecurityFieldType;

import jakarta.validation.constraints.NotBlank;

/**
 * @author kfy
 *
 */
@JSONType
@CacheType(CacheTypeEnum.LRU_Redis)
public class Student extends BaseObject {

    private Long id;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "studentNo不能为空")
    private String studentNo;

    @FieldType(value = FieldTypeEnum.IntEnum)
    private Sex sex;

    private int idType;

    @SecurityField(fieldType = SecurityFieldType.IDNO)
    private String idNo;

    @SecurityField(ignore = true)
    private Integer score;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
