package org.github.zhengchalei.service.impl.system.impl;

import com.querydsl.core.BooleanBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.github.zhengchalei.entity.system.entity.SysRole;
import org.github.zhengchalei.entity.system.entity.SysUser;
import org.github.zhengchalei.entity.system.mapper.SysUserMapper;
import org.github.zhengchalei.entity.system.request.SysUserCreateRequest;
import org.github.zhengchalei.entity.system.request.SysUserUpdateRequest;
import org.github.zhengchalei.entity.system.response.SysUserResponse;
import org.github.zhengchalei.repository.system.SysRoleRepository;
import org.github.zhengchalei.repository.system.SysUserRepository;
import org.github.zhengchalei.service.impl.auth.impl.AuthService;
import org.github.zhengchalei.service.impl.auth.impl.PasswordEncoderService;
import org.github.zhengchalei.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.github.zhengchalei.entity.system.entity.QSysUser.sysUser;


@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository sysUserRepository;
    private final SysUserMapper sysUserMapper;
    private final SysRoleRepository sysRoleRepository;
    private final PasswordEncoderService passwordEncoderService;
    private final AuthService authService;

    @Override
    public Page<SysUserResponse> findSysUserPage(@NotNull Pageable pageable, String username, Long roleId) {
        BooleanBuilder predicate = new BooleanBuilder();
        if (StringUtils.isNotBlank(username)) {
            predicate.and(sysUser.username.containsIgnoreCase(username));
        }
        if (roleId != null) {
            predicate.and(sysUser.roles.contains(new SysRole().setId(roleId)));
        }
        Page<SysUser> page = sysUserRepository.findAll(predicate, pageable);
        return page.map(sysUserMapper::toResponse);
    }

    @Override
    public List<SysUserResponse> findSysUserList(String username) {
        BooleanBuilder predicate = new BooleanBuilder();
        Iterable<SysUser> sysUsers = sysUserRepository.findAll(predicate);
        return StreamSupport.stream(sysUsers.spliterator(), false).map(sysUserMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public SysUserResponse findSysUserById(@NotNull Long id) {
        return sysUserRepository.findById(id).map(sysUserMapper::toResponse).orElseThrow();
    }

    @Override
    public SysUserResponse createSysUser(@NotNull SysUserCreateRequest sysUserCreateRequest) {
        SysUser save = sysUserMapper.toEntity(sysUserCreateRequest);
        boolean exists = sysUserRepository.existsByUsernameIgnoreCaseAllIgnoreCase(save.getUsername());
        if (exists) {
            throw new RuntimeException("用户名已存在!");
        }
        // 密码加密
        String password = passwordEncoderService.defaultPassword();
        save.setPassword(password);
        // 查角色
        Set<SysRole> roles = new HashSet<>(sysRoleRepository.findAllById(sysUserCreateRequest.getRoleIds()));
        save.setRoles(roles);
        SysUser result = sysUserRepository.save(save);
        return sysUserMapper.toResponse(result);
    }

    @Override
    public SysUserResponse updateSysUserById(@NotNull Long id, @NotNull SysUserUpdateRequest sysUserUpdateRequest) {
        sysUserUpdateRequest.setId(id);
        SysUser flush = sysUserRepository.findById(id).orElseThrow();
        sysUserMapper.update(sysUserUpdateRequest, flush);
        Set<SysRole> roles = new HashSet<>(sysRoleRepository.findAllById(sysUserUpdateRequest.getRoleIds()));
        flush.setRoles(roles);
        return sysUserMapper.toResponse(flush);
    }

    @Override
    public SysUserResponse partialSysUserById(@NotNull Long id, @NotNull SysUserUpdateRequest sysUserUpdateRequest) {
        SysUser flush = sysUserRepository.findById(id).orElseThrow();
        sysUserMapper.partialUpdate(sysUserUpdateRequest, flush);
        Set<SysRole> roles = new HashSet<>(sysRoleRepository.findAllById(sysUserUpdateRequest.getRoleIds()));
        flush.setRoles(roles);
        return sysUserMapper.toResponse(flush);
    }

    @Override
    public void deleteSysUserById(@NotNull Long id) {
        if (authService.currentUser().getId().equals(id)) {
            throw new RuntimeException("不能删除自己!");
        }
        sysUserRepository.deleteById(id);
    }
}
