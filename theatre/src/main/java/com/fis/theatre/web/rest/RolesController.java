package com.fis.theatre.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.service.RoleService;
import com.fis.theatre.web.dto.RoleDTO;

@RestController
@CrossOrigin
public class RolesController {

	@Autowired
	RoleService roleService;

	@RequestMapping("/role/{showName}")
	public ResponseEntity<List<RoleDTO>> getRolesForShow(@PathVariable String showName) {
		List<RoleDTO> roles = roleService.getRolesOfAShow(showName);
		try {
			return new ResponseEntity<>(roles, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
