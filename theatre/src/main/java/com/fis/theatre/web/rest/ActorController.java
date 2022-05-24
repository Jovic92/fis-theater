package com.fis.theatre.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.service.ActorService;
import com.fis.theatre.web.dto.ActorDTO;
import com.fis.theatre.web.dto.RoleActorDTO;

@RestController
@CrossOrigin
public class ActorController {

	@Autowired
	ActorService actorService;

	@RequestMapping(value = "/actor", method = RequestMethod.POST)
	public ResponseEntity<ActorDTO> insertActor(@RequestBody ActorDTO actor) {

		try {
			ActorDTO returnValue = actorService.insertActor(actor);
			return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/actor/saveRole", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> saveRoleActor(@RequestBody RoleActorDTO actor) {

		try {
			actorService.saveActorRole(actor);
			return new ResponseEntity<>(true, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/actor/getAll")
	public ResponseEntity<List<ActorDTO>> getActors() {
		try {
			List<ActorDTO> actors = actorService.findAll();
			return new ResponseEntity<>(actors, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
