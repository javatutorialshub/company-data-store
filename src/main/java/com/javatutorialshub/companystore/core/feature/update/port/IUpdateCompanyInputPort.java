package com.javatutorialshub.companystore.core.feature.update.port;

import com.javatutorialshub.companystore.core.feature.create.port.ICreateCompanyInputPort;
import com.javatutorialshub.companystore.core.model.Company;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface IUpdateCompanyInputPort extends ICreateCompanyInputPort {
}
