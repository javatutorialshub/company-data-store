package com.javatutorialshub.companystore.core.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Company {
    private String id;
    @NotBlank
    private String name;
    @PositiveOrZero
    private double marketCap;
    @PositiveOrZero
    private int employeesCount;
    @NotBlank
    private String economicSector;
}