package com.github.yjgbg.jpa.plus.entitySupport;

import java.io.Serializable;

/**
 * 支持删除和保存
 * @author weicl
 * @param <Self>
 */
public interface ActiveEntity<Self extends ActiveEntity<Self>> extends Serializable {

    /**
     * 保存该实体
     * @return 返回该实体，如果是新建，那么返回对象包含有自生成ID
     */
    @SuppressWarnings("unchecked")
    default Self save() {
        if (ActiveEntityHelper.saveFunction==null)
            throw new UnsupportedOperationException("没有注册ActiveEntity.saveFunction,不支持save功能");
        return (Self) ActiveEntityHelper.saveFunction.apply(this);
    }

    /**
     * 删除目标该实体
     */
    default void remove() {
        if (ActiveEntityHelper.removeFunction==null)
            throw new UnsupportedOperationException("没有注册ActiveEntity.removeFunction,不支持remove功能");
        ActiveEntityHelper.removeFunction.accept(this);
    }
}


