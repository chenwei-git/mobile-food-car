package com.cw.mfc.business.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OpenStatusEnum {
    CLOSE(0, "休息"),
    OPEN(1, "营业中");

    final Integer code;
    final String desc;

}
