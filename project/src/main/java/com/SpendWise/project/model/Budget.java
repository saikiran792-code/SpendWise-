package com.SpendWise.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Budget {
    @Id
    private  int budgetid;
    private  long amount;
    private String month;


}
