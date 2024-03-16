package com.sezginsevinc.finalcase.service.entityservice;

import com.sezginsevinc.finalcase.entity.RestaurantReview;
import com.sezginsevinc.finalcase.general.BaseEntityService;
import com.sezginsevinc.finalcase.repository.RestaurantReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestaurantReviewEntityService extends BaseEntityService<RestaurantReview, RestaurantReviewRepository> {

  protected RestaurantReviewEntityService(RestaurantReviewRepository repository) {
    super(repository);
  }


    public List<RestaurantReview> getRestaurantReviewsByRestaurantId(Long restaurantId) {
        return getRepository().findByRestaurantId(restaurantId);
    }
}
