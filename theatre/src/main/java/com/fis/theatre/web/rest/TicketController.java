package com.fis.theatre.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fis.theatre.service.TicketService;
import com.fis.theatre.web.dto.TicketDTO;

@RestController
@CrossOrigin
public class TicketController {

	@Autowired
	TicketService ticketService;

	@RequestMapping(value = "/ticket/buy", method = RequestMethod.POST)
	public TicketDTO buyATicket(@RequestBody TicketDTO ticket) {
		return ticketService.saveTicket(ticket);
	}
}
