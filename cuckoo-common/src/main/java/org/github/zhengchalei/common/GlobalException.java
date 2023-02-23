package org.github.zhengchalei.common;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;


@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public R<Void> exception(Exception e) {
        // TODO 待补充完整
        log.error("异常", e);
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(NotLoginException.class)
    public R<Void> exception(NotLoginException e) {
        // 如果是 session 存储丢失后也会出现这个问题, 具体还得看 key 的 存储类型
        if (Objects.equals(e.getType(), NotLoginException.NOT_TOKEN)) {
            return R.fail("回话已过期, 请重新登录!");
        }
        // 正常过期
        if (Objects.equals(e.getType(), NotLoginException.TOKEN_TIMEOUT)) {
            return R.fail("回话已过期, 请重新登录!");
        }
        // token 异常
        if (Objects.equals(e.getType(), NotLoginException.NOT_TOKEN)) {
            return R.fail("未登录, 请登录后使用!");
        }
        if (Objects.equals(e.getType(), NotLoginException.BE_REPLACED)) {
            return R.fail("账号在其他地方登录, 已被迫下线!");
        }
        if (Objects.equals(e.getType(), NotLoginException.KICK_OUT)) {
            return R.fail("被管理员强制下线!");
        }
        return R.fail("未登录, 请登录后使用!");
    }

}
