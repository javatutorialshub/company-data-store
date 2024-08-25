package com.javatutorialshub.companystore.infra.feature.create;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javatutorialshub.companystore.core.feature.create.exception.CreateCompanyException;
import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyOutputPort;
import com.javatutorialshub.companystore.core.model.Company;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.Writer;
import java.util.UUID;

@Slf4j
public class CreateCompanyAdapter implements ICreateCompanyOutputPort {
    @Override
    public Company saveCompany(Company company) throws CreateCompanyException {
        try(Writer writer = new FileWriter(getWriterFileName(company))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String id = UUID.randomUUID().toString();
            company.setId(id);

            gson.toJson(company, writer);
            return company;
        } catch (Exception e) {
            log.warn("Unable to save company due to: {}", e.getMessage());
            throw new CreateCompanyException(e.getMessage(), e);
        }
    }

    public static String getWriterFileName(Company company) {
        return "data/" + company.getName().trim().toLowerCase() + ".json";
    }
}
