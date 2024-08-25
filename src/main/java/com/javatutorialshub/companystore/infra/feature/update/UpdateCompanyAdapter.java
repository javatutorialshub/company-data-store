package com.javatutorialshub.companystore.infra.feature.update;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javatutorialshub.companystore.core.feature.update.exception.UpdateCompanyException;
import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyOutputPort;
import com.javatutorialshub.companystore.core.model.Company;
import com.javatutorialshub.companystore.infra.feature.create.CreateCompanyAdapter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class UpdateCompanyAdapter implements IUpdateCompanyOutputPort {
    @Override
    public Company updateCompany(Company company) throws UpdateCompanyException {
        String fileName = CreateCompanyAdapter.getWriterFileName(company);
        if(!Paths.get(fileName).toFile().exists()) {
            throw new UpdateCompanyException("Company Not Found");
        }

        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            throw new UpdateCompanyException("Unable to delete and recreate company file for update");
        }

        try(Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(company, writer);
            return company;
        } catch (Exception e) {
            log.warn("Unable to update company due to: {}", e.getMessage());
            throw new UpdateCompanyException(e.getMessage(), e);
        }
    }
}
