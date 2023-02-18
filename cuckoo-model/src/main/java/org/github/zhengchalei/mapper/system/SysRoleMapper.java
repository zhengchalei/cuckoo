package org.github.zhengchalei.mapper.system;

import org.github.zhengchalei.model.system.SysRole;
import org.github.zhengchalei.dto.system.SysRoleDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SysRoleMapper {
    SysRole toEntity(SysRoleDto sysRoleDto);

    SysRoleDto toDto(SysRole sysRole);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysRole partialUpdate(SysRoleDto sysRoleDto, @MappingTarget SysRole sysRole);
}