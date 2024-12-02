package com.spring.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.rest.models.Hospital;
import com.spring.rest.service.HospitalService;

@RestController
@CrossOrigin(origins  = "*")
public class HospitalController {
	@Autowired HospitalService hospitalService;
	
	@PostMapping("/savedata")
	public Hospital saveData(@RequestBody Hospital hospital) {
		Hospital saveHospital = hospitalService.savedata(hospital);
		return saveHospital;
	}
	
	
	@PostMapping("/saveall")
	public List<Hospital> saveAll(@RequestBody List<Hospital> hospital) {
		List<Hospital> saveHospital =hospitalService.saveAll(hospital);
		return saveHospital;	
	}
	
	
	@GetMapping("/getall")
    public ResponseEntity<List<Hospital>> getAll(){
	   List<Hospital> emp =hospitalService.getAll();
		return ResponseEntity.status(HttpStatus.OK)
					  .header("status", "get the data")
					  .body(emp);
	}

	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		 Optional<Hospital> optionalEmp = hospitalService.getById(id);
		 if(optionalEmp.isPresent()) {
			 return ResponseEntity.status(HttpStatus.OK)
			 			   .body(optionalEmp);
		 }
		 else {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
		 			   .body("id not found by this "+id);
		 }
		
	}
	
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		 Optional<Hospital> optionalName = hospitalService.getByName(name);
		 if(optionalName.isPresent()) {
			 return ResponseEntity.status(HttpStatus.OK)
			 			   .body(optionalName);
		 }
		 else {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
		 			   .body("id not found by this "+name);
		 }
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		boolean status =hospitalService.deleteById(id);
		if(status) {
			return ResponseEntity.noContent().build();
			
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("status", "not found")
					             .body("data not found by this id.."+id);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Hospital hospital) {
		Optional<Hospital> option =hospitalService.updateById(id,hospital);
		if(option.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
						  .header("status", "data Updated")
						  .body(option);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .body("data not found");
		}
	}
	
	@PatchMapping("/updatepatch/{id}")
	public ResponseEntity<?> updateByIdPatch(@PathVariable Long id, Map<String, Object> updates){
		Optional<Hospital> option = hospitalService.updateByIdPatch(id,updates);
		if(option.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
						  .header("status", "data Updated")
						  .body(option);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .body("data not found");
		}
	}
	
	
	@GetMapping("/getnames")
	public List<String> getNames()
	{
		List<String> names = List.of("helo","bye");
		return names;
	}
	
	
	@GetMapping("/getnamescache")
	public List<String> getNamesCache()
	{
		return hospitalService.getNamesCache();
	}
	
}
