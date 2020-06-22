package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OrElseUtilTest {

	@Test
	void test_toStudentDtoBeforeJava8() {
		// with null student reference
		StudentDTO nullStudentDTO = OrElseUtil.toStudentDtoBeforeJava8(null);
		assertNull(nullStudentDTO);

		// with non null student reference
		Student student = new Student("test", null, null);
		StudentDTO studentDTO = OrElseUtil.toStudentDtoBeforeJava8(student);
		assertTrue(studentDTO.getName().equals("test"));
		assertTrue(studentDTO.getEmail().equals("test@test.com"));
		assertNotNull(studentDTO.getRollNumber());
	}

	@Test
	void test_toStudentDtoSinceJava8() {
		// with null student reference
		Optional<StudentDTO> nullStudentDTO = OrElseUtil.toStudentDtoSinceJava8(null);
		assertTrue(nullStudentDTO.isEmpty());

		// with non null student reference
		Student student = new Student("test", null, null);
		Optional<StudentDTO> studentDtoOptinal = OrElseUtil.toStudentDtoSinceJava8(student);
		if (studentDtoOptinal.isPresent()) { // force null check
			StudentDTO studentDTO = studentDtoOptinal.get();

			assertTrue(studentDTO.getName().equals("test"));
			assertTrue(studentDTO.getEmail().equals("test@test.com"));
			assertNotNull(studentDTO.getRollNumber());
		}

	}

}
