package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OrElseGetUtilTest {

	@Test
	void test_toStudentDtoBeforeJava8() {
		// with null student reference
		StudentDTO nullStudentDTO = OrElseGetUtil.toStudentDtoBeforeJava8(null);
		assertNull(nullStudentDTO);

		// with non null student reference
		Student student = new Student("test", null, null);
		StudentDTO studentDTO = OrElseGetUtil.toStudentDtoBeforeJava8(student);
		assertTrue(studentDTO.getName().equals("test"));
		assertTrue(studentDTO.getEmail().equals("test@test.com"));
		assertNotNull(studentDTO.getRollNumber());
	}

	@Test
	void test_toStudentDtoSinceJava8() {
		// with null student reference
		Optional<StudentDTO> nullStudentDTO = OrElseGetUtil.toStudentDtoSinceJava8(null);
		assertTrue(nullStudentDTO.isEmpty());

		// with non null student reference
		Student student = new Student("test", null, null);
		Optional<StudentDTO> studentDtoOptinal = OrElseGetUtil.toStudentDtoSinceJava8(student);
		if (studentDtoOptinal.isPresent()) { // force null check
			StudentDTO studentDTO = studentDtoOptinal.get();

			assertTrue(studentDTO.getName().equals("test"));
			assertTrue(studentDTO.getEmail().equals("test@test.com"));
			assertNotNull(studentDTO.getRollNumber());
		}

	}

}
