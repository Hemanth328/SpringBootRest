package com.org.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.exception.ActorNotFoundException;
import com.org.model.Actor;
import com.org.repo.IActorRepo;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	IActorRepo actorRepo;
	
	@Override
	public String registrActor(Actor actor) {
		
		Actor actors = actorRepo.save(actor);
		
		return "Actor Registration Id is "+actors.getActorId();
	}
	
	@Override
	public List<Actor> getAllActors() {
		List<Actor> list = actorRepo.findAll();
//		list.sort((t1, t2) ->t1.getActorName().compareTo(t2.getActorName()));
//		Collections.sort(list, (t1, t2)->t1.getActorName().compareTo(t2.getActorName())); // either we can use this nor we can use the above technique to sort as per the name
//		
		list.sort((x, y) -> x.getActorName().compareTo(y.getActorName()));
		
//		list.stream().sorted();
		return list;
	}
	
	@Override
	public Actor getActorById(int id) {
		
//		Actor actor = actorRepo.findById(id).get();
//		return actor;
		
		return actorRepo.findById(id).orElseThrow(() ->new IllegalArgumentException());
	}
	
	
	@Override
	public List<Actor> getActorsByCategory(String category1, String category2) {
		
		List<Actor> list = actorRepo.getActorsByCategories(category1, category2);
		
		return list;
	}
	
	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> optactor = actorRepo.findById(actor.getActorId());
		
		if(optactor.isPresent()) {
			actorRepo.save(actor); // either actor or opt.get both gives the same result
			return "Actor "+actor.getActorId()+" details are updated";
		}
		else {
			throw new ActorNotFoundException("Actor details does not exists");
		}
			
	}
	
	
	@Override
	public String deleteActorById(int id) {
		
		Optional<Actor> opt = actorRepo.findById(id);
		
		if(opt.isPresent()) {
			actorRepo.deleteById(id);
			return "Actor details are deleted";
		}
		else {
			throw new ActorNotFoundException("Actor Not Found");
		}
	}
	
	
	@Override
	public String updateActorMobileNo(Integer id, Long newMobileNo) {
		
		Optional<Actor> actor = actorRepo.findById(id);
		
		if(actor.isPresent()) {
			Actor act = actor.get();
			act.setMobileNo(newMobileNo);
			
			actorRepo.save(act);
			return id+" Mobile number has updated";
		}
		else {
			throw new ActorNotFoundException("Actor with "+id+" not found");
		}
	}
	
}
