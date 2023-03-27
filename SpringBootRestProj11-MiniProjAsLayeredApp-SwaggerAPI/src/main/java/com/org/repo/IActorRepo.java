package com.org.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.model.Actor;

public interface IActorRepo extends JpaRepository<Actor, Integer> {

	@Query("from Actor where category in (:c1, :c2) order by category")
	public List<Actor> getActorsByCategories(@Param("c1") String category1, @Param("c2") String category2);
}
