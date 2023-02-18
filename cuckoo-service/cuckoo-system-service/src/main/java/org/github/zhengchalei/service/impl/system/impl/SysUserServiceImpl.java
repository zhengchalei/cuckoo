package org.github.zhengchalei.service.impl.system.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.dto.system.SysUserDto;
import org.github.zhengchalei.mapper.system.SysUserMapper;
import org.github.zhengchalei.model.system.SysUser;
import org.github.zhengchalei.repository.system.SysUserRepository;
import org.github.zhengchalei.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.github.zhengchalei.model.system.QSysUser.sysUser;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository sysUserRepository;
    private final SysUserMapper sysUserMapper;

    @Override
    public Page<SysUserDto> findSysUserPage(@NotNull Pageable pageable, @NotNull String username) {
        Page<SysUser> page = this.sysUserRepository.findAll(sysUser.username.containsIgnoreCase(username), pageable);
        return page.map(this.sysUserMapper::toDto);
    }
}
