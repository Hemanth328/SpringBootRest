package com.org.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Actor;
import com.org.service.IActorMgmtService;
import jakarta.servlet.http.HttpSessionAttributeListener;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationnsController {

	@Autowired
	private IActorMgmtService actorService;

	@PostMapping("/register")
	public ResponseEntity<String> actorRegistration(@RequestBody Actor actor) {

		String result = actorService.registrActor(actor);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);

	}

	/*@GetMapping("/employeesList")
	public ResponseEntity<List<Actor>> fetchAllActors() {
		// use service
		try {
			List<Actor> list = actorService.getAllActors();
			
			//return ResponseEntity Object
			return new ResponseEntity<List<Actor>>(list, HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	@GetMapping("/employeesList")
	public ResponseEntity<?> fetchAllActors() {
		// use service

		List<Actor> list = actorService.getAllActors();

		// return ResponseEntity Object
		return new ResponseEntity<List<Actor>>(list, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchById(@PathVariable Integer id) {

		Actor actor = actorService.getActorById(id);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);

	}

	@GetMapping("/category/{category1}/{category2}")
	public ResponseEntity<?> fetchActorsByCategories(@PathVariable String category1, @PathVariable String category2) {

		List<Actor> actor = actorService.getActorsByCategory(category1, category2);
		return new ResponseEntity<List<Actor>>(actor, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<?> modifyingACtor(@RequestBody Actor actor) {

		String result = actorService.updateActor(actor);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable("id") Integer id) {

		// use Service
		String msg = actorService.deleteActorById(id);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@PatchMapping("/updatemobileNo/{id}/{newNo}")
	public ResponseEntity<String> updateMobileNo(@PathVariable Integer id, @PathVariable("newNo") Long number) {

		// use Service
		String msg = actorService.updateActorMobileNo(id, number);
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);

	}

}
