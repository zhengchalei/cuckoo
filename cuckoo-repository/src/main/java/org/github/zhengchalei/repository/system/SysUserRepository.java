package org.github.zhengchalei.repository.system;

import jakarta.validation.constraints.NotBlank;
import org.github.zhengchalei.entity.system.entity.SysUser;
import org.github.zhengchalei.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysUserRepository extends BaseRepository<SysUser> {
    Optional<SysUser> findByUsername(@NotBlank String username);

}
