  package com.spring.rest.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.spring.rest.models.Hospital;
import com.spring.rest.repository.HospitalRepository;

@Service
public class HospitalService {
	@Autowired HospitalRepository hospitalRepository;

	public Hospital savedata(Hospital hospital) {
		Hospital saveHospital= hospitalRepository.save(hospital);
		return saveHospital;
		
	}

	public List<Hospital> saveAll(List<Hospital> hospital) {
		 List<Hospital> saveall  = hospitalRepository.saveAll(hospital);
		return saveall;
	}

	public List<Hospital> getAll() {
		List<Hospital> getAll = hospitalRepository.findAll();
		return getAll;
		
	}

	public Optional<Hospital> getById(Long id) {
		Optional<Hospital> getById = hospitalRepository.findById(id);
		return getById;
	}

	public Optional<Hospital> getByName(String name) {
		Optional<Hospital> getName = hospitalRepository.findByName(name);
		return getName;
	}

	public boolean deleteById(Long id) {
		boolean status = hospitalRepository.existsById(id);
		if (status) {
			hospitalRepository.deleteById(id);
			return true;
		} else {
			return false;
		}

	}
	
	public Optional<Hospital> updateById(Long id, Hospital hospital) {
		Optional<Hospital> option = hospitalRepository.findById(id);
		if(option.isPresent()) {
			Hospital existing = option.get();
			existing.setName(hospital.getName());
			existing.setLocation(hospital.getLocation());
			existing.setRating(hospital.getRating());
			existing.setSpecialization(hospital.getSpecialization());
	       
			Hospital updated = hospitalRepository.save(existing);
			return Optional.of(updated);
		    }
		else {
			 return Optional.empty();
		     }
		}

	public Optional<Hospital> updateByIdPatch(Long id, Map<String, Object> updates) {
	    Optional<Hospital> optionalEmp = hospitalRepository.findById(id);
	    if (optionalEmp.isPresent()) {
	        Hospital existingEmp = optionalEmp.get();
	        updates.forEach((key, value) -> {
	            switch (key) {
	                case "name":
	                    existingEmp.setName((String) value);
	                    break;
	                case "location":
	                    existingEmp.setLocation((String) value);
	                    break;
	                case "specialization":
	                    existingEmp.setSpecialization((String) value);
	                    break;
	                case "rating":
	                    existingEmp.setRating((String) value);
	                    break;
	            }
	        });
	        Hospital updatedEmp = hospitalRepository.save(existingEmp);
	        return Optional.of(updatedEmp);
	    } else {
	        return Optional.empty();
	    }
	}

	
	@Cacheable("names")
	public List<String> getNamesCache()
	{
		List<String> names = List.of("helo","bye");
		System.out.println("String list of names");
		return names;
		
	}
	
}
	
	


