package org.github.zhengchalei.dto.system;

import lombok.Data;
import org.github.zhengchalei.model.system.SysRole;

import java.io.Serializable;

/**
 * A DTO for the {@link SysRole} entity
 */
@Data
public class SysRoleDto implements Serializable {
    private Long id;
    private String name;
    private String code;
    private String description;
}