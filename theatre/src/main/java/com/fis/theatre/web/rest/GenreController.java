package com.fis.theatre.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.service.GenreService;
import com.fis.theatre.web.dto.GenreDTO;

@RestController
@CrossOrigin
public class GenreController {

	@Autowired
	GenreService genreService;

	@RequestMapping("/genre/all")
	public ResponseEntity<List<GenreDTO>> getAll() {
		try {
			List<GenreDTO> genres = genreService.findAll();
			return new ResponseEntity<>(genres, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
