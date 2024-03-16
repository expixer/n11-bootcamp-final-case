package com.sezginsevinc.finalcase.controller;

import com.sezginsevinc.finalcase.controller.contract.CustomerControllerContract;
import com.sezginsevinc.finalcase.dto.CustomerDTO;
import com.sezginsevinc.finalcase.dto.request.CustomerUpdatePasswordRequest;
import com.sezginsevinc.finalcase.general.RestResponse;
import com.sezginsevinc.finalcase.dto.request.CustomerSaveRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/customers")
@Validated
@Tag(name = "Customer Controller", description = "Customer Management")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerControllerContract customerControllerContract;

  @GetMapping
  public ResponseEntity<RestResponse<List<CustomerDTO>>> getAllCustomers() {
    List<CustomerDTO> allCustomers = customerControllerContract.getAllCustomers();
    return ResponseEntity.ok(RestResponse.of(allCustomers));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RestResponse<CustomerDTO>> getCustomerById(@PathVariable @Positive Long id) {
    CustomerDTO customerById = customerControllerContract.getCustomerById(id);
    return ResponseEntity.ok(RestResponse.of(customerById));
  }

  @PostMapping
  public ResponseEntity<RestResponse<CustomerDTO>> saveCustomer(@Valid @RequestBody CustomerSaveRequest request) {
    CustomerDTO customerDTO = customerControllerContract.saveCustomer(request);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable @NotNull Long id) {
    customerControllerContract.deleteCustomer(id);
  }


  @PatchMapping("/{id}/password")
  public ResponseEntity<RestResponse<CustomerDTO>> updateCustomerPassword(
      @PathVariable @NotNull Long id,
      @Valid @RequestBody CustomerUpdatePasswordRequest request) {
    CustomerDTO customerDTO = customerControllerContract.updateCustomerPassword(id, request);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }
}
