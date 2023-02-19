package org.github.zhengchalei.controller.system;

import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.request.SysUserSaveRequest;
import org.github.zhengchalei.request.SysUserUpdateRequest;
import org.github.zhengchalei.response.SysUserResponse;
import org.github.zhengchalei.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/users")
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping("/page")
    public Page<SysUserResponse> findSysUserPage(@PageableDefault(size = 10, sort = "id") Pageable pageable, @RequestParam(required = false, defaultValue = "") String username) {
        return sysUserService.findSysUserPage(pageable, username);
    }

    @GetMapping("/list")
    public List<SysUserResponse> findSysUserPage(@RequestParam(required = false, defaultValue = "") String username) {
        return sysUserService.findSysUserList(username);
    }

    @GetMapping("/id/{id}")
    public SysUserResponse findSysUserById(@PathVariable Integer id) {
        return sysUserService.findSysUserById(id);
    }

    @PostMapping("/save")
    public SysUserResponse saveSysUser(@Validated @RequestBody SysUserSaveRequest sysUserSaveRequest) {
        return sysUserService.saveSysUser(sysUserSaveRequest);
    }

    @PutMapping("/update/{id}")
    public SysUserResponse updateSysUserById(@PathVariable Integer id, @RequestBody SysUserUpdateRequest sysUserUpdateRequest) {
        return sysUserService.updateSysUserById(id, sysUserUpdateRequest);
    }

    @PatchMapping("/partial-update/{id}")
    public SysUserResponse partialSysUserById(@PathVariable Integer id, @RequestBody SysUserUpdateRequest sysUserUpdateRequest) {
        return sysUserService.partialSysUserById(id, sysUserUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSysUserById(@PathVariable Integer id) {
        sysUserService.deleteSysUserById(id);
    }
}
