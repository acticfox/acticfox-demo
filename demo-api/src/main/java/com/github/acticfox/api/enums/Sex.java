package com.github.acticfox.api.enums;

import com.github.acticfox.common.api.enums.IntEnum;

public enum Sex implements IntEnum<Sex> {
    BOY("boy", 1), GIRL("girl", 2);

    private String name;

    private int code;

    private Sex(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public int getCode() {
        // TODO Auto-generated method stub
        return code;
    }

}
