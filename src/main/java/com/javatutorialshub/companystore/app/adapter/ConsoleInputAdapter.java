package com.javatutorialshub.companystore.app.adapter;

import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyInputPort;
import com.javatutorialshub.companystore.core.model.Company;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInputAdapter implements ICreateCompanyInputPort {
    private final PrintStream out;
    private final Scanner scanner;
    public ConsoleInputAdapter(InputStream in, PrintStream out) {
        this.out = out;
        scanner = new Scanner(in);
    }

    @Override
    public Company getCompany() {
        Company company = new Company();
        out.println("The name of the company ?");
        company.setName(scanner.nextLine());

        out.println("The market cap of the company ?");
        company.setMarketCap(Double.parseDouble(scanner.nextLine()));

        out.println("The employees count of the company ?");
        company.setEmployeesCount(Integer.parseInt(scanner.nextLine()));

        out.println("The economic sector of the company ?");
        company.setEconomicSector(scanner.nextLine().trim().toUpperCase());

        return company;
    }
}
