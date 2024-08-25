package com.javatutorialshub.companystore.core.feature.update.port;

import com.javatutorialshub.companystore.core.feature.update.exception.UpdateCompanyException;
import com.javatutorialshub.companystore.core.model.Company;

public interface IUpdateCompanyOutputPort {
    Company updateCompany(Company company) throws UpdateCompanyException;
}
