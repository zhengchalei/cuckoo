package org.github.zhengchalei.service.system;

import jakarta.validation.constraints.NotNull;
import org.github.zhengchalei.request.SysUserSaveRequest;
import org.github.zhengchalei.response.SysUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysUserService {

    Page<SysUserResponse> findSysUserPage(@NotNull Pageable pageable, @NotNull String username);

    SysUserResponse findSysUserById(Integer id);

    SysUserResponse saveSysUser(SysUserSaveRequest sysUserSaveRequest);
}
