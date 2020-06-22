package com.techgurukul.stream.optional;

import java.util.Optional;

public class Teacher {

	private String name;
	private String department;

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getDepartment() {
		return Optional.ofNullable(department);
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Teacher(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}

	public Teacher() {
		super();
	}

}
