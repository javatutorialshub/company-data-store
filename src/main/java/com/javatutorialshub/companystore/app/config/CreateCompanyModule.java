package com.javatutorialshub.companystore.app.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.javatutorialshub.companystore.app.adapter.ConsoleInputAdapter;
import com.javatutorialshub.companystore.core.feature.create.CreateCompanyComponent;
import com.javatutorialshub.companystore.core.feature.create.ICreateCompanyComponent;
import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyInputPort;
import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyOutputPort;
import com.javatutorialshub.companystore.infra.feature.create.CreateCompanyAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateCompanyModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            bind(ICreateCompanyComponent.class).toConstructor(CreateCompanyComponent.class.getConstructor(ICreateCompanyOutputPort.class));
            bind(ICreateCompanyOutputPort.class).to(CreateCompanyAdapter.class);
        } catch (NoSuchMethodException e) {
            log.warn("Unable to locate suitable constructor for UpdateCompanyComponent class", e);
            throw new ConfigurationException(e);
        }
    }

    @Provides
    public ICreateCompanyInputPort provideCreateCompanyInputPort(){
        return new ConsoleInputAdapter(System.in, System.out);
    }
}


