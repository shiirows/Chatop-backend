package chatop.mazoyer.alexandre.projetThree.models;


import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "RENTALS")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @NotNull
    private String name;
    
    @NotBlank(message = "La surface est obligatoire")
    @NotNull
    private Double surface;
    
    @NotBlank(message = "Le prix est obligatoire")
    @NotNull
    private Double price;
    
    @NotBlank(message = "L'image est obligatoire")
    @NotNull
    private String picture;
    
    @NotBlank(message = "La descritpion est obligatoire")
    @Size(max = 5000)
    @NotNull
    private String description;
    
    
    private Date created_at;
    private Date updated_at;
    
    

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

  


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSurface() {
		return surface;
	}

	public void setSurface(Double surface) {
		this.surface = surface;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

    // Getters and setters

}
