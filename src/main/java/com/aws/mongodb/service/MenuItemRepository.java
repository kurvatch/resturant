/**
 * 
 */
package com.aws.mongodb.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aws.mongodb.domain.MenuItem;

/**
 * @author c0kurch
 *
 */
public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
	
	public List<MenuItem> findByName(String menuName);

}
