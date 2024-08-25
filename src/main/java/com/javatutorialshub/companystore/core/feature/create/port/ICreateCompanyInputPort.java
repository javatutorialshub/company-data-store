package com.javatutorialshub.companystore.core.feature.create.port;

import com.javatutorialshub.companystore.core.model.Company;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ICreateCompanyInputPort {
    @NotNull
    @Valid
    Company getCompany();
}
