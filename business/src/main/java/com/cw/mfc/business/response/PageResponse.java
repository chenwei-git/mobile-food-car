package com.cw.mfc.business.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PageResponse<T> {
    private Long total;
    private List<T> list;
}
