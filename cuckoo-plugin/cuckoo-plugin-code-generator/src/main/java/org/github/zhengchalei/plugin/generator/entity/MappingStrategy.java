package org.github.zhengchalei.plugin.generator.entity;

public enum MappingStrategy {
    // 基本类型
    BASIC,
    // 一对一
    ONE_TO_ONE,
    // 一对多
    ONE_TO_MANY,
    // 多对多
    MANY_TO_MANY,
    // 多对一
    MANY_TO_ONE,
    // 基础类型的元素集合
    ELEMENT_COLLECTION,
}
