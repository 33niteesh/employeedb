package com.employeedb.jpa.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employeedb.jpa.repositories.ContactRepo;
import com.employeedb.jpa.entities.*;
import com.employeedb.jpa.repositories.*;
import com.employeedb.jpa.status.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Contact of Employee API")
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactRepo contactrepo;

    @Autowired
    public ContactController(ContactRepo contactrepo) {
        this.contactrepo = contactrepo;
    }
    
    @Operation(summary="get all contacts")
    @GetMapping
    public List<Contact> getAll() {
    		List<Contact> allcontacts = contactrepo.findAll();
    		return allcontacts;
    }
    
    @Operation(summary="get Specific Contact using ID")
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getById(@PathVariable Long id) {
        Contact singlecontact=contactrepo.findById(id).orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity.ok(singlecontact);
    }

    @Operation(summary="add one Contact")
    @PostMapping
    public ResponseEntity<Contact> createCnct(@RequestBody Contact contact) {
        Contact addcontact= contactrepo.save(contact);
        return new ResponseEntity(addcontact,HttpStatus.CREATED);
    }

    @Operation(summary="edit one Contact using ID")
    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact updateContact) {
        Contact existingAddress = contactrepo.findById(id).orElseThrow(() -> new NotFoundException(id));
        if (existingAddress != null) {
            Contact update=contactrepo.save(existingAddress);
            return new ResponseEntity(update,HttpStatus.ACCEPTED);
        }
        return null;
    }
    
    
    @Operation(summary="Delete Contact with ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
    	try{	
    		contactrepo.deleteById(id);
        	return new ResponseEntity<String>("Deleted employee",HttpStatus.OK);
    	}catch(Exception e){
        	return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    	}
    }
}