package com.amk.test.cajero.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.amk.test.cajero.controller.AccountController;
import com.amk.test.cajero.controller.CustomerController;
import com.amk.test.cajero.controller.TransactionController;
import com.amk.test.cajero.exception.AppExceptionMapper;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

@Component
public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    registerEndpoints();
    configureSwagger();
  }
  

  private void registerEndpoints() {
    register(CustomerController.class);
    register(AccountController.class);
    register(TransactionController.class);
    register(AppExceptionMapper.class);
    register(ApiListingResource.class);
  }
  
  private void configureSwagger() {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setTitle("API Restful + JAX-RS + Cajero AMK");
    beanConfig.setVersion("0.0.1");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setContact("Carlos R. Marmolejo");
    beanConfig.setHost("localhost:8080");
    beanConfig.setBasePath("/swagger");
    beanConfig.setResourcePackage("com.amk.test.cajero.controller");
    beanConfig.setPrettyPrint(true);
    beanConfig.setScan(true);
}
}
