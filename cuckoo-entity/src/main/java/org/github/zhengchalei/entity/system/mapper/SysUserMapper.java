package org.github.zhengchalei.entity.system.mapper;

import org.github.zhengchalei.entity.system.entity.SysUser;
import org.github.zhengchalei.entity.system.request.SysUserSaveRequest;
import org.github.zhengchalei.entity.system.request.SysUserUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysUserMapper {

    SysUser toEntity(SysUserSaveRequest sysUserSaveRequest);

    SysUserResponse toDto(SysUser sysUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysUser partialUpdate(SysUserUpdateRequest sysUserUpdateRequest, @MappingTarget SysUser sysUser);

    SysUser update(SysUserUpdateRequest sysUserUpdateRequest, @MappingTarget SysUser flush);

    SysUserResponse toResponse(SysUser sysUser);
}