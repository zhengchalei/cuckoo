package org.github.zhengchalei.entity.base;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class BaseEntity<T> implements Persistable<Long> {
    @Override
    public boolean isNew() {
        return getId() == null;
    }

}
