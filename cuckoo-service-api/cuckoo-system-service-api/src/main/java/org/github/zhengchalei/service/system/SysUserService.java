package org.github.zhengchalei.service.system;

import jakarta.validation.constraints.NotNull;
import org.github.zhengchalei.dto.system.SysUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysUserService {

    Page<SysUserDto> findSysUserPage(@NotNull Pageable pageable, @NotNull String username);
}
