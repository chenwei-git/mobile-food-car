package com.cw.mfc.business.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplyStatusEnum {

    INIT(0, "待审核"),
    ACCEPT(1, "通过"),
    REJECT(2, "拒绝");

    final Integer code;
    final String desc;

}
