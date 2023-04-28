package kz.springboot.bitltabdemo.controllers;

import kz.springboot.bitltabdemo.entities.ApplicationRequest;
import kz.springboot.bitltabdemo.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestService applicationRequestService;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        List<ApplicationRequest> appRequests = applicationRequestService.getAllAppRequests();
        model.addAttribute("appRequests", appRequests);
        return "home";
    }

    @GetMapping(value = "/processedAppRequest")
    public String processedAppRequest(Model model) {
        List<ApplicationRequest> appRequests = applicationRequestService.getProcessedAppRequests();
        model.addAttribute("appRequests", appRequests);
        return "processed";
    }

    @GetMapping(value = "/unProcessedAppRequest")
    public String unProcessedAppRequest(Model model) {
        List<ApplicationRequest> appRequests = applicationRequestService.getUnProcessedAppRequests();
        model.addAttribute("appRequests", appRequests);
        return "processed";
    }

    @GetMapping(value = "/addAppRequest")
    public String AddApplicationRequestPage() {
        return "addItem";
    }


    @PostMapping(value = "/addAppRequest")
    public String AddApplicationRequest(ApplicationRequest applicationRequest) {
        applicationRequestService.addAppRequest(applicationRequest);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String detailsPage(Model model, @PathVariable(name = "id") Long id) {
        ApplicationRequest appRequest = applicationRequestService.getAppRequest(id);
        model.addAttribute("appRequest", appRequest);
        return "details";
    }

    @PostMapping(value = "/processApp")
    public String processApp(@RequestParam(name = "id", defaultValue = "0") Long id) {
        ApplicationRequest item = applicationRequestService.getAppRequest(id);
        if (item != null) {
            item.setHandled(true);
            applicationRequestService.updateAppRequest(item);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/deleteAppRequest")
    public String deleteItem(@RequestParam(name = "id", defaultValue = "0") Long id) {
        ApplicationRequest appRequest = applicationRequestService.getAppRequest(id);

        if (appRequest != null) {
            applicationRequestService.deleteAppRequest(appRequest.getId());
        }
        return "redirect:/";
    }
}
