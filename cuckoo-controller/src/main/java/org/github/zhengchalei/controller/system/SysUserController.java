package org.github.zhengchalei.controller.system;

import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.request.SysUserSaveRequest;
import org.github.zhengchalei.response.SysUserResponse;
import org.github.zhengchalei.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/users")
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping
    public Page<SysUserResponse> findSysUserPage(@PageableDefault(size = 10, sort = "id") Pageable pageable, @RequestParam(required = false, defaultValue = "") String username) {
        return this.sysUserService.findSysUserPage(pageable, username);
    }

    @GetMapping("/{id}")
    public SysUserResponse findSysUserById(@PathVariable Integer id) {
        return this.sysUserService.findSysUserById(id);
    }

    @PostMapping
    public SysUserResponse saveSysUser(@Validated @RequestBody SysUserSaveRequest sysUserSaveRequest) {
        return this.sysUserService.saveSysUser(sysUserSaveRequest);
    }
}
