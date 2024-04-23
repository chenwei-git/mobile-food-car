package com.cw.mfc.business.service;

import com.cw.mfc.business.model.Applicant;
import com.cw.mfc.business.request.ApplicantPageRequest;
import com.cw.mfc.business.request.ApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;

public interface ApplicantService {

    int create(Applicant record);

    PageResponse<Applicant> page(ApplicantPageRequest request);

    int modify(Applicant applicant);

    Applicant query(ApplicantQueryRequest request);
}
