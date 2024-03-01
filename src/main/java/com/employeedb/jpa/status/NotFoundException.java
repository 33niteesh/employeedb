package com.employeedb.jpa.status;

public class NotFoundException extends RuntimeException{
	private Long Id;
	public NotFoundException(Long Id) {
		super("Employee not found");
		this.Id=Id;
	}
	public Long getId() {
		return Id;
	}
}
