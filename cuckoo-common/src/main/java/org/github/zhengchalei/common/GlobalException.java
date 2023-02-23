package org.github.zhengchalei.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public R<Void> exception(Exception e) {
        // TODO 待补充完整
        log.error("异常", e);
        return R.fail(e.getMessage());
    }


}
