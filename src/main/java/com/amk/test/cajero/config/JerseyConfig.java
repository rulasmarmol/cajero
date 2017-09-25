package com.amk.test.cajero.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.amk.test.cajero.controller.AccountController;
import com.amk.test.cajero.controller.CustomerController;
import com.amk.test.cajero.controller.TransactionController;
import com.amk.test.cajero.exception.AppExceptionMapper;

@Component
public class JerseyConfig extends ResourceConfig {
  
  public JerseyConfig() {
    registerEndpoints();
  }

  private void registerEndpoints() {
    register(CustomerController.class);
    register(AccountController.class);
    register(TransactionController.class);
    register(AppExceptionMapper.class);
  }
}
