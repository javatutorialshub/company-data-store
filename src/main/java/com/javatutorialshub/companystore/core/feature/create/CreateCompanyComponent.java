package com.javatutorialshub.companystore.core.feature.create;

import com.javatutorialshub.companystore.core.exception.ValidateCompanyException;
import com.javatutorialshub.companystore.core.feature.create.exception.CreateCompanyException;
import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyInputPort;
import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyOutputPort;
import com.javatutorialshub.companystore.core.model.Company;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateCompanyComponent implements ICreateCompanyComponent {
    private final ICreateCompanyOutputPort createCompanyOutputPort;


    @Override
    public Company createCompany(ICreateCompanyInputPort createCompanyInputPort) throws ValidateCompanyException, CreateCompanyException {
        try {
            Company company = createCompanyInputPort.getCompany();
            return createCompanyOutputPort.saveCompany(company);
        } catch (ValidationException e) {
            log.warn("Company validation failed due to: {}", e.getMessage());
            throw new ValidateCompanyException(e.getMessage(), e);
        } catch (CreateCompanyException e) {
            throw e;
        } catch (Exception e) {
            log.warn("Company save failed due to: {}", e.getMessage());
            throw new CreateCompanyException(e.getMessage(), e);
        }
    }
}
