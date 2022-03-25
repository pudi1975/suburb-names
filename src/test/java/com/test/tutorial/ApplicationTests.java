package com.test.tutorial;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pudi.tutorial.Application;
import com.pudi.tutorial.model.ResponseSuburbs;
import com.pudi.tutorial.repository.SuburbRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Autowired
	private SuburbRepository suburbRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetSuburbNames() {
		List<ResponseSuburbs> listofSuburbs = suburbRepository.findByPostalCode("2145-2150");
		Assert.assertNotNull(listofSuburbs);

	}

}
