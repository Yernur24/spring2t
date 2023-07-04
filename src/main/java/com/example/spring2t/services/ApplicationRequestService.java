package com.example.spring2t.services;

import com.example.spring2t.models.ApplicationRequest;
import com.example.spring2t.repositories.ApplicationRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationRequestService {
    private final ApplicationRequestRepository applicationRequestRepository;

    public List<ApplicationRequest> allRequests(){
        return applicationRequestRepository.findAll();
    }

    public ApplicationRequest getRequestById(Long id){
        return applicationRequestRepository.findById(id).orElse(null);
    }

    public void save(ApplicationRequest request){
        applicationRequestRepository.save(request);
    }

    public  void deleteRequest(Long id){
        applicationRequestRepository.deleteById(id);
    }

    public ApplicationRequest findRequest(Long id){
        return  applicationRequestRepository.findById(id).orElse(null);
    }
}
