package com.sezginsevinc.finalcase.controller;

import com.sezginsevinc.finalcase.controller.contract.CustomerControllerContract;
import com.sezginsevinc.finalcase.dto.CustomerDTO;
import com.sezginsevinc.finalcase.dto.request.CustomerUpdatePasswordRequest;
import com.sezginsevinc.finalcase.general.RestResponse;
import com.sezginsevinc.finalcase.dto.request.CustomerSaveRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<RestResponse<CustomerDTO>> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerById = customerControllerContract.getCustomerById(id);
        return ResponseEntity.ok(RestResponse.of(customerById));
    }

    @PostMapping
    @Operation(
            description = "Creates new customer",
            summary = "Create",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Customers",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = CustomerSaveRequest.class
                                    ),
                                    examples = {
                                            @ExampleObject(
                                                    name = "new customer",
                                                    summary = "Normal",
                                                    description = "Complete request with all available fields",
                                                    value = "{\n"
                                                            + "  \"name\": \"sezgin\",\n"
                                                            + "  \"surname\": \"sevinç\",\n"
                                                            + "  \"birthDate\": \"1997-04-10\",\n"
                                                            + "  \"username\": \"btural\",\n"
                                                            + "  \"identityNo\": \"20123456788\",\n"
                                                            + "  \"password\": \"1234\",\n"
                                                            + "  \"phoneNumber\": \"5675786767\",\n"
                                                            + "  \"latitude\": \"39.642913576138824\",\n"
                                                            + "  \"longitude\": \"27.882731056763152\",\n"
                                                            + "  \"email\": \"sezgin@gmail.com\"\n"
                                                            + "}"
                                            )
                                    }
                            )
                    }
            )
    )

    public ResponseEntity<RestResponse<CustomerDTO>> saveCustomer(@RequestBody CustomerSaveRequest request) {
        CustomerDTO customerDTO = customerControllerContract.saveCustomer(request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerControllerContract.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> updateCustomer(
            @PathVariable Long id, @RequestBody CustomerSaveRequest request) {
        CustomerDTO customerDTO = customerControllerContract.saveCustomer(request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }


    @PatchMapping("/{id}/password")
    public ResponseEntity<RestResponse<CustomerDTO>> updateCustomerPassword(
            @PathVariable Long id,
            @RequestBody CustomerUpdatePasswordRequest request) {
        CustomerDTO customerDTO = customerControllerContract.updateCustomerPassword(id, request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }
}
