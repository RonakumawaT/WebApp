package com.rk8.WebDevAssignment.Service;

import com.rk8.WebDevAssignment.Models.Form;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {

    List<Form> getAllForms();
    Form getFromById(int id);
    void deleteForm(int id);
    Form updateForm(int id,Form form);
    Form createForm(Form form,Long userId);

}
