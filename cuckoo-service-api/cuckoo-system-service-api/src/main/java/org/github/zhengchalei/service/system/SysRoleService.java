package org.github.zhengchalei.service.system;

import org.github.zhengchalei.entity.system.request.SysRoleCreateRequest;
import org.github.zhengchalei.entity.system.request.SysRoleUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysRoleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysRoleService {
    Page<SysRoleResponse> findSysRolePage(Pageable pageable, String name);

    SysRoleResponse findSysRoleById(Long id);

    SysRoleResponse createSysRole(SysRoleCreateRequest sysRoleCreateRequest);

    SysRoleResponse updateSysRoleById(Long id, SysRoleUpdateRequest sysRoleUpdateRequest);

    SysRoleResponse partialSysRoleById(Long id, SysRoleUpdateRequest sysRoleUpdateRequest);

    void deleteSysRoleById(Long id);

    List<SysRoleResponse> findSysRoleList(String name);

}
