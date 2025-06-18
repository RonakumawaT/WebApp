package com.rk8.WebDevAssignment.Controller;

import com.rk8.WebDevAssignment.Models.Form;
import com.rk8.WebDevAssignment.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin(origins = "*")
public class FormController {

    @Autowired
    private FormService service;

    @GetMapping()
    ResponseEntity<List<Form>> getAllForms(){
        List<Form> formList = service.getAllForms();
        return new ResponseEntity<>(formList, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    ResponseEntity<Form> getFormById(@PathVariable int id){
        Form form = service.getFromById(id);
        return new ResponseEntity<>(form,HttpStatus.FOUND);
    }


    @PostMapping
    public ResponseEntity<Form> createForm(
            @RequestBody Form form,
            @RequestParam Long userId
    ) {
        Form createdForm = service.createForm(form, userId);
        return new ResponseEntity<>(createdForm, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteForm(@PathVariable int id){
        service.deleteForm(id);
        return new ResponseEntity<>("Form deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Form> updateForm(@PathVariable int id, @RequestBody Form form){
        Form form1 = service.updateForm(id,form);
        return new ResponseEntity<>(form1,HttpStatus.OK);
    }

}
