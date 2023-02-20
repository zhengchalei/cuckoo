package org.github.zhengchalei.plugin.generator.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import org.github.zhengchalei.entity.base.BaseEntity;

@Data
@jakarta.persistence.Entity
@Table(name = "plugin_code_gen_field")
public class Field extends BaseEntity {
    // 字段名称
    private String name;
    // 字段类型
    private String type;
    // 映射策略, OneToOne, ManyToMany, OneToMay
    @Enumerated(EnumType.STRING)
    private MappingStrategy strategy;
    // 必填项
    private Boolean required = true;
    // 注释, 不一定支持, 对应 db  comment
    private String description;
    // 唯一
    private Boolean unique = false;
    // 默认值
    private String defaultValue = "";
    // 可插入的
    private Boolean insertable = true;
    // 可更新
    private Boolean updatable = true;
    // 忽略序列化
    private Boolean ignore = false;
}