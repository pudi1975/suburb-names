package com.pudi.tutorial.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pudi.tutorial.exception.ResourceNotFoundException;
import com.pudi.tutorial.model.RequestSuburbs;
import com.pudi.tutorial.model.ResponseSuburbs;
import com.pudi.tutorial.repository.SuburbRepository;

/**
 * The type SuburbNames controller.
 *
 * @author Madhu Pudi
 */
@RestController
@RequestMapping("/api/v1")
@Validated
public class SuburbNamesController {

	private static final Logger logger = LoggerFactory.getLogger(SuburbNamesController.class);

	@Autowired
	private SuburbRepository suburbRepository;

	/**
	 * Gets suburb names by giving postal code range example .
	 *
	 * @param postal
	 *            code the postal code
	 * @return Suburb json object
	 * @throws ResourceNotFoundException
	 *             the resource not found exception
	 */
	@GetMapping({ "/suburbName/{postalcode}", "" })
	public ResponseEntity<List<ResponseSuburbs>> getSuburbsByPostalCode(
			@PathVariable(name = "postalcode") String postalcode) throws ResourceNotFoundException {
		try {
			if(null != postalcode) {
			List<ResponseSuburbs> requestSuburbs = new ArrayList<ResponseSuburbs>();
			logger.info("postalcode:" + postalcode);
			requestSuburbs = suburbRepository.findByPostalCode(postalcode);
			List<ResponseSuburbs> sortedList = requestSuburbs.stream()
					.sorted(Comparator.comparing(ResponseSuburbs::getSuburbName)).collect(Collectors.toList());
			logger.info("listof Suburbs:" + sortedList);
			if (sortedList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(sortedList, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Create suburbs, postal code.
	 *
	 * @param RequestSuburbs
	 *            the Suburb
	 * @return
	 */
	@PostMapping("/suburbs")
	public ResponseEntity<String> createSuburbs(@Valid @RequestBody List<RequestSuburbs> requestSuburbs) {
		try {
			if(requestSuburbs.size() > 0) {
			requestSuburbs.forEach(
					name -> suburbRepository.save(new RequestSuburbs(name.getSuburbName(), name.getPostalCode())));
			return new ResponseEntity<>("Suburbs was created successfully.", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("The Request Body should not be empty", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
