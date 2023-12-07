package chatop.mazoyer.alexandre.projetThree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import chatop.mazoyer.alexandre.projetThree.request.RentalRequest;
import chatop.mazoyer.alexandre.projetThree.security.WebSecurityConfig;
import chatop.mazoyer.alexandre.projetThree.service.RentalService;


@RestController
@CrossOrigin
@RequestMapping("/api/rentals")
public class RentalController {

	@Autowired
	RentalService rentalService;
	
	@Autowired
	WebSecurityConfig config;

	@PostMapping("")
	public ResponseEntity<?> createRental(@RequestParam("picture") MultipartFile files, RentalRequest rentalRequest) {

		try {
			return new ResponseEntity<>(rentalService.createRental(files, rentalRequest,config.authentification()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@GetMapping("")
	public ResponseEntity<?> getRental() {

		try {

			return new ResponseEntity<>(rentalService.getRental(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRentalId(@PathVariable Long id) {

		try {

			return new ResponseEntity<>(rentalService.getRentalId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateRental(@PathVariable Long id, RentalRequest rentalRequest) {

		try {
			
			config.authentification();
			return new ResponseEntity<>(rentalService.updateRental(rentalRequest, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

}
