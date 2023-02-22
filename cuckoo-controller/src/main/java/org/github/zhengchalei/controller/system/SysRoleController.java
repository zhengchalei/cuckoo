package org.github.zhengchalei.controller.system;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.common.R;
import org.github.zhengchalei.common.RPage;
import org.github.zhengchalei.entity.system.request.SysRoleCreateRequest;
import org.github.zhengchalei.entity.system.request.SysRoleUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysRoleResponse;
import org.github.zhengchalei.service.system.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SysRoleApi")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sys/roles")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @GetMapping("/page")
    public RPage<SysRoleResponse> findSysRolePage(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        Page<SysRoleResponse> sysRolePage = sysRoleService.findSysRolePage(pageable, name);
        return RPage.page(sysRolePage);
    }

    @GetMapping("/list")
    public R<List<SysRoleResponse>> findSysRoleList(@RequestParam(required = false, defaultValue = "") String name) {
        List<SysRoleResponse> sysRoleList = sysRoleService.findSysRoleList(name);
        return R.data(sysRoleList);
    }

    @GetMapping("/id/{id}")
    public R<SysRoleResponse> findSysRoleById(@PathVariable Long id) {
        SysRoleResponse sysRoleById = sysRoleService.findSysRoleById(id);
        return R.data(sysRoleById);
    }

    @PostMapping("/create")
    public R<SysRoleResponse> createSysRole(@Validated @RequestBody SysRoleCreateRequest sysRoleCreateRequest) {
        SysRoleResponse sysRoleResponse = sysRoleService.createSysRole(sysRoleCreateRequest);
        return R.data(sysRoleResponse);
    }

    @PutMapping("/update/{id}")
    public R<SysRoleResponse> updateSysRoleById(@PathVariable Long id, @RequestBody SysRoleUpdateRequest sysRoleUpdateRequest) {
        SysRoleResponse sysRoleResponse = sysRoleService.updateSysRoleById(id, sysRoleUpdateRequest);
        return R.data(sysRoleResponse);
    }

    @PatchMapping("/partial-update/{id}")
    public R<SysRoleResponse> partialSysRoleById(@PathVariable Long id, @RequestBody SysRoleUpdateRequest sysRoleUpdateRequest) {
        SysRoleResponse sysRoleResponse = sysRoleService.partialSysRoleById(id, sysRoleUpdateRequest);
        return R.data(sysRoleResponse);
    }

    @DeleteMapping("/delete/{id}")
    public R<Void> deleteSysRoleById(@PathVariable Long id) {
        sysRoleService.deleteSysRoleById(id);
        return R.ok();
    }
}
