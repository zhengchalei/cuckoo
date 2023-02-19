package org.github.zhengchalei.mapper.system;

import org.github.zhengchalei.model.system.SysRole;
import org.github.zhengchalei.request.SysRoleSaveRequest;
import org.github.zhengchalei.request.SysRoleUpdateRequest;
import org.github.zhengchalei.response.SysRoleResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysRoleMapper {
    SysRole toEntity(SysRoleSaveRequest sysRoleSaveRequest);

    SysRoleResponse toDto(SysRole sysRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysRole partialUpdate(SysRoleUpdateRequest sysRoleUpdateRequest, @MappingTarget SysRole sysRole);
}