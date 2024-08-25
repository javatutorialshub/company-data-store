package com.javatutorialshub.companystore.core.feature.update;

import com.javatutorialshub.companystore.core.exception.ValidateCompanyException;
import com.javatutorialshub.companystore.core.feature.update.exception.UpdateCompanyException;
import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyInputPort;
import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyOutputPort;
import com.javatutorialshub.companystore.core.model.Company;
import jakarta.inject.Inject;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpdateCompanyComponent implements IUpdateCompanyComponent {
    private final IUpdateCompanyOutputPort updateCompanyOutputPort;

    @Inject
    public UpdateCompanyComponent(IUpdateCompanyOutputPort updateCompanyOutputPort) {
        this.updateCompanyOutputPort = updateCompanyOutputPort;
    }

    @Override
    public Company updateCompany(IUpdateCompanyInputPort updateCompanyInputPort) throws ValidateCompanyException, UpdateCompanyException {
        try {
            Company company = updateCompanyInputPort.getCompany();
            return updateCompanyOutputPort.updateCompany(company);
        } catch (ValidationException e) {
            log.warn("Company validation failed due to: {}", e.getMessage());
            throw new ValidateCompanyException(e.getMessage(), e);
        } catch (UpdateCompanyException e) {
            throw e;
        } catch (Exception e) {
            log.warn("Company save failed due to: {}", e.getMessage());
            throw new UpdateCompanyException(e.getMessage(), e);
        }
    }
}
