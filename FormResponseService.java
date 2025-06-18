package com.rk8.WebDevAssignment.Service;

import com.rk8.WebDevAssignment.Models.FormsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormResponseService {

    FormsResponse saveResponse(int formId, String responseJson, Long userId);

    List<FormsResponse> getAllFormResponse(int id);

}
