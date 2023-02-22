package org.github.zhengchalei.entity.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.github.zhengchalei.entity.base.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Data
@Accessors(chain = true)
@Entity
public class SysUser extends BaseEntity<SysUser> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String avatar = "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png";

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany
    private Set<SysRole> roles = new HashSet<>();

}
