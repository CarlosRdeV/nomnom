package com.carlosrdev.nom35.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carlosrdev.nom35.dao.RolRepository;
import com.carlosrdev.nom35.entity.Rol;

@RestController
@RequestMapping("/api")
public class RolRestController {

	// fields

	private RolRepository rolRepository;

	// constructor injection

	@Autowired
	public RolRestController(RolRepository theRolRepository) {
		rolRepository = theRolRepository;
	}

	////////////////////
	// TEST ENDPOINTS //
	////////////////////

	@GetMapping("/roles/test")
	public String test() {
		return "IT WORKS ROLES!!!";
	}

	@RequestMapping(value = "/foo", method = RequestMethod.OPTIONS)
	public ResponseEntity options(HttpServletResponse response) {
		// log.info("OPTIONS /foo called");
		response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS");
		return new ResponseEntity(HttpStatus.OK);
	}

	////////////////////
	// USER ENDPOINTS //
	////////////////////

	// add mapping for GET /users - return list of all users
	@GetMapping("/roles")
	public List<Rol> findAll() {

		return rolRepository.findAll();
	}

	// add mapping for GET /users/{userId} - return the user selected if exist
	@GetMapping("/roles/{rolId}")
	public Rol getRol(@PathVariable int rolId) {

		Optional<Rol> result = rolRepository.findById(rolId);

		Rol theRol = null;

		if (result.isPresent()) {
			theRol = result.get();
		} else {
			throw new RuntimeException("Did not find rol id - " + rolId);
		}

		return theRol;

	}

	// add mapping for POST /users - add new user
	@PostMapping("/roles")
	public Rol addRol(@RequestBody Rol theRol) {

		theRol.setId(0);

		rolRepository.save(theRol);

		return theRol;

	}

}
