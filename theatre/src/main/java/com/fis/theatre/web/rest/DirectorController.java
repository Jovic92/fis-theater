package com.fis.theatre.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.service.DirectorService;
import com.fis.theatre.web.dto.DirectorDTO;

@RestController
@CrossOrigin
public class DirectorController {

	@Autowired
	DirectorService directorService;
	
	
	@RequestMapping("/directors/all")
	public ResponseEntity<List<DirectorDTO>> getAll(){
		try {
			List<DirectorDTO> diretors = directorService.getAll();
			return new ResponseEntity<>(diretors, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
