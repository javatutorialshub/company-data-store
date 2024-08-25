package com.javatutorialshub.companystore.core.feature.create.port;

import com.javatutorialshub.companystore.core.feature.create.exception.CreateCompanyException;
import com.javatutorialshub.companystore.core.model.Company;

public interface ICreateCompanyOutputPort {
    Company saveCompany(Company company) throws CreateCompanyException;
}
