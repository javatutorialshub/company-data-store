package com.javatutorialshub.companystore.core.feature.create;

import com.javatutorialshub.companystore.core.exception.ValidateCompanyException;
import com.javatutorialshub.companystore.core.feature.create.exception.CreateCompanyException;
import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyInputPort;
import com.javatutorialshub.companystore.core.model.Company;
import jakarta.validation.constraints.NotNull;

public interface ICreateCompanyComponent {
    @NotNull
    Company createCompany(ICreateCompanyInputPort createCompanyInputPort) throws ValidateCompanyException, CreateCompanyException;
}
