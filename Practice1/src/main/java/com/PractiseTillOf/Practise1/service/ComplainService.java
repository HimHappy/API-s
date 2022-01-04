package com.PractiseTillOf.Practise1.service;

import com.PractiseTillOf.Practise1.model.ComplaintModel;
import com.PractiseTillOf.Practise1.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public List<ComplaintModel> getComplaints() {
        return complaintRepository.findAll();
    }

    public ComplaintModel postComplaints(ComplaintModel complaintModel) {
        return complaintRepository.save(complaintModel);
    }

    public List<ComplaintModel> getComplaintStatus(String complainStatus) {
        return complaintRepository.gettingbyStstus(complainStatus);
    }
}
