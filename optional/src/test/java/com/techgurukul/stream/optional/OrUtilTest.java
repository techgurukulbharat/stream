package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class OrUtilTest {

	@Test
	void test_getDefualt_StudentData() {

		Optional<Student> student = OrUtil.getStudent(null);
		assertTrue(student.get().getName().equals("defaultName"));
		assertTrue(student.get().getEmail().equals("defualtEmail@email.com"));
		assertTrue(student.get().getRollNumber().equals(001));

	}

	@Test
	void test_get_StudentData() {
		Student student = new Student("name", 123, "email@email.com");
		Optional<Student> studentOptional = OrUtil.getStudent(student);
		assertTrue(studentOptional.get().getName().equals(student.getName()));
		assertTrue(studentOptional.get().getEmail().equals(student.getEmail()));
		assertTrue(studentOptional.get().getRollNumber().equals(student.getRollNumber()));
	}
}
