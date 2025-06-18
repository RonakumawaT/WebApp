package com.rk8.WebDevAssignment.Repo;

import com.rk8.WebDevAssignment.Models.FormsResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormResponseRepo extends JpaRepository<FormsResponse,Integer> {
    List<FormsResponse> findByFormId(int formId);
}
