package com.pudi.tutorial.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pudi.tutorial.model.RequestSuburbs;
import com.pudi.tutorial.model.ResponseSuburbs;

/**
 * The interface Suburb repository.
 *
 * @author Madhu Pudi
 */
@Repository
public interface SuburbRepository {

	int save(RequestSuburbs requestSuburbs);

	List<ResponseSuburbs> findByPostalCode(String postalCode);
}
