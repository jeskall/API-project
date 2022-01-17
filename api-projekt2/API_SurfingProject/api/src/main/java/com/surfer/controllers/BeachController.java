package com.surfer.controllers;

import java.util.Collection;

import com.surfer.Entities.Beach;
import com.surfer.request.AddBeachRequest;
import com.surfer.request.UpdateBeachRequest;
import com.surfer.services.BeachService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api/beaches")
public class BeachController {
	@Autowired
	private BeachService beachService;

	@GetMapping("/")
	@ApiOperation(value = "get all Beaches", notes = "fetches all beaches in API", response = Beach.class, responseContainer = "LIST")
	public Collection<Beach> getAll() {
		return beachService.getAll();
	}

	@GetMapping("/{id}")

	public Beach getByID(@ApiParam(value = "id of the Beach", required = true) @PathVariable Long id) {
		var response = beachService.getByID(id);
		if (response == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "couldnt find any beach with provided ID");

		}
		return response;
	}

	@GetMapping("/name/{beachName}")
	public Collection<Beach> getByBeachName(@PathVariable String beachName) {
		return beachService.getByBeachName(beachName);
	}

	@GetMapping("/location/{beachLocation}")
	public Collection<Beach> getByBeachLocation(@PathVariable String beachLocation) {
		return beachService.getByBeachLocation(beachLocation);
	}

	@PostMapping("/")
	public Beach addNewBeach(@Validated @RequestBody AddBeachRequest request) {

		return beachService.addBeach(request);
	}

	@PutMapping("/{id}")
	public Beach updateBeach(@PathVariable Long id, @RequestBody UpdateBeachRequest request) {
		return beachService.updateBeach(id, request);

	}
}
