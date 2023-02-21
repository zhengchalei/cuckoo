package org.github.zhengchalei.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    private Boolean success = true;

    /**
     * 状态码
     */
    private Integer code = 200;

    /**
     * 消息
     */
    private String message = "";
    /**
     * 错误消息
     */
    private String errorMessage = "";
    /**
     * 数据
     */
    private T data = null;

    /**
     * ok
     *
     * @return {@link R}
     */
    public static <T> R<T> ok() {
        return new R<T>().setMessage("操作成功");
    }

    /**
     * ok
     *
     * @return {@link R}
     */
    public static <T> R<T> async() {
        return new R<T>().setMessage("操作成功, 请等待后台操作完成!");
    }

    /**
     * 页面
     *
     * @param data 数据
     * @return {@link R<RPage<T>>}
     */
    public static <T> R<RPage<T>> page(org.springframework.data.domain.Page<T> data) {
        RPage<T> rPage = new RPage<>();
        rPage.setTotal(data.getTotalElements());
        rPage.setList(data.getContent());
        return new R<RPage<T>>().setData(rPage);
    }

    /**
     * 分页数据
     *
     * @param data  数据
     * @param total 总计
     * @return {@link R<RPage<T>>}
     */
    public static <T> R<RPage<T>> page(List<T> data, long total) {
        RPage<T> rPage = new RPage<>();
        rPage.setTotal(total);
        rPage.setList(data);
        return new R<RPage<T>>().setData(rPage);
    }


    /**
     * 数据
     *
     * @param data 数据
     * @return {@link R}
     */
    public static <T> R<T> data(T data) {
        return new R<T>().setData(data);
    }

    /**
     * 失败
     *
     * @param message 消息
     * @return {@link R}
     */
    public static <T> R<T> fail(String message) {
        return new R<T>().setSuccess(false).setCode(500).setErrorMessage(message);
    }

    /**
     * 错误
     *
     * @return {@link R}
     */
    public static <T> R<T> error() {
        return R.fail("服务器开小差了, 请稍后重试!");
    }

    /**
     * 返回 bool
     *
     * @param bool bool
     * @return {@link R}
     */
    public static <T> R<T> bool(boolean bool) {
        return bool ? R.ok() : R.fail("操作失败, 请重试!");
    }

}
