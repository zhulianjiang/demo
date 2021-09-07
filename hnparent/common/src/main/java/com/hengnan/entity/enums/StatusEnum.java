package com.hengnan.entity.enums;


import com.wise.framework.basic.IEnum;

public enum StatusEnum implements IEnum<Integer> {

    /**
     * 1 正常
     * 0 删除
     */

    NORMAL(1, "正常"),
    DELETE(0, "删除");

    private int value;
    private String title;

    StatusEnum(int value, String title) {
        this.value = value;
        this.title = title;
    }

    @Override
    public Integer value() {
        return this.value;
    }

    @Override
    public String title() {
        return this.title;
    }

}
