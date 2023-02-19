package org.github.zhengchalei.service.system;

import org.github.zhengchalei.request.SysRoleSaveRequest;
import org.github.zhengchalei.request.SysRoleUpdateRequest;
import org.github.zhengchalei.response.SysRoleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysRoleService {
    Page<SysRoleResponse> findSysRolePage(Pageable pageable, String name);

    SysRoleResponse findSysRoleById(Integer id);

    SysRoleResponse saveSysRole(SysRoleSaveRequest sysRoleSaveRequest);

    SysRoleResponse updateSysRoleById(Integer id, SysRoleUpdateRequest sysRoleUpdateRequest);

    SysRoleResponse partialSysRoleById(Integer id, SysRoleUpdateRequest sysRoleUpdateRequest);

    void deleteSysRoleById(Integer id);

    List<SysRoleResponse> findSysRoleList(String name);

}
