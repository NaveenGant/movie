package com.spring.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.movie.model.MovieEntity;
import com.spring.movie.model.RatingEntity;

public interface RatingRepository extends JpaRepository<RatingEntity,String>{
	//sList<RatingEntity> findByEntityAverageRatingGreaterThan(double averageRating);
	List<RatingEntity> findByAveragerateingGreaterThan(double averageRating);
}
