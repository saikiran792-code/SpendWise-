package com.SpendWise.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Budget {
    @Id
    private  int budgetid;
    private  long amount;
    private String month;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


}
