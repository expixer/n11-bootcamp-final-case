package com.sezginsevinc.restaurant.restaurant;

import java.util.List;
import java.util.Optional;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author sezginsevinc
 */
public interface RestaurantRepository extends SolrCrudRepository<Restaurant,String> {

  Optional<Restaurant> findById(String id);

  List<Restaurant> findAll();

}