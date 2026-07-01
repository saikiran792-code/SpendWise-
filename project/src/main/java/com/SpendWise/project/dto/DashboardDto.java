package com.SpendWise.project.dto;

import lombok.Data;

@Data
public class DashboardDto {
    private String name;
    private long budgetamount;
    private  long totalexpense;
    private long remaining;
    private long percentageofspend;
    private String status;
}
