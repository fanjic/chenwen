package com.chen.chenwen.constant;

import lombok.Getter;
import lombok.Setter;

public enum Color {
    //Java规定先定义枚举实例：使用大写字母命名，并且中间使用下划线进行连接
    RED("红色",1),
    GREEN("绿色",2),
    BLUE("蓝色",3),
    YELLOW("黄色",4);

    @Getter
    @Setter
    private int index;

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // 普通方法
    public static String getName(int index) {
        for (Color co : Color.values()) {
            if (co.getIndex() == index) {
                return co.name();
            }
        }
        return null;
    }

    Color(String color, int index) {
        this.color = color;
        this.index = index;
    }



}
