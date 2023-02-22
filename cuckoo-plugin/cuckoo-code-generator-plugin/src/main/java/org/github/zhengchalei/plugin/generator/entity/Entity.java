package org.github.zhengchalei.plugin.generator.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.github.zhengchalei.entity.base.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Data
@jakarta.persistence.Entity
@Table(name = "plugin_code_gen_entity")
public class Entity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    // 服务名
    @Column(nullable = false)
    private String serviceName;

    // 类名字
    @Column(unique = true, nullable = false)
    private String className;


    @OneToMany
    private Set<Field> fields = new HashSet<>();

}
