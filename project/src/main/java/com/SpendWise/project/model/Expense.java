package com.SpendWise.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class Expense {
    @Id
    @GeneratedValue
    private  int eid;
    private int ammount;
    private String category;
    private Date date;

}
