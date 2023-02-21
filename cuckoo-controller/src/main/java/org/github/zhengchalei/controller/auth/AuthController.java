package org.github.zhengchalei.controller.auth;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.common.R;
import org.github.zhengchalei.entity.auth.request.LoginRequest;
import org.github.zhengchalei.entity.auth.response.LoginResponse;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.github.zhengchalei.service.impl.auth.impl.AuthService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(name = "AuthApi")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login/account")
    public R<LoginResponse> accountLogin(@Validated @RequestBody LoginRequest loginRequest) {
        SysUserResponse sysUserResponse = authService.accountLogin(loginRequest);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setData(sysUserResponse);
        loginResponse.setToken(tokenInfo.getTokenValue());
        loginResponse.setExpire(loginResponse.getExpire());
        return R.data(loginResponse);
    }

    @GetMapping("/current-user")
    public R<SysUserResponse> currentUser() {
        SysUserResponse sysUserResponse = authService.currentUser();
        return R.data(sysUserResponse);
    }

    @PostMapping("/login/out-login")
    public R<Void> outLogin() {
        authService.outLogin();
        return R.ok();
    }

}
