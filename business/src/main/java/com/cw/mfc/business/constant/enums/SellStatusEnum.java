package com.cw.mfc.business.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SellStatusEnum {
    AVAIL(1, "可售"),
    UN_AVAIL(0, "停售");

    final Integer code;
    final String desc;

}
