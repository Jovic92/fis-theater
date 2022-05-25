package com.fis.theatre.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.service.SceneService;
import com.fis.theatre.web.dto.SceneDTO;

@RestController
@CrossOrigin
public class SceneController {

	@Autowired
	SceneService sceneService;
	
	@RequestMapping("/scenes/all")
	public ResponseEntity<List<SceneDTO>> getAll(){
		try {
			List<SceneDTO> scenes = sceneService.getAll();
			return new ResponseEntity<>(scenes, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
