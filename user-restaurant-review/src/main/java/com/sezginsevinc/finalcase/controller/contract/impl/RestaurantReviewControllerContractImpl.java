package com.sezginsevinc.finalcase.controller.contract.impl;

import com.sezginsevinc.finalcase.controller.contract.RestaurantReviewControllerContract;
import com.sezginsevinc.finalcase.dto.RestaurantReviewDTO;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewSaveRequest;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewUpdateRequest;
import com.sezginsevinc.finalcase.entity.RestaurantReview;
import com.sezginsevinc.finalcase.mapper.RestaurantReviewMapper;
import com.sezginsevinc.finalcase.service.entityservice.RestaurantReviewEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantReviewControllerContractImpl implements RestaurantReviewControllerContract {

    private final RestaurantReviewEntityService restaurantReviewEntityService;

    @Override
    public RestaurantReviewDTO saveRestaurantReview(RestaurantReviewSaveRequest request) {

        RestaurantReview restaurantReview = RestaurantReviewMapper.INSTANCE.convertToRestaurantReview(request);

        restaurantReview = restaurantReviewEntityService.save(restaurantReview);

        return RestaurantReviewMapper.INSTANCE.convertToRestaurantReviewDTO(restaurantReview);
    }

    @Override
    public List<RestaurantReviewDTO> getAllRestaurantReviews() {

        List<RestaurantReview> restaurantReviewList = restaurantReviewEntityService.findAll();

        return RestaurantReviewMapper.INSTANCE.convertToRestaurantReviewDTOs(restaurantReviewList);
    }


    @Override
    public RestaurantReviewDTO getRestaurantReviewById(Long id) {
        RestaurantReview restaurantReview = restaurantReviewEntityService.findByIdWithControl(id);
        return RestaurantReviewMapper.INSTANCE.convertToRestaurantReviewDTO(restaurantReview);
    }

    @Override
    public void deleteRestaurantReview(Long id) {
        restaurantReviewEntityService.delete(id);
    }

    @Override
    public RestaurantReviewDTO updateRestaurantReview(Long id, RestaurantReviewUpdateRequest request) {

        RestaurantReview restaurantReview = restaurantReviewEntityService.findByIdWithControl(id);
        restaurantReview.setText(request.text());
        restaurantReview.setScore(request.score());
        restaurantReviewEntityService.save(restaurantReview);

        return RestaurantReviewMapper.INSTANCE.convertToRestaurantReviewDTO(restaurantReview);
    }

}
