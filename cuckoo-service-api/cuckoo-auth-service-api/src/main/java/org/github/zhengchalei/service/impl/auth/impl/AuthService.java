package org.github.zhengchalei.service.impl.auth.impl;

import org.github.zhengchalei.entity.auth.request.LoginRequest;
import org.github.zhengchalei.entity.system.response.SysUserResponse;

public interface AuthService {
    SysUserResponse accountLogin(LoginRequest loginRequest);

    SysUserResponse currentUser();

    void outLogin();

}
