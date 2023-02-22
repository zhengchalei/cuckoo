package org.github.zhengchalei.service.impl.auth.impl;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.entity.auth.request.LoginRequest;
import org.github.zhengchalei.entity.system.entity.SysUser;
import org.github.zhengchalei.entity.system.mapper.SysUserMapper;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.github.zhengchalei.repository.system.SysUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthService {

    private final SysUserRepository sysUserRepository;
    private final SysUserMapper sysUserMapper;
    private final PasswordEncoderService passwordEncoderService;

    @Override
    public SysUserResponse accountLogin(LoginRequest loginRequest) {
        SysUser sysUser = sysUserRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        passwordEncoderService.verifyPassword(sysUser.getPassword(), loginRequest.getPassword());
        StpUtil.login(sysUser.getId(), loginRequest.getRememberMe());
        return sysUserMapper.toResponse(sysUser);
    }

    @Override
    public SysUserResponse currentUser() {
        long id = StpUtil.getLoginIdAsLong();
        return sysUserMapper.toResponse(sysUserRepository.findById(id).orElseThrow());
    }

    @Override
    public void outLogin() {
        StpUtil.logout();
    }
}
