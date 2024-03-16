package com.sezginsevinc.finalcase.mapper;

import com.sezginsevinc.finalcase.dto.response.RestaurantResponseDTO;
import com.sezginsevinc.finalcase.entity.Restaurant;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

  RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

  RestaurantResponseDTO convertToRestaurantResponseDTO(Restaurant restaurant);

  List<Restaurant> convertToRestaurant(List<Restaurant> restaurant);

}
