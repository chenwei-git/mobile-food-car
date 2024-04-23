package com.cw.mfc.business.service;

import com.cw.mfc.business.model.Location;
import com.cw.mfc.business.request.LocationPageRequest;
import com.cw.mfc.business.request.LocationQueryRequest;
import com.cw.mfc.business.response.PageResponse;
public interface LocationService{

    int create(Location location);

    PageResponse<Location> page(LocationPageRequest request);

    Location query(LocationQueryRequest request);

    int modify(Location location);
}
