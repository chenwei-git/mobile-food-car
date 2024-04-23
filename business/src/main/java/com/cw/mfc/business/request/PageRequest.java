package com.cw.mfc.business.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PageRequest {

    @NotNull(message = "页码不能为空")
    private Integer pageNum;
    @NotNull(message = "页数不能为空")
    private Integer pageSize;
}
