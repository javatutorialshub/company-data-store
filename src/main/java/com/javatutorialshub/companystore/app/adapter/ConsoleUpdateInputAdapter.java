package com.javatutorialshub.companystore.app.adapter;

import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyInputPort;
import com.javatutorialshub.companystore.core.model.Company;

import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleUpdateInputAdapter implements IUpdateCompanyInputPort {

    private final ConsoleInputAdapter consoleInputAdapter;

    public ConsoleUpdateInputAdapter(InputStream in, PrintStream out) {
        consoleInputAdapter = new ConsoleInputAdapter(in, out);
    }


    @Override
    public Company getCompany() {
        return consoleInputAdapter.getCompany();
    }
}
