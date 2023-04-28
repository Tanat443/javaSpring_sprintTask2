package kz.springboot.bitltabdemo.services.impl;

import kz.springboot.bitltabdemo.entities.ApplicationRequest;
import kz.springboot.bitltabdemo.repositories.ApplicationRequestRepository;
import kz.springboot.bitltabdemo.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationRequestImpl implements ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @Override
    public ApplicationRequest addAppRequest(ApplicationRequest appRequest) {
        return applicationRequestRepository.save(appRequest);
    }

    @Override
    public List<ApplicationRequest> getAllAppRequests() {
        return applicationRequestRepository.findAll();
    }

    @Override
    public List<ApplicationRequest> getProcessedAppRequests() {
        return applicationRequestRepository.findApplicationRequestsByHandledIsTrue();
    }

    @Override
    public List<ApplicationRequest> getUnProcessedAppRequests() {
        return applicationRequestRepository.findApplicationRequestsByHandledIsFalse();
    }

    @Override
    public ApplicationRequest getAppRequest(Long id) {
        return applicationRequestRepository.getReferenceById(id);
    }

    @Override
    public void deleteAppRequest(Long id) {
        applicationRequestRepository.deleteById(id);
    }

    @Override
    public ApplicationRequest updateAppRequest(ApplicationRequest appRequest) {
        return applicationRequestRepository.save(appRequest);
    }
}
