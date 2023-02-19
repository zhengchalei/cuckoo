package org.github.zhengchalei.service.impl.system.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.mapper.system.SysRoleMapper;
import org.github.zhengchalei.model.system.SysRole;
import org.github.zhengchalei.repository.system.SysRoleRepository;
import org.github.zhengchalei.request.SysRoleSaveRequest;
import org.github.zhengchalei.response.SysRoleResponse;
import org.github.zhengchalei.service.system.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.github.zhengchalei.model.system.QSysRole.sysRole;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleRepository sysRoleRepository;
    private final SysRoleMapper sysRoleMapper;

    @Override
    public Page<SysRoleResponse> findSysRolePage(@NotNull Pageable pageable, @NotNull String name) {
        Page<SysRole> page = this.sysRoleRepository.findAll(sysRole.name.containsIgnoreCase(name), pageable);
        return page.map(this.sysRoleMapper::toDto);
    }

    @Override
    public SysRoleResponse findSysRoleById(Integer id) {
        return this.sysRoleRepository.findById(id).map(sysRoleMapper::toDto).orElseThrow();
    }

    @Override
    public SysRoleResponse saveSysRole(SysRoleSaveRequest sysRoleSaveRequest) {
        SysRole save = sysRoleMapper.toEntity(sysRoleSaveRequest);
        SysRole result = this.sysRoleRepository.save(save);
        return sysRoleMapper.toDto(result);
    }
}
