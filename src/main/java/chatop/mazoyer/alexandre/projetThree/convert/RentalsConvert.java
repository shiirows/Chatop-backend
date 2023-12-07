package chatop.mazoyer.alexandre.projetThree.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import chatop.mazoyer.alexandre.projetThree.DTO.RentalDto;
import chatop.mazoyer.alexandre.projetThree.models.Rental;


@Component
public class RentalsConvert {

	public RentalDto entityToDto(Rental rental) {

		RentalDto dto = new RentalDto();

		String url = "http://localhost:3001/api/file/filename/";

		dto.setId(rental.getId());
		dto.setName(rental.getName());
		dto.setSurface(rental.getSurface());
		dto.setDescription(rental.getDescription());
		dto.setOwner_id(rental.getOwner().getId());
		dto.setCreated_at(rental.getCreated_at());
		dto.setUpdated_at(rental.getUpdated_at());
		dto.setPicture(url + rental.getPicture());
		dto.setPrice(rental.getPrice());

		return dto;
	}

	public List<RentalDto> entityToDto(List<Rental> rentalDto) {

		return rentalDto.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

}
