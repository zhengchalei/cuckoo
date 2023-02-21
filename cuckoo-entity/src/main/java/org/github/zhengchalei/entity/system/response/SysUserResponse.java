package org.github.zhengchalei.entity.system.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.github.zhengchalei.entity.system.entity.SysUser;

import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link SysUser} entity
 */
@Data
public class SysUserResponse {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
    @Schema(description = "头像", defaultValue = "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png")
    private String avatar;
    @Schema(description = "角色", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<SysRoleResponse> roles = new HashSet<>();
}