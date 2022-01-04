package com.PractiseTillOf.Practise1.controller;

import com.PractiseTillOf.Practise1.model.ComplaintModel;
import com.PractiseTillOf.Practise1.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complains")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ComplaintModel> getComplaints(){
        return complainService.getComplaints();
    }
    @GetMapping(path = "get-compaints/{complainStatus}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ComplaintModel> getComplaintByStatus(@PathVariable("complainStatus") String complainStatus){
        return complainService.getComplaintStatus(complainStatus);
    }

    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ComplaintModel postComplaints(@RequestBody ComplaintModel complaintModel){
        return complainService.postComplaints(complaintModel);
    }
}
