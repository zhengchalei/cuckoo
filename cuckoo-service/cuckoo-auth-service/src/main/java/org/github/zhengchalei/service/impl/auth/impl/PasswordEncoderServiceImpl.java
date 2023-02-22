package org.github.zhengchalei.service.impl.auth.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderServiceImpl implements PasswordEncoderService {

    @Value("${default.password:123456}")
    private String password;

    @Override
    public String encryptedPassword(String password) {
        return SaSecureUtil.sha256(password);
    }

    @Override
    public void verifyPassword(String encryptedPassword, String password) {
        if (encryptedPassword(password).equals(encryptedPassword)) {
            return;
        }
        throw new RuntimeException("密码不正确");
    }

    @Override
    public String defaultPassword() {
        return encryptedPassword(password);
    }
}
