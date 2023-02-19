package org.github.zhengchalei.mapper.system;

import org.github.zhengchalei.model.system.SysUser;
import org.github.zhengchalei.request.SysUserSaveRequest;
import org.github.zhengchalei.request.SysUserUpdateRequest;
import org.github.zhengchalei.response.SysUserResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysUserMapper {

    SysUser toEntity(SysUserSaveRequest sysUserSaveRequest);

    SysUserResponse toDto(SysUser sysUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysUser partialUpdate(SysUserUpdateRequest sysUserUpdateRequest, @MappingTarget SysUser sysUser);

    SysUser update(SysUserUpdateRequest sysUserUpdateRequest,@MappingTarget  SysUser flush);

    SysUserResponse toResponse(SysUser sysUser);
}