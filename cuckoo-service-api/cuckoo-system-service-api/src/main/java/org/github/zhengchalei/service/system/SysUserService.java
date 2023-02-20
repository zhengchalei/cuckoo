package org.github.zhengchalei.service.system;

import jakarta.validation.constraints.NotNull;
import org.github.zhengchalei.entity.system.request.SysUserSaveRequest;
import org.github.zhengchalei.entity.system.request.SysUserUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysUserService {

    Page<SysUserResponse> findSysUserPage(@NotNull Pageable pageable, @NotNull String username);

    List<SysUserResponse> findSysUserList(String username);

    SysUserResponse findSysUserById(Long id);

    SysUserResponse saveSysUser(SysUserSaveRequest sysUserSaveRequest);

    SysUserResponse updateSysUserById(Long id, SysUserUpdateRequest sysUserUpdateRequest);

    SysUserResponse partialSysUserById(Long id, SysUserUpdateRequest sysUserUpdateRequest);

    void deleteSysUserById(Long id);
}
