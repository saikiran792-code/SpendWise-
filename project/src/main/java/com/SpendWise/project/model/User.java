package com.SpendWise.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private long userid;
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;
    @NotBlank(message = "set the password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Expense> expenses;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Budget budget;
}
