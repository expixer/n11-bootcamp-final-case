package com.sezginsevinc.finalcase.service.entityservice;

import com.sezginsevinc.finalcase.repository.CustomerRepository;
import com.sezginsevinc.finalcase.entity.Customer;
import com.sezginsevinc.finalcase.general.BaseEntityService;
import org.springframework.stereotype.Service;


@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {

  protected CustomerEntityService(CustomerRepository repository) {
    super(repository);
  }



}
