package com.it.healthinformation.service;



import com.it.common.entity.HealthInformation;

import java.util.List;

public interface HealthInformationService {

    Long getTotal();

    List<HealthInformation> getHealthInformationProfileByPage(int currentPage, int pageSize);

    HealthInformation getHealthInformationDetail(int id);
}
