package org.github.zhengchalei.controller.system;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.common.R;
import org.github.zhengchalei.common.RPage;
import org.github.zhengchalei.entity.system.request.SysUserCreateRequest;
import org.github.zhengchalei.entity.system.request.SysUserUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.github.zhengchalei.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SysUserApi")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sys/users")
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping("/page")
    public RPage<SysUserResponse> findSysUserPage(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String username,
            @RequestParam(required = false) Long roleId
    ) {
        Page<SysUserResponse> sysUserPage = sysUserService.findSysUserPage(pageable, username, roleId);
        return RPage.page(sysUserPage);
    }

    @GetMapping("/list")
    public R<List<SysUserResponse>> findSysUserList(@RequestParam(required = false, defaultValue = "") String username) {
        List<SysUserResponse> sysUserList = sysUserService.findSysUserList(username);
        return R.data(sysUserList);
    }

    @GetMapping("/id/{id}")
    public R<SysUserResponse> findSysUserById(@PathVariable Long id) {
        SysUserResponse sysUserById = sysUserService.findSysUserById(id);
        return R.data(sysUserById);
    }

    @PostMapping("/create")
    public R<SysUserResponse> createSysUser(@Validated @RequestBody SysUserCreateRequest sysUserCreateRequest) {
        SysUserResponse sysUserResponse = sysUserService.createSysUser(sysUserCreateRequest);
        return R.data(sysUserResponse);
    }

    @PutMapping("/update/{id}")
    public R<SysUserResponse> updateSysUserById(@PathVariable Long id, @RequestBody SysUserUpdateRequest sysUserUpdateRequest) {
        SysUserResponse sysUserResponse = sysUserService.updateSysUserById(id, sysUserUpdateRequest);
        return R.data(sysUserResponse);
    }

    @PatchMapping("/partial-update/{id}")
    public R<SysUserResponse> partialSysUserById(@PathVariable Long id, @RequestBody SysUserUpdateRequest sysUserUpdateRequest) {
        SysUserResponse sysUserResponse = sysUserService.partialSysUserById(id, sysUserUpdateRequest);
        return R.data(sysUserResponse);
    }

    @DeleteMapping("/delete/{id}")
    public R<Void> deleteSysUserById(@PathVariable Long id) {
        sysUserService.deleteSysUserById(id);
        return R.ok();
    }
}
