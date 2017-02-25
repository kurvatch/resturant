/**
 * 
 */
package com.aws.mongodb.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.mongodb.domain.MenuItem;
import com.aws.mongodb.service.MenuItemRepository;

/**
 * @author c0kurch
 *
 */
@RestController
@RequestMapping("mongo")
public class MenuItemsController {
	
	Logger LOG = LoggerFactory.getLogger(MenuItemsController.class);
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@RequestMapping("menu/{name}")
	public List<MenuItem> getMenuByName(@PathVariable("name") String name) {
		return menuItemRepository.findByName(name); 
	}

	@RequestMapping("menu")
	public List<MenuItem> getMenuItems() {
		return menuItemRepository.findAll(); 
	}
	
	@PostMapping("menu")
	public ResponseEntity<String> addMenuItem(@RequestBody List<MenuItem> menuItemList){
		menuItemRepository.save(menuItemList);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@DeleteMapping("menu/{name}")
	public ResponseEntity<String> deleteMenuItem(@PathVariable("name") String name) {
		List<MenuItem> menuItems = menuItemRepository.findByName(name);
		LOG.info("MenuItems " + menuItems.get(0));
		if(!menuItems.isEmpty()) {
			menuItemRepository.delete(menuItems.get(0));
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		} 
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}
