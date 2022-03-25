package com.pudi.tutorial.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pudi.tutorial.model.RequestSuburbs;
import com.pudi.tutorial.model.ResponseSuburbs;
/**
 * The JdbcSuburbRepository  repository.
 *
 * @author Madhu Pudi
 */
@Repository
public class JdbcSuburbRepository implements SuburbRepository {
	private static final Logger logger = LoggerFactory.getLogger(JdbcSuburbRepository.class);
	@Autowired
	  private JdbcTemplate jdbcTemplate;
/**
 * Descriptions : This method is used to store SuburbNames and Postal Codes in the database.
 */
	  @Override
	  public int save(RequestSuburbs requestSuburbs) {
	    return jdbcTemplate.update("INSERT INTO suburbs (suburbName, postalCode) VALUES(?,?)",
	        new Object[] { requestSuburbs.getSuburbName(), requestSuburbs.getPostalCode()});
	  }
	  /**
	   * Descriptions : This method is used to  get  SuburbNames and Postal Codes in the database.
	   */
	  @Override
	  public List<ResponseSuburbs> findByPostalCode(String postalcode) {
		  String replacedString = getQueryString(postalcode);
		  StringBuilder queryBuilder = new StringBuilder();
	    String query = "SELECT suburbName from suburbs WHERE postalCode IN(";
	    String finaQuery = queryBuilder.append(query).append(replacedString).append(")").toString();
	    logger.info("Final Query ::"+ finaQuery);
	    return jdbcTemplate.query(finaQuery, BeanPropertyRowMapper.newInstance(ResponseSuburbs.class));
	  }
/**
 * 
 * @param queryValue
 * @return String value
 */
	  public String getQueryString(String queryValue) {
			StringBuilder builder = new StringBuilder();
			if (queryValue.contains("-")) {
				String output[] = queryValue.split("-");
				for (String l : output) {
					builder.append(l).append(",");
				}
			} else {
				builder.append(queryValue);
			}
			String newQuery = builder.toString().trim();
			if (newQuery.endsWith(",")) {
				newQuery = newQuery.substring(0, newQuery.length() - 1);
			}
			return newQuery.toString();

		}

}
