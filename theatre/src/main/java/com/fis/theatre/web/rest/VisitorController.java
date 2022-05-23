package com.fis.theatre.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.model.Visitor;
import com.fis.theatre.service.VisitorService;
import com.fis.theatre.web.dto.VisitorDTO;

@RestController
@CrossOrigin
public class VisitorController {

	@Autowired
	VisitorService visitorService;
	
//	@RequestMapping(value = "/visitor/save", method = RequestMethod.POST)
//	public Visitor saveVisitor(@RequestBody Visitor v) {
//		Visitor newVisitor =  visitorService.insertVisitor(v);
//		return newVisitor;
//		
////		return visitorService.insertVisitor(v);
//	}
	
	
	@RequestMapping(value = "/visitor/save", method = RequestMethod.POST)
	public VisitorDTO saveVisitor(@RequestBody VisitorDTO v) {
		VisitorDTO newVisitor =  visitorService.insertVisitor(v);
		return newVisitor;
		
//		return visitorService.insertVisitor(v);
	}
	
//	@RequestMapping("/visitors/getAll")
//	public List<Visitor> getAll(){
//		return visitorService.getAll();
//	}
	
	
	@RequestMapping("/visitors/getAll")
	public List<VisitorDTO> getAll(){
		return visitorService.getAll();
	}
	
	// get a Visitor byID
	// get a Visitor byFirstORLastName
	//	List<Visitor> findByFirstnameOrLastname(String firstname, String lastname); 
	//update a Visitor send id
	
	@RequestMapping("/visitors/get/{id}")
	public VisitorDTO findById(@PathVariable int id){
		return visitorService.findById(id);
	}
	
	@RequestMapping("/visitors/get/{firstname}/{lastname}")
	public List<VisitorDTO> findByFirstOrLastName(@PathVariable String firstname, @PathVariable String lastname){
		return visitorService.findByFirstnameOrLastname(firstname,lastname);
	}
	
	@RequestMapping(value = "/visitor/save", method = RequestMethod.PUT)
	public VisitorDTO updateVisitor(@RequestBody VisitorDTO v) {
		VisitorDTO newVisitor =  visitorService.updateVisitor(v);
		return newVisitor;
	}
	
}
