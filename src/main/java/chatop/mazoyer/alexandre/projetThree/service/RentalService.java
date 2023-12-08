package chatop.mazoyer.alexandre.projetThree.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import chatop.mazoyer.alexandre.projetThree.DTO.RentalDto;
import chatop.mazoyer.alexandre.projetThree.convert.RentalsConvert;
import chatop.mazoyer.alexandre.projetThree.models.Rental;
import chatop.mazoyer.alexandre.projetThree.models.User;
import chatop.mazoyer.alexandre.projetThree.repository.RentalRepository;
import chatop.mazoyer.alexandre.projetThree.repository.UserRepository;
import chatop.mazoyer.alexandre.projetThree.request.RentalRequest;
import chatop.mazoyer.alexandre.projetThree.response.MessageResponse;
import chatop.mazoyer.alexandre.projetThree.response.RentalResponse;

@Service
public class RentalService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FilesStorageService storageService;

	@Autowired
	RentalRepository rentalRepository;

	@Autowired
	RentalsConvert convert;

	public ResponseEntity<MessageResponse> createRental(MultipartFile files, RentalRequest rentalRequest, User user) {

		Rental rental = new Rental();
		Date date = new Date();

		rental.setName(rentalRequest.getName());
		rental.setDescription(rentalRequest.getDescription());
		rental.setSurface(rentalRequest.getSurface());
		rental.setPrice(rentalRequest.getPrice());
		rental.setPicture(storageService.save(files));
		rental.setCreated_at(date);
		rental.setOwner(user);
		rentalRepository.save(rental);

		return new ResponseEntity<>(new MessageResponse("Rental created !"), HttpStatus.ACCEPTED);
	}

	public RentalResponse getRental() {

		List<Rental> rentals = rentalRepository.findAll();
		List<RentalDto> rentalDtos = convert.entityToDto(rentals);
		return new RentalResponse(rentalDtos);

	}

	public RentalDto getRentalId(Long id) {
		Rental rental = rentalRepository.getById(id);
		return convert.entityToDto(rental);
	}

	public ResponseEntity<MessageResponse> updateRental(RentalRequest rentalRequest, Long id) {

		Rental rental = rentalRepository.getById(id);
		Date date = new Date();

		rental.setName(rentalRequest.getName());
		rental.setDescription(rentalRequest.getDescription());
		rental.setSurface(rentalRequest.getSurface());
		rental.setPrice(rentalRequest.getPrice());
		rental.setUpdated_at(date);

		rentalRepository.save(rental);

		return new ResponseEntity<>(new MessageResponse("Rental updated !"), HttpStatus.ACCEPTED);
	}

}
