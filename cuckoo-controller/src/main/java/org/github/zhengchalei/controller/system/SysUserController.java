package org.github.zhengchalei.controller.system;

import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.dto.system.SysUserDto;
import org.github.zhengchalei.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping("/list")
    public Page<SysUserDto> findSysUserPage(@PageableDefault(size = 10, sort = "id") Pageable pageable, @RequestParam(required = false, defaultValue = "") String username) {
        return this.sysUserService.findSysUserPage(pageable, username);
    }

}
