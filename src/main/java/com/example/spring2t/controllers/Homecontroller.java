package com.example.spring2t.controllers;


import com.example.spring2t.models.ApplicationRequest;
import com.example.spring2t.models.Course;
import com.example.spring2t.services.ApplicationRequestService;
import com.example.spring2t.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class Homecontroller {

    private final ApplicationRequestService requestService;
    private final CourseService courseService;

    @GetMapping("/")
    public String index(Model model){
        List<ApplicationRequest> requests = requestService.allRequests();
        model.addAttribute("requests", requests);
        return "index";
    }

    @GetMapping("/add-request")
    public String addRequest(Model model){
        List<Course> courses = courseService.allCourses();
        model.addAttribute("courses", courses);
        return "add-request";
    }

    @PostMapping("/add-request")
    public String addRequest(ApplicationRequest request){
        request.setHandled(true);
        requestService.save(request);
        return "redirect:/";
    }

    @GetMapping("/detail/{requestId}")
    public String requestDetails(@PathVariable Long requestId, Model model){
        List<Course> courses = courseService.allCourses();
        ApplicationRequest request = requestService.getRequestById(requestId);
        model.addAttribute("request", request);
        model.addAttribute("courses", courses);
        return "detail";
    }

    @PostMapping("/delete-request/{requestId}")
    public String deleteRequest(@PathVariable Long requestId){
        requestService.deleteRequest(requestId);
        return "redirect:/";
    }

    @PostMapping("update-request")
    public String updateRequest(ApplicationRequest request){
        if (request != null){
            request.setHandled(false);
            requestService.save(request);
        }
        return "redirect:/";
    }

}