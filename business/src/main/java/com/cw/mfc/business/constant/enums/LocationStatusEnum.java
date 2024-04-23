package com.cw.mfc.business.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LocationStatusEnum {

    FREE(0, "空闲"),
    USING(1, "使用中");

    final Integer code;
    final String desc;

}
