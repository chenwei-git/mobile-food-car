package com.cw.mfc.business.service;

import com.cw.mfc.business.model.LocationApplicant;
import com.cw.mfc.business.request.LocationApplicantPageRequest;
import com.cw.mfc.business.request.LocationApplicantQueryRequest;
import com.cw.mfc.business.response.PageResponse;
public interface LocationApplicantService{

    int create(LocationApplicant data);

    PageResponse<LocationApplicant> page(LocationApplicantPageRequest request);

    LocationApplicant query(LocationApplicantQueryRequest request);

    int modify(LocationApplicant locationApplicant);
}
