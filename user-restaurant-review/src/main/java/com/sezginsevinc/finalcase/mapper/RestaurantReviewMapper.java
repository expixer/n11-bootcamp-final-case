package com.sezginsevinc.finalcase.mapper;

import com.sezginsevinc.finalcase.dto.RestaurantReviewDTO;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewSaveRequest;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewUpdateRequest;
import com.sezginsevinc.finalcase.entity.RestaurantReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantReviewMapper {

  RestaurantReviewMapper INSTANCE = Mappers.getMapper(RestaurantReviewMapper.class);

  RestaurantReview convertToRestaurantReview(RestaurantReviewSaveRequest request);

  RestaurantReviewDTO convertToRestaurantReviewDTO(RestaurantReview customer);

  List<RestaurantReviewDTO> convertToRestaurantReviewDTOs(List<RestaurantReview> customers);

  @Mapping(target = "id", ignore = true)
  void updateRestaurantReviewFields(@MappingTarget RestaurantReview customer, RestaurantReviewUpdateRequest request);
}
