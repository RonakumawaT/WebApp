package com.rk8.WebDevAssignment.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class appUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;


    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Form> forms;

    @OneToMany(mappedBy = "submittedBy", cascade = CascadeType.ALL)
    private List<FormsResponse> responses;

}
