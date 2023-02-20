package org.github.zhengchalei.entity.system.mapper;

import org.github.zhengchalei.entity.system.entity.SysRole;
import org.github.zhengchalei.entity.system.request.SysRoleSaveRequest;
import org.github.zhengchalei.entity.system.request.SysRoleUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysRoleResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysRoleMapper {
    SysRole toEntity(SysRoleSaveRequest sysRoleSaveRequest);

    SysRoleResponse toDto(SysRole sysRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysRole partialUpdate(SysRoleUpdateRequest sysRoleUpdateRequest, @MappingTarget SysRole sysRole);

    SysRole update(SysRoleUpdateRequest sysRoleUpdateRequest, @MappingTarget SysRole flush);

    SysRoleResponse toResponse(SysRole flush);
}