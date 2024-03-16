package com.sezginsevinc.finalcase.service;

import com.sezginsevinc.finalcase.entity.Customer;
import com.sezginsevinc.finalcase.entity.Restaurant;
import com.sezginsevinc.finalcase.service.entity.CustomerEntityService;
import com.sezginsevinc.finalcase.service.entity.RestaurantEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RestaurantEntityService restaurantEntityService;

    private final CustomerEntityService customerEntityService;

    public List<Restaurant> getRecommendations(Long userId) {
        Customer customer = customerEntityService.findByIdWithControl(userId);
        List<Restaurant> restaurants = restaurantEntityService.findAll();

        return restaurants.stream()
                .filter(r -> calculateDistance(customer.getLatitude(), customer.getLongitude(), new BigDecimal(r.getLatitude()), new BigDecimal(r.getLongitude())).compareTo(BigDecimal.TEN) <= 0)
                .sorted((r1, r2) -> calculateScore(customer, r2).compareTo(calculateScore(customer, r1)))
                .limit(10)
                .collect(Collectors.toList());
    }

    private BigDecimal calculateDistance(BigDecimal userLat, BigDecimal userLng, BigDecimal restaurantLat, BigDecimal restaurantLng) {
        // Haversine formula
        double earthRadius = 6371; // Approximate radius of Earth (km)

        double dLat = Math.toRadians(restaurantLat.subtract(userLat).doubleValue());
        double dLng = Math.toRadians(restaurantLng.subtract(userLng).doubleValue());

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(userLat.doubleValue())) * Math.cos(Math.toRadians(restaurantLat.doubleValue())) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return BigDecimal.valueOf(distance);
    }

    private BigDecimal calculateScore(Customer customer, Restaurant restaurant) {
        BigDecimal distanceScore = calculateDistance(customer.getLatitude(), customer.getLongitude(), new BigDecimal(restaurant.getLatitude()), new BigDecimal(restaurant.getLongitude())).divide(BigDecimal.TEN, 14, RoundingMode.HALF_UP);
        BigDecimal ratingScore = BigDecimal.valueOf(restaurantEntityService.getAverageRating(Long.valueOf(restaurant.getId()))).divide(BigDecimal.valueOf(5), 14, RoundingMode.HALF_UP);

        return ratingScore.multiply(BigDecimal.valueOf(0.7)).add(distanceScore.multiply(BigDecimal.valueOf(0.3)).subtract(BigDecimal.valueOf(1)).multiply(BigDecimal.valueOf(-0.3)));
    }
}