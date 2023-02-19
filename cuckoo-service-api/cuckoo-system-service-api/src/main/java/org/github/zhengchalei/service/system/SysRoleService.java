package org.github.zhengchalei.service.system;

import org.github.zhengchalei.request.SysRoleSaveRequest;
import org.github.zhengchalei.response.SysRoleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysRoleService {
    Page<SysRoleResponse> findSysRolePage(Pageable pageable, String name);

    SysRoleResponse findSysRoleById(Integer id);

    SysRoleResponse saveSysRole(SysRoleSaveRequest sysRoleSaveRequest);
}
