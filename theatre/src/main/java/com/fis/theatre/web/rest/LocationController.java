package com.fis.theatre.web.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.model.Location;
import com.fis.theatre.service.LocationService;
import com.fis.theatre.web.dto.LocationDTO;

@RestController
@CrossOrigin
public class LocationController {

	@Autowired
	LocationService locationService;

	@RequestMapping("/location/{dateOfTheShow}/{nameOfTheShow}")
	public ResponseEntity<List<LocationDTO>> getFreeSeats(@PathVariable String dateOfTheShow,
			@PathVariable String nameOfTheShow) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dateOfTheShow);

			List<LocationDTO> locations = locationService.getFreeSeats(date, nameOfTheShow);
			return new ResponseEntity<>(locations, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
