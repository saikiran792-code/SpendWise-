package com.SpendWise.project.dto;

import lombok.Data;

@Data
public class BudgetStatusDTO {
    private long budgetamount;
    private long totalexpense;
    private  long remaining;
    private long percentageofspend;
    private String status;
}
