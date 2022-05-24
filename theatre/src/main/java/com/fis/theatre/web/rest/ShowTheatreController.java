package com.fis.theatre.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.service.ShowTheatreService;
import com.fis.theatre.web.dto.ShowDTO;

@RestController
@CrossOrigin
public class ShowTheatreController {

	@Autowired
	ShowTheatreService showService;

	@RequestMapping(value = "/show/insert", method = RequestMethod.POST)
	public ResponseEntity<ShowDTO> save(@RequestBody ShowDTO showDTO) {

		try {
			showService.save(showDTO);
			return new ResponseEntity<>(showDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/show/getAllShowsForActor/{firstname}/{lastname}")
	public List<ShowDTO> getAllShowsForActor(@PathVariable String firstname, @PathVariable String lastname) {
		return showService.getAllShowsForAnActor(firstname, lastname);
	}

	@RequestMapping("/show/getAllShowsForActor")
	public List<ShowDTO> getAllShowsForActor2(@RequestParam(defaultValue = "") String firstname,
			@RequestParam(defaultValue = "") String lastname) {
		return showService.getAllShowsForAnActor(firstname, lastname);
	}

	@RequestMapping("/show/getAll")
	public ResponseEntity<List<ShowDTO>> getAll() {
		try {
			List<ShowDTO> shows = showService.getAll();
			return new ResponseEntity<>(shows, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/show/genre/{genreId}")
	public ResponseEntity<List<ShowDTO>> getShowsByGenre(@PathVariable int genreId) {
		try {
			List<ShowDTO> shows = showService.getAllShowsForGenre(genreId);
			return new ResponseEntity<>(shows, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/show/director/{directorId}")
	public ResponseEntity<List<ShowDTO>> getShowsByDirector(@PathVariable int directorId) {
		try {
			List<ShowDTO> shows = showService.getAllShowsForDirector(directorId);
			return new ResponseEntity<>(shows, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
