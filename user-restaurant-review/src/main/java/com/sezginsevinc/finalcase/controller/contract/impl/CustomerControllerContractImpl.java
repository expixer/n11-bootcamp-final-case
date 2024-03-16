package com.sezginsevinc.finalcase.controller.contract.impl;

import com.sezginsevinc.finalcase.controller.contract.CustomerControllerContract;
import com.sezginsevinc.finalcase.dto.CustomerDTO;
import com.sezginsevinc.finalcase.dto.request.CustomerUpdatePasswordRequest;
import com.sezginsevinc.finalcase.entity.Customer;
import com.sezginsevinc.finalcase.error.errormessage.RestaurantReviewErrorMessage;
import com.sezginsevinc.finalcase.general.BusinessException;
import com.sezginsevinc.finalcase.mapper.CustomerMapper;
import com.sezginsevinc.finalcase.dto.request.CustomerSaveRequest;
import com.sezginsevinc.finalcase.dto.request.CustomerUpdateRequest;
import com.sezginsevinc.finalcase.service.entityservice.CustomerEntityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerControllerContractImpl implements CustomerControllerContract {

  private final CustomerEntityService customerEntityService;

  @Override
  public CustomerDTO saveCustomer(CustomerSaveRequest request) {

    Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

    customer = customerEntityService.save(customer);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }

  @Override
  public List<CustomerDTO> getAllCustomers() {

    List<Customer> customerList = customerEntityService.findAll();

    return CustomerMapper.INSTANCE.convertToCustomerDTOs(customerList);
  }

  @Override
  public CustomerDTO updateCustomer(CustomerUpdateRequest request) {

    Customer customer = customerEntityService.findByIdWithControl(request.id());
    CustomerMapper.INSTANCE.updateCustomerFields(customer, request);

    customerEntityService.save(customer);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }

  @Override
  public CustomerDTO getCustomerById(Long id) {
    Customer customer = customerEntityService.findByIdWithControl(id);
    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }

  @Override
  public void deleteCustomer(Long id) {
    customerEntityService.delete(id);
  }

  @Override
  public CustomerDTO updateCustomerPassword(Long id, CustomerUpdatePasswordRequest request) {

    Customer customer = customerEntityService.findByIdWithControl(id);

    if (!customer.getPassword().equals(request.oldPass())) {
      throw new BusinessException(RestaurantReviewErrorMessage.INVALID_OLD_PASSWORD);
    }

    if (!request.newPass().equals(request.newPass2())) {
      throw new BusinessException(RestaurantReviewErrorMessage.NEW_PASSWORDS_DID_NOT_MATCH);
    }

    customer.setPassword(request.newPass());
    customerEntityService.save(customer);

    return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
  }
}
