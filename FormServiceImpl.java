package com.rk8.WebDevAssignment.Service;

import com.rk8.WebDevAssignment.Exception.InvalidInputException;
import com.rk8.WebDevAssignment.Exception.ResourceNotFoundException;
import com.rk8.WebDevAssignment.Models.Form;
import com.rk8.WebDevAssignment.Repo.FormRepo;
import com.rk8.WebDevAssignment.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FormServiceImpl implements FormService{

    @Autowired
    private FormRepo formRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Form> getAllForms() {
        return formRepo.findAll();
    }

    @Override
    public Form getFromById(int id) {
        return formRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Form with ID " + id + " not found"));
    }

    @Override
    public void deleteForm(int id) {
        formRepo.deleteById(id);
    }

    @Override
    public Form updateForm(int id,Form updatedForm) {
        Form form = formRepo.findById(id).orElseThrow(()-> new RuntimeException("Form not found"));
        form.setName(updatedForm.getName());
        form.setDescription(updatedForm.getDescription());
        form.setUpdatedAt(LocalDateTime.now());
        form.setCreatedAt(LocalDateTime.now());
        form.setLayoutJson(updatedForm.getLayoutJson());
        return formRepo.save(form);
    }

    @Override
    public Form createForm(Form form, Long userId) {
        if (form.getName() == null || form.getLayoutJson() == null) {
            throw new InvalidInputException("Form name and layout are required.");
        }

        var user = userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with ID " + userId + " not found"));

        form.setCreatedBy(user);
        form.setCreatedAt(LocalDateTime.now());
        form.setUpdatedAt(LocalDateTime.now());

        return formRepo.save(form);
    }
}
