package org.github.zhengchalei.controller.system;

import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.entity.system.request.SysRoleSaveRequest;
import org.github.zhengchalei.entity.system.request.SysRoleUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysRoleResponse;
import org.github.zhengchalei.service.system.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/roles")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @GetMapping("/page")
    public Page<SysRoleResponse> findSysRolePage(@PageableDefault(size = 10, sort = "id") Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        return sysRoleService.findSysRolePage(pageable, name);
    }

    @GetMapping("/list")
    public List<SysRoleResponse> findSysRolePage(@RequestParam(required = false, defaultValue = "") String name) {
        return sysRoleService.findSysRoleList(name);
    }

    @GetMapping("/id/{id}")
    public SysRoleResponse findSysRoleById(@PathVariable Long id) {
        return sysRoleService.findSysRoleById(id);
    }

    @PostMapping("/save")
    public SysRoleResponse saveSysRole(@Validated @RequestBody SysRoleSaveRequest sysRoleSaveRequest) {
        return sysRoleService.saveSysRole(sysRoleSaveRequest);
    }

    @PutMapping("/update/{id}")
    public SysRoleResponse updateSysRoleById(@PathVariable Long id, @RequestBody SysRoleUpdateRequest sysRoleUpdateRequest) {
        return sysRoleService.updateSysRoleById(id, sysRoleUpdateRequest);
    }

    @PatchMapping("/partial-update/{id}")
    public SysRoleResponse partialSysRoleById(@PathVariable Long id, @RequestBody SysRoleUpdateRequest sysRoleUpdateRequest) {
        return sysRoleService.partialSysRoleById(id, sysRoleUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSysRoleById(@PathVariable Long id) {
        sysRoleService.deleteSysRoleById(id);
    }
}
