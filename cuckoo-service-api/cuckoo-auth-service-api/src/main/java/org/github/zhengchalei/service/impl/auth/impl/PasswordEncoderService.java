package org.github.zhengchalei.service.impl.auth.impl;

public interface PasswordEncoderService {

    String encryptedPassword(String password);


    void verifyPassword(String encryptedPassword, String password);

    String defaultPassword();
}
