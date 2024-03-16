package com.sezginsevinc.finalcase.entity;

import com.sezginsevinc.finalcase.general.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "RESTAURANT_REVIEW")
@Getter
@Setter
public class RestaurantReview extends BaseEntity {

    @SequenceGenerator(name = "RestaurantReview", sequenceName = "RESTAURANT_REVIEW_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RestaurantReview")
    @Id
    private Long id;

    @Column(name = "TEXT", length = 1000)
    private String text;

    @Max(5)
    @Min(1)
    @Column(name = "SCORE", length = 1)
    private Integer score;

    @Column(name = "RESTAURANT_ID", nullable = false)
    private Long restaurantId;
}
