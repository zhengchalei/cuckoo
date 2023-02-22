package org.github.zhengchalei.service.system;

import jakarta.validation.constraints.NotNull;
import org.github.zhengchalei.entity.system.request.SysUserCreateRequest;
import org.github.zhengchalei.entity.system.request.SysUserUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysUserService {

    Page<SysUserResponse> findSysUserPage(@NotNull Pageable pageable, String username, Long roleId);

    List<SysUserResponse> findSysUserList(String username);

    SysUserResponse findSysUserById(@NotNull Long id);

    SysUserResponse createSysUser(@NotNull SysUserCreateRequest sysUserCreateRequest);

    SysUserResponse updateSysUserById(@NotNull Long id, @NotNull SysUserUpdateRequest sysUserUpdateRequest);

    SysUserResponse partialSysUserById(@NotNull Long id, @NotNull SysUserUpdateRequest sysUserUpdateRequest);

    void deleteSysUserById(@NotNull Long id);
}
