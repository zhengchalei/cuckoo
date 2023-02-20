package org.github.zhengchalei.entity.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import org.github.zhengchalei.entity.base.BaseEntity;

@Data
@Entity
public class SysRole extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    private String description;
}
