package org.github.zhengchalei.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class R<T> implements Serializable {
    protected Boolean success = true;
    protected String errorMessage = "";
    protected Integer errorCode;
    //   SILENT = "SILENT",
    //  WARN_MESSAGE = "WARN",
    //  ERROR_MESSAGE = "ERROR",
    //  NOTIFICATION = 'NOTIFICATION',
    //  REDIRECT = 'REDIRECT',
    protected String showType = "";
    protected T data = null;

    public static <T> R<T> ok() {
        return new R<T>();
    }

    public static <T> R<T> async() {
        return new R<T>();
    }

    public static <T> R<T> data(T data) {
        return new R<T>().setData(data);
    }

    public static <T> R<T> fail(String message) {
        return new R<T>().setSuccess(false).setShowType("ERROR").setErrorMessage(message);
    }

    public static <T> R<T> error() {
        return R.fail("服务器开小差了, 请稍后重试!");
    }

    public static <T> R<T> bool(boolean bool) {
        return bool ? R.ok() : R.fail("操作失败, 请重试!");
    }

}
