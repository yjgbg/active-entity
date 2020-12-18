package com.github.yjgbg.jpa.plus.entitySupport;

import java.util.function.Consumer;
import java.util.function.Function;

public class ActiveEntityHelper {
    protected static Function<Object,Object> saveFunction;
    protected static Consumer<Object> removeFunction;

    /**
     * 注册了这两个函数，便可以使用activeEntity的保存和删除方法了
     * @param saveFunction 返回值应当为与输入值为同类实体
     */
    public static void registerSaveFunction(Function<Object,Object> saveFunction) {
        ActiveEntityHelper.saveFunction = saveFunction;
    }

    /**
     * 注册了这两个函数，便可以使用activeEntity的保存和删除方法了
     * @param removeFunction 用于删除对象的函数
     */
    public static void registerRemoveFunction(Consumer<Object> removeFunction) {
        ActiveEntityHelper.removeFunction = removeFunction;
    }
}
