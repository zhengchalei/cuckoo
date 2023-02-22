package org.github.zhengchalei.repository.system;

import jakarta.validation.constraints.NotBlank;
import org.github.zhengchalei.entity.system.entity.SysUser;
import org.github.zhengchalei.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysUserRepository extends BaseRepository<SysUser> {
    @Query("select (count(s) > 0) from SysUser s where upper(s.username) = upper(?1)")
    boolean existsByUsernameIgnoreCaseAllIgnoreCase(@NonNull String username);

    Optional<SysUser> findByUsername(@NotBlank String username);

}
