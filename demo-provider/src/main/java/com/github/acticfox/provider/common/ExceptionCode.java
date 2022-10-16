/**
 * 
 */
package com.github.acticfox.provider.common;

import org.apache.commons.lang3.StringUtils;

import com.github.acticfox.common.api.enums.ExceptionCodeEnum;

/**
 * @author kfy
 *
 */
public enum ExceptionCode implements ExceptionCodeEnum {

    /**
     * 参数非法
     */
    STUDENT_NOT_EXIST("Student.NotExist", "学生不存在", false);

    private String errCode;

    private String errDesc;

    private boolean allowRetry;

    ExceptionCode(String errCode, String errDesc, boolean allowRetry) {
        this.errCode = errCode;
        this.errDesc = errDesc;
        this.allowRetry = allowRetry;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    public void moreDesc(String desc) {
        if (StringUtils.isBlank(desc)) {
            return;
        }
        this.errDesc = desc;
    }

    @Override
    public String getErrMsg() {
        return errDesc;
    }

    public boolean isAllowRetry() {
        return allowRetry;
    }

    @Override
    public boolean isRetriable() {
        return allowRetry;
    }

}
