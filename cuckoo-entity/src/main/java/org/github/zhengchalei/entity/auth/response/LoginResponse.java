package org.github.zhengchalei.entity.auth.response;

import lombok.Data;
import org.github.zhengchalei.entity.system.response.SysUserResponse;

@Data
public class LoginResponse {

    private String token;

    private Long expire;

    private SysUserResponse data;


}
