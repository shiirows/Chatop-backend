package chatop.mazoyer.alexandre.projetThree.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import chatop.mazoyer.alexandre.projetThree.models.Message;
import chatop.mazoyer.alexandre.projetThree.models.Rental;
import chatop.mazoyer.alexandre.projetThree.models.User;
import chatop.mazoyer.alexandre.projetThree.repository.MessageRepository;
import chatop.mazoyer.alexandre.projetThree.repository.RentalRepository;
import chatop.mazoyer.alexandre.projetThree.repository.UserRepository;
import chatop.mazoyer.alexandre.projetThree.request.MessageRequest;
import chatop.mazoyer.alexandre.projetThree.response.MessageResponse;


@Service
public class MessageService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RentalRepository rentalRepository;

	@Autowired
	MessageRepository messageRepository;

	public ResponseEntity<MessageResponse> createMessage(MessageRequest messageRequest) {

		Rental rental = rentalRepository.getById(messageRequest.getRental_id());
        User user = userRepository.getById(messageRequest.getUser_id());
		Message message = new Message();
		Date date = new Date();

		message.setMessage(messageRequest.getMessage());
		message.setUser(user);
		message.setRental(rental);
		message.setCreatedAt(date);

		messageRepository.save(message);

		return new ResponseEntity<>(new MessageResponse("Message send with success"), HttpStatus.ACCEPTED);
	}

}
