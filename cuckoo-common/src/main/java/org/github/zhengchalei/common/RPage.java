package org.github.zhengchalei.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * page
 *
 * @author 郑查磊
 * @date 2021/04/10
 */
@Data
@Accessors(chain = true)
public class RPage<T> {
    protected Boolean success = true;
    protected String errorMessage = "";
    protected Integer errorCode;
    //   SILENT = "SILENT",
    //  WARN_MESSAGE = "WARN",
    //  ERROR_MESSAGE = "ERROR",
    //  NOTIFICATION = 'NOTIFICATION',
    //  REDIRECT = 'REDIRECT',
    protected String showType = "ERROR";
    protected List<T> data = new ArrayList<>();
    protected Long total = 0L;

    public static <T> RPage<T> list(List<T> data) {
        return new RPage<T>().setData(data).setTotal((long) data.size());
    }

    public static <T> RPage<T> page(Page<T> data) {
        return new RPage<T>().setData(data.getContent()).setTotal(data.getTotalElements());
    }
}