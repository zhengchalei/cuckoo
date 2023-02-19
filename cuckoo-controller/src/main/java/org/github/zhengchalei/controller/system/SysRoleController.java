package org.github.zhengchalei.controller.system;

import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.request.SysRoleSaveRequest;
import org.github.zhengchalei.response.SysRoleResponse;
import org.github.zhengchalei.service.system.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/roles")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @GetMapping
    public Page<SysRoleResponse> findSysRolePage(@PageableDefault(size = 10, sort = "id") Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        return this.sysRoleService.findSysRolePage(pageable, name);
    }

    @GetMapping("/{id}")
    public SysRoleResponse findSysRoleById(@PathVariable Integer id) {
        return this.sysRoleService.findSysRoleById(id);
    }

    @PostMapping
    public SysRoleResponse saveSysRole(@Validated @RequestBody SysRoleSaveRequest sysRoleSaveRequest) {
        return this.sysRoleService.saveSysRole(sysRoleSaveRequest);
    }
}
