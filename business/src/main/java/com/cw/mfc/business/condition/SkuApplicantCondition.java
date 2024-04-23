package com.cw.mfc.business.condition;

import com.cw.mfc.business.request.SkuApplicantPageRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkuApplicantCondition {
    private String name;
    private String code;
    private String applicantId;

    public static SkuApplicantCondition convert(SkuApplicantPageRequest src) {
        SkuApplicantCondition skuApplicantCondition = new SkuApplicantCondition();
        skuApplicantCondition.setName(src.getName());
        skuApplicantCondition.setCode(src.getCode());
        skuApplicantCondition.setApplicantId(src.getApplicantId());
        return skuApplicantCondition;
    }
}
