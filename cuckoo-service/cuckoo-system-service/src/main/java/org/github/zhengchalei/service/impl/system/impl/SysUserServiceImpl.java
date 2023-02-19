package org.github.zhengchalei.service.impl.system.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.github.zhengchalei.mapper.system.SysUserMapper;
import org.github.zhengchalei.model.system.SysRole;
import org.github.zhengchalei.model.system.SysUser;
import org.github.zhengchalei.repository.system.SysRoleRepository;
import org.github.zhengchalei.repository.system.SysUserRepository;
import org.github.zhengchalei.request.SysUserSaveRequest;
import org.github.zhengchalei.request.SysUserUpdateRequest;
import org.github.zhengchalei.response.SysUserResponse;
import org.github.zhengchalei.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.github.zhengchalei.model.system.QSysUser.sysUser;

@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository sysUserRepository;
    private final SysUserMapper sysUserMapper;
    private final SysRoleRepository sysRoleRepository;

    @Override
    public Page<SysUserResponse> findSysUserPage(@NotNull Pageable pageable, @NotNull String username) {
        Page<SysUser> page = sysUserRepository.findAll(sysUser.username.containsIgnoreCase(username), pageable);
        return page.map(sysUserMapper::toResponse);
    }

    @Override
    public List<SysUserResponse> findSysUserList(String username) {
        return sysUserRepository.findAll().stream().map(sysUserMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SysUserResponse findSysUserById(Integer id) {
        return sysUserRepository.findById(id).map(sysUserMapper::toResponse).orElseThrow();
    }

    @Override
    public SysUserResponse saveSysUser(SysUserSaveRequest sysUserSaveRequest) {
        SysUser save = sysUserMapper.toEntity(sysUserSaveRequest);
        // 查角色
        Set<SysRole> roles = new HashSet<>(sysRoleRepository.findAllById(sysUserSaveRequest.getRoleIds()));
        save.setRoles(roles);
        SysUser result = sysUserRepository.save(save);
        return sysUserMapper.toResponse(result);
    }

    @Override
    public SysUserResponse updateSysUserById(Integer id, SysUserUpdateRequest sysUserUpdateRequest) {
        sysUserUpdateRequest.setId(id);
        SysUser flush = sysUserRepository.findById(id).orElseThrow();
        sysUserMapper.update(sysUserUpdateRequest, flush);
        Set<SysRole> roles = new HashSet<>(sysRoleRepository.findAllById(sysUserUpdateRequest.getRoleIds()));
        flush.setRoles(roles);
        return sysUserMapper.toResponse(flush);
    }

    @Override
    public SysUserResponse partialSysUserById(Integer id, SysUserUpdateRequest sysUserUpdateRequest) {
        SysUser flush = sysUserRepository.findById(id).orElseThrow();
        sysUserMapper.partialUpdate(sysUserUpdateRequest, flush);
        Set<SysRole> roles = new HashSet<>(sysRoleRepository.findAllById(sysUserUpdateRequest.getRoleIds()));
        flush.setRoles(roles);
        return sysUserMapper.toResponse(flush);
    }

    @Override
    public void deleteSysUserById(Integer id) {
        sysUserRepository.deleteById(id);
    }
}
