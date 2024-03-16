package com.sezginsevinc.finalcase.controller.contract;

import com.sezginsevinc.finalcase.dto.CustomerDTO;
import com.sezginsevinc.finalcase.dto.request.CustomerSaveRequest;
import com.sezginsevinc.finalcase.dto.request.CustomerUpdatePasswordRequest;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewUpdateRequest;
import com.sezginsevinc.finalcase.dto.request.CustomerUpdateRequest;
import java.util.List;


public interface CustomerControllerContract {

  CustomerDTO saveCustomer(CustomerSaveRequest request);

  List<CustomerDTO> getAllCustomers();

  CustomerDTO updateCustomer(CustomerUpdateRequest request);

  CustomerDTO getCustomerById(Long id);

  void deleteCustomer(Long id);

  CustomerDTO updateCustomerPassword(Long id, CustomerUpdatePasswordRequest request);
}
