package com.spring.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.movie.model.RatingEntity;

public interface RatingRepository extends JpaRepository<RatingEntity,String>{
	List<RatingEntity> findByAveragerateingGreaterThan(double averageRating);
	 @Query("SELECT r FROM RatingEntity r")
	    List<RatingEntity> getAllRatings();
}
