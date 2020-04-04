package com.lawencon.tiketSpringBoot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.tiketSpringBoot.model.Customer;
import com.lawencon.tiketSpringBoot.model.Ticket;
import com.lawencon.tiketSpringBoot.service.CustomerService;
import com.lawencon.tiketSpringBoot.service.TicketService;

@RestController
public class TiketController extends BaseController {

	/*
	 * Nama : Serenada Salma Shafira
	 */
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private TicketService ticketService;
	
	/*** CRUD CUSTOMER ***/
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(@RequestHeader("Authorization") String uname) {
		List<Customer> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = custService.findAll(auth[0],auth[1]);
			return new ResponseEntity<>(listData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/customer/persist")
	public ResponseEntity<List<Customer>> persistCustomer(@RequestBody Customer cus) {
		try {
			custService.insert(cus);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/customer/merge")
	public ResponseEntity<List<Customer>> mergeCustomer(@RequestBody Customer cus, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			custService.update(cus,auth[0],auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/delete")
	public ResponseEntity<List<Customer>> deleteCustomer(@RequestBody Customer cus, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			custService.delete(cus,auth[0],auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*** CRUD TIKET ***/
	@PostMapping("/tiket/insert")
	public void getWithBody(@RequestBody String content, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			List<Ticket> m = Arrays.asList(new ObjectMapper().readValue(content, Ticket[].class));
			m.forEach(tiket -> ticketService.insert(tiket,auth[0],auth[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
