package com.spring.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private String name; 
	private String location;
	private String specialization; 
	private String rating;

}
