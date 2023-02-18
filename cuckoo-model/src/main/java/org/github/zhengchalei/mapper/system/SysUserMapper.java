package org.github.zhengchalei.mapper.system;

import org.github.zhengchalei.dto.system.SysUserDto;
import org.github.zhengchalei.model.system.SysUser;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SysUserMapper {
    SysUser toEntity(SysUserDto sysUserDto);

    SysUserDto toDto(SysUser sysUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SysUser partialUpdate(SysUserDto sysUserDto, @MappingTarget SysUser sysUser);
}