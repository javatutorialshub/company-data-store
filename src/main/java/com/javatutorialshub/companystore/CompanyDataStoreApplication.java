package com.javatutorialshub.companystore;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.javatutorialshub.companystore.app.config.CreateCompanyModule;
import com.javatutorialshub.companystore.app.config.UpdateCompanyModule;
import com.javatutorialshub.companystore.core.feature.create.ICreateCompanyComponent;
import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyInputPort;
import com.javatutorialshub.companystore.core.feature.update.IUpdateCompanyComponent;
import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyInputPort;
import com.javatutorialshub.companystore.core.model.Company;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class CompanyDataStoreApplication {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CreateCompanyModule(), new UpdateCompanyModule());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which action do you want to do (C: create, U: update) ?");
        String action = scanner.nextLine();
        switch (action) {
            case "A" -> doCreateCompany(injector);
            case "U" -> doUpdateCompany(injector);
            default -> {/*Nothing to do*/}
        }
    }

    private static void doCreateCompany(Injector injector) {
        ICreateCompanyComponent createCompanyComponent = injector.getInstance(ICreateCompanyComponent.class);
        ICreateCompanyInputPort createCompanyInputPort = injector.getInstance(ICreateCompanyInputPort.class);
        try {
            Company company = createCompanyComponent.createCompany(createCompanyInputPort);
            log.info(company.toString());
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    private static void doUpdateCompany(Injector injector) {
        IUpdateCompanyComponent updateCompanyComponent = injector.getInstance(IUpdateCompanyComponent.class);
        IUpdateCompanyInputPort updateCompanyInputPort = injector.getInstance(IUpdateCompanyInputPort.class);
        try {
            Company company = updateCompanyComponent.updateCompany(updateCompanyInputPort);
            log.info(company.toString());
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}