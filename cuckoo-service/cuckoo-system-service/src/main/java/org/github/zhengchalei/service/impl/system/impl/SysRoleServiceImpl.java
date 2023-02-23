package org.github.zhengchalei.service.impl.system.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.entity.system.entity.SysRole;
import org.github.zhengchalei.entity.system.mapper.SysRoleMapper;
import org.github.zhengchalei.entity.system.request.SysRoleCreateRequest;
import org.github.zhengchalei.entity.system.request.SysRoleUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysRoleResponse;
import org.github.zhengchalei.repository.system.SysRoleRepository;
import org.github.zhengchalei.service.system.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.github.zhengchalei.entity.system.entity.QSysRole.sysRole;


@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleRepository sysRoleRepository;
    private final SysRoleMapper sysRoleMapper;

    @Override
    public Page<SysRoleResponse> findSysRolePage(@NotNull Pageable pageable, @NotNull String name) {
        Page<SysRole> page = sysRoleRepository.findAll(sysRole.name.containsIgnoreCase(name), pageable);
        return page.map(sysRoleMapper::toResponse);
    }

    @Override
    public List<SysRoleResponse> findSysRoleList(String name) {
        Iterable<SysRole> roles = sysRoleRepository.findAll(sysRole.name.containsIgnoreCase(name));
        return StreamSupport.stream(roles.spliterator(), false).map(sysRoleMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public SysRoleResponse findSysRoleById(Long id) {
        return sysRoleRepository.findById(id).map(sysRoleMapper::toResponse).orElseThrow();
    }

    @Override
    public SysRoleResponse createSysRole(SysRoleCreateRequest sysRoleCreateRequest) {
        SysRole save = sysRoleMapper.toEntity(sysRoleCreateRequest);
        SysRole result = sysRoleRepository.save(save);
        return sysRoleMapper.toResponse(result);
    }

    @Override
    public SysRoleResponse updateSysRoleById(Long id, SysRoleUpdateRequest sysRoleUpdateRequest) {
        SysRole flush = sysRoleRepository.findById(id).orElseThrow();
        sysRoleMapper.update(sysRoleUpdateRequest, flush);
        return sysRoleMapper.toResponse(flush);
    }

    @Override
    public SysRoleResponse partialSysRoleById(Long id, SysRoleUpdateRequest sysRoleUpdateRequest) {
        SysRole flush = sysRoleRepository.findById(id).orElseThrow();
        sysRoleMapper.partialUpdate(sysRoleUpdateRequest, flush);
        return sysRoleMapper.toResponse(flush);
    }

    @Override
    public void deleteSysRoleById(Long id) {
        sysRoleRepository.deleteById(id);
    }

}
