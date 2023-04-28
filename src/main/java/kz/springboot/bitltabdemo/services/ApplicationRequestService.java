package kz.springboot.bitltabdemo.services;

import kz.springboot.bitltabdemo.entities.ApplicationRequest;

import java.util.List;

public interface ApplicationRequestService {
    ApplicationRequest addAppRequest(ApplicationRequest appRequest);
    List<ApplicationRequest> getAllAppRequests();
    List<ApplicationRequest> getProcessedAppRequests();
    List<ApplicationRequest> getUnProcessedAppRequests();
    ApplicationRequest getAppRequest(Long id);
    void deleteAppRequest(Long id);
    ApplicationRequest updateAppRequest(ApplicationRequest appRequest);

}
