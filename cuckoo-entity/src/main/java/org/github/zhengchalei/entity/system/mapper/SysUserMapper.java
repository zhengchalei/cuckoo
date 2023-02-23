package org.github.zhengchalei.entity.system.mapper;

import org.github.zhengchalei.entity.system.entity.SysRole;
import org.github.zhengchalei.entity.system.entity.SysUser;
import org.github.zhengchalei.entity.system.request.SysUserCreateRequest;
import org.github.zhengchalei.entity.system.request.SysUserUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {
                SysRole.class,
                Collectors.class
        }
)
public interface SysUserMapper {

    @Mapping(target = "avatar", expression = "java(sysUserCreateRequest.getAvatar() == null ? sysUser.getAvatar() : sysUserCreateRequest.getAvatar())")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysUser toEntity(SysUserCreateRequest sysUserCreateRequest);

    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "avatar", ignore = true)
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysUser partialUpdate(SysUserUpdateRequest sysUserUpdateRequest, @MappingTarget SysUser sysUser);

    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "avatar", ignore = true)
    })
    SysUser update(SysUserUpdateRequest sysUserUpdateRequest, @MappingTarget SysUser flush);

    @Mapping(target = "roleIds", expression = "java(sysUser.getRoles().stream().map(SysRole::getId).collect(Collectors.toSet()))")
    SysUserResponse toResponse(SysUser sysUser);
}