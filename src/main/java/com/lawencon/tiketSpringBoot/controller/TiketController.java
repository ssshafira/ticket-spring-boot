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
import com.lawencon.tiketSpringBoot.model.Discount;
import com.lawencon.tiketSpringBoot.model.Ticket;
import com.lawencon.tiketSpringBoot.model.Transaction;
import com.lawencon.tiketSpringBoot.model.Type;
import com.lawencon.tiketSpringBoot.service.CustomerService;
import com.lawencon.tiketSpringBoot.service.DiscountService;
import com.lawencon.tiketSpringBoot.service.TicketService;
import com.lawencon.tiketSpringBoot.service.TransactionService;
import com.lawencon.tiketSpringBoot.service.TypeService;

@RestController
public class TiketController extends BaseController {

	/*
	 * Nama : Serenada Salma Shafira
	 */

	@Autowired
	private CustomerService custService;

	@Autowired
	private DiscountService discountService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private TransactionService trxService;

	@Autowired
	private TicketService ticketService;

	/*** CRUD CUSTOMER ***/
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomer(@RequestHeader("Authorization") String uname) {
		List<Customer> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = custService.findAll(auth[0], auth[1]);
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
	public ResponseEntity<List<Customer>> mergeCustomer(@RequestBody Customer cus,
			@RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			custService.update(cus, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/customer/delete")
	public ResponseEntity<List<Customer>> deleteCustomer(@RequestBody Customer cus,
			@RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			custService.delete(cus, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*** CRUD DISKON ***/
	@GetMapping("/discount")
	public ResponseEntity<List<Discount>> getAllDiscount(@RequestHeader("Authorization") String uname) {
		List<Discount> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = discountService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/discount/insert")
	public ResponseEntity<?> insertDiscount(@RequestBody Discount disc, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			return discountService.insert(disc, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/discount/update")
	public ResponseEntity<List<Discount>> updateDiscount(@RequestBody Discount disc,
			@RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			discountService.update(disc, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/discount/delete")
	public ResponseEntity<List<Customer>> deleteDiscount(@RequestBody Discount disc,
			@RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			discountService.delete(disc, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*** CRUD TIPE ***/
	@GetMapping("/type")
	public ResponseEntity<List<Type>> getAllType(@RequestHeader("Authorization") String uname) {
		List<Type> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = typeService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/type/insert")
	public ResponseEntity<?> insertType(@RequestBody Type type, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			return typeService.insert(type, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/type/update")
	public ResponseEntity<List<Type>> updateType(@RequestBody Type type, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			typeService.update(type, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/type/delete")
	public ResponseEntity<List<Type>> deleteType(@RequestBody Type type, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			typeService.delete(type, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*** CRUD TRANSAKSI ***/
	@GetMapping("/transaction")
	public ResponseEntity<List<Transaction>> getAllTransaction(@RequestHeader("Authorization") String uname) {
		List<Transaction> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = trxService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/transaction/insert")
	public ResponseEntity<?> insertTrx(@RequestBody String content, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			Transaction t = new ObjectMapper().readValue(content, Transaction.class);
			trxService.insert(t, auth[0], auth[1]);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/transaction/delete")
	public ResponseEntity<List<Ticket>> deleteTrx(@RequestBody Transaction trx,
			@RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			trxService.delete(trx, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*** CRUD TIKET ***/
	@GetMapping("/ticket")
	public ResponseEntity<List<Ticket>> getAllTicket(@RequestHeader("Authorization") String uname) {
		List<Ticket> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = ticketService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/ticket/insert")
	public ResponseEntity<?> getWithBody(@RequestBody String content, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			List<Ticket> m = Arrays.asList(new ObjectMapper().readValue(content, Ticket[].class));
			m.forEach(tiket -> {
				ticketService.insert(tiket, auth[0], auth[1]);
			});
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/ticket/delete")
	public ResponseEntity<List<Ticket>> deleteTicket(@RequestBody Ticket tiket,
			@RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			ticketService.delete(tiket, auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
