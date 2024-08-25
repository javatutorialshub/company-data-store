package com.javatutorialshub.companystore.core.feature.update;

import com.javatutorialshub.companystore.core.exception.ValidateCompanyException;
import com.javatutorialshub.companystore.core.feature.update.exception.UpdateCompanyException;
import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyInputPort;
import com.javatutorialshub.companystore.core.model.Company;
import jakarta.validation.constraints.NotNull;

public interface IUpdateCompanyComponent {
    @NotNull
    Company updateCompany(IUpdateCompanyInputPort updateCompanyInputPort) throws ValidateCompanyException, UpdateCompanyException;
}
