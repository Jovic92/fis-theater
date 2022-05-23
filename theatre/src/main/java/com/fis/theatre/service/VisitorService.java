package com.fis.theatre.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fis.theatre.model.Visitor;
import com.fis.theatre.repository.VisitorRepository;
import com.fis.theatre.web.dto.VisitorDTO;

@Service
public class VisitorService {

	@Autowired
	VisitorRepository visitorRepo;

//	public Visitor insertVisitor(Visitor v) {
//		Visitor returnVisitor = visitorRepo.save(v);
//		return returnVisitor;
////		or simply
////		return visitorRepo.save(v);;
//	}

	public VisitorDTO insertVisitor(VisitorDTO v) {

		Visitor visitor = new Visitor();
		visitor.setFirstname(v.getFirstname());
		visitor.setLastname(v.getLastname());

		Visitor returnVisitor = visitorRepo.save(visitor);

		VisitorDTO newDTOVisitor = new VisitorDTO();
		newDTOVisitor.setFirstname(returnVisitor.getFirstname());
		newDTOVisitor.setLastname(returnVisitor.getLastname());
		newDTOVisitor.setVisitorId(returnVisitor.getIdVisitor());

		return newDTOVisitor;
//		or simply
//		return visitorRepo.save(v);;
	}

//	public List<Visitor> getAll() {
//		return visitorRepo.findAll();
//	}
	
	public List<VisitorDTO> getAll() {
		List<Visitor> visitors = visitorRepo.findAll();
		List<VisitorDTO> visitorDTOs = new ArrayList<VisitorDTO>();
		for(Visitor v : visitors) {
			VisitorDTO vDTO = new VisitorDTO();
			vDTO.setFirstname(v.getFirstname());
			vDTO.setLastname(v.getLastname());
			vDTO.setVisitorId(v.getIdVisitor());
			visitorDTOs.add(vDTO);
		}
		return visitorDTOs;
	}
	
	// get a Visitor byID
		// get a Visitor byFirstORLastName
		//	List<Visitor> findByFirstnameOrLastname(String firstname, String lastname); 
		//update a Visitor send id

//	visitorRepo.findById(1);
//	visitorRepo.findByFirstnameOrLastname("", "");
//	visitorRepo.save(null);//if we have an ID of the object else if id is null it insert new

	public VisitorDTO findById(int idVisitor) {
		Visitor v = visitorRepo.getById(idVisitor);//findById(idVisitor).get();
		VisitorDTO vDTO = new VisitorDTO();
		vDTO.setFirstname(v.getFirstname());
		vDTO.setLastname(v.getLastname());
		vDTO.setVisitorId(v.getIdVisitor());
		return vDTO;
	}
	
	public List<VisitorDTO> findByFirstnameOrLastname(String firstname, String lastname) {
		List<Visitor> visitors = visitorRepo.findByFirstnameOrLastname(firstname, lastname);
		List<VisitorDTO> visitorDTOs = new ArrayList<VisitorDTO>();
		for(Visitor v : visitors) {
			VisitorDTO vDTO = new VisitorDTO();
			vDTO.setFirstname(v.getFirstname());
			vDTO.setLastname(v.getLastname());
			vDTO.setVisitorId(v.getIdVisitor());
			visitorDTOs.add(vDTO);
		}
		return visitorDTOs;
	}
	
	public VisitorDTO updateVisitor(VisitorDTO v) {

		Visitor visitor = visitorRepo.getById(v.getVisitorId());
		visitor.setFirstname(v.getFirstname());
		visitor.setLastname(v.getLastname());

		Visitor returnVisitor = visitorRepo.save(visitor);

		VisitorDTO newDTOVisitor = new VisitorDTO();
		newDTOVisitor.setFirstname(returnVisitor.getFirstname());
		newDTOVisitor.setLastname(returnVisitor.getLastname());
		newDTOVisitor.setVisitorId(returnVisitor.getIdVisitor());

		return newDTOVisitor;
	}
	
	
	public void deleteVisitor(int id) {
		visitorRepo.deleteById(id);
	}
	
	
	
	
}
