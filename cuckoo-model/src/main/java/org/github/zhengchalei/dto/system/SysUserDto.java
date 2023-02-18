package org.github.zhengchalei.dto.system;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link org.github.zhengchalei.model.system.SysUser} entity
 */
@Data
public class SysUserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String avatar;
}