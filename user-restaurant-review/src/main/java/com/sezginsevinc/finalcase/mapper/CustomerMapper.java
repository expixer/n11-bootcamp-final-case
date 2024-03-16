package com.sezginsevinc.finalcase.mapper;

import com.sezginsevinc.finalcase.dto.CustomerDTO;
import com.sezginsevinc.finalcase.entity.Customer;
import com.sezginsevinc.finalcase.dto.request.CustomerSaveRequest;
import com.sezginsevinc.finalcase.dto.request.CustomerUpdateRequest;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  Customer convertToCustomer(CustomerSaveRequest request);

  CustomerDTO convertToCustomerDTO(Customer customer);

  List<CustomerDTO> convertToCustomerDTOs(List<Customer> customers);

  @Mapping(target = "id", ignore = true)
  void updateCustomerFields(@MappingTarget Customer customer, CustomerUpdateRequest request);
}
