package org.github.zhengchalei.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public R<Void> exception(Exception e) {
        return R.fail(e.getMessage());
    }


}
