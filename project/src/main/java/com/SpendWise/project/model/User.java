package com.SpendWise.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import org.springframework.context.annotation.Primary;

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
}
