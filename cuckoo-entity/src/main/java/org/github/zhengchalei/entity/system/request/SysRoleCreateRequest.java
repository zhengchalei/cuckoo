package org.github.zhengchalei.entity.system.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.github.zhengchalei.entity.system.entity.SysRole;

import java.io.Serializable;

/**
 * A DTO for the {@link SysRole} entity
 */
@Data
public class SysRoleCreateRequest implements Serializable {
    @Schema(description = "角色名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "角色编码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;
    private String description;
}