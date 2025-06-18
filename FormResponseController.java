package com.rk8.WebDevAssignment.Controller;

import com.rk8.WebDevAssignment.Models.FormsResponse;
import com.rk8.WebDevAssignment.Service.FormResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form/{formId}/responses")
@CrossOrigin(origins = "*")
public class FormResponseController {

    @Autowired
    private FormResponseService service;

    @GetMapping()
    ResponseEntity<List<FormsResponse>> getAllFormResponses(@PathVariable int formId){
       List<FormsResponse> formsResponses =  service.getAllFormResponse(formId);
       return new ResponseEntity<>(formsResponses, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<FormsResponse> submitResponse(
            @PathVariable int formId,
            @RequestParam(required = false) Long userId,
            @RequestBody String responseJson) {

        FormsResponse formsResponse = service.saveResponse(formId, responseJson, userId);
        return new ResponseEntity<>(formsResponse, HttpStatus.OK);
    }

}
