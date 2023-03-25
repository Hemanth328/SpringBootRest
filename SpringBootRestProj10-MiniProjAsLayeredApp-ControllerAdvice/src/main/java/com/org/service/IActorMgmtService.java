package com.org.service;

import java.util.List;

import com.org.model.Actor;

public interface IActorMgmtService {

	public String registrActor(Actor actor);
	
	public List<Actor> getAllActors();
	
	public Actor getActorById(int id);
	
	public List<Actor> getActorsByCategory(String category1, String category2);
	
	public String updateActor(Actor actor);
	
	public String deleteActorById(int id);
	
	public String updateActorMobileNo(Integer Id, Long newMobileNo);
}
