package org.github.zhengchalei.entity.system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.github.zhengchalei.entity.base.BaseEntity;

@Data
@Accessors(chain = true)
@Entity
public class SysRole extends BaseEntity<SysRole> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    private String description;
}
