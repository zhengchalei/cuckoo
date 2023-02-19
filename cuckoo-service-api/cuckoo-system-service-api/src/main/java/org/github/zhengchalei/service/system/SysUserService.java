package org.github.zhengchalei.service.system;

import jakarta.validation.constraints.NotNull;
import org.github.zhengchalei.request.SysUserSaveRequest;
import org.github.zhengchalei.request.SysUserUpdateRequest;
import org.github.zhengchalei.response.SysUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysUserService {

    Page<SysUserResponse> findSysUserPage(@NotNull Pageable pageable, @NotNull String username);

    List<SysUserResponse> findSysUserList(String username);

    SysUserResponse findSysUserById(Integer id);

    SysUserResponse saveSysUser(SysUserSaveRequest sysUserSaveRequest);

    SysUserResponse updateSysUserById(Integer id, SysUserUpdateRequest sysUserUpdateRequest);

    SysUserResponse partialSysUserById(Integer id, SysUserUpdateRequest sysUserUpdateRequest);

    void deleteSysUserById(Integer id);
}
