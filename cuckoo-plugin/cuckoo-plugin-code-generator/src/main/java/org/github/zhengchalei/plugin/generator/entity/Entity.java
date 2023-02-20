package org.github.zhengchalei.plugin.generator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.github.zhengchalei.entity.base.BaseEntity;

import java.util.Set;

@Data
@jakarta.persistence.Entity
@Table(name = "plugin_code_gen_entity")
public class Entity extends BaseEntity {

    // 服务名
    @Column(nullable = false)
    private String serviceName;

    // 类名字
    @Column(unique = true, nullable = false)
    private String className;


    @OneToMany
    private Set<Field> fields;

}
