package com.rk8.WebDevAssignment.Service;

import com.rk8.WebDevAssignment.Exception.ResourceNotFoundException;
import com.rk8.WebDevAssignment.Models.Form;
import com.rk8.WebDevAssignment.Models.FormsResponse;
import com.rk8.WebDevAssignment.Models.appUser;
import com.rk8.WebDevAssignment.Repo.FormRepo;
import com.rk8.WebDevAssignment.Repo.FormResponseRepo;
import com.rk8.WebDevAssignment.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FormResponseServiceImpl implements FormResponseService{

    @Autowired
    private FormResponseRepo formResponseRepo;

    @Autowired
    private FormRepo formRepo;

    @Autowired
    private UserRepo userRepo;

    public FormsResponse saveResponse(int formId, String responseJson, Long userId) {
        Form form = formRepo.findById(formId)
                .orElseThrow(() -> new ResourceNotFoundException("Form with ID " + formId + " not found"));

        appUser user = (userId != null) ? userRepo.findById(userId).orElse(null) : null;

        FormsResponse response = new FormsResponse();
        response.setForm(form);
        response.setSubmittedBy(user);
        response.setResponseData(responseJson);
        response.setSubmittedAt(LocalDateTime.now());
        return formResponseRepo.save(response);
    }


    @Override
    public List<FormsResponse> getAllFormResponse(int id) {
        if (!formRepo.existsById(id)) {
            throw new ResourceNotFoundException("Form with ID " + id + " not found");
        }
        return formResponseRepo.findByFormId(id);
    }
}
