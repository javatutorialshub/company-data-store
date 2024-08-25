package com.javatutorialshub.companystore.app.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.javatutorialshub.companystore.app.adapter.ConsoleUpdateInputAdapter;
import com.javatutorialshub.companystore.core.feature.update.IUpdateCompanyComponent;
import com.javatutorialshub.companystore.core.feature.update.UpdateCompanyComponent;
import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyInputPort;
import com.javatutorialshub.companystore.core.feature.update.port.IUpdateCompanyOutputPort;
import com.javatutorialshub.companystore.infra.feature.update.UpdateCompanyAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpdateCompanyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IUpdateCompanyOutputPort.class).to(UpdateCompanyAdapter.class);
        bind(IUpdateCompanyComponent.class).to(UpdateCompanyComponent.class);
    }

    @Provides
    public IUpdateCompanyInputPort provideUpdateCompanyInputPort(){
        return new ConsoleUpdateInputAdapter(System.in, System.out);
    }
}


