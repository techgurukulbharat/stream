package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class IfPresentOrElseUtilTest {

	@Test
	void test_convertStudentToStudentDto_beforeJava8() {

		// with null student reference
		StudentDTO nullStudentDTO = IfPresentUtil.toStudentDtoBeforeJava8(null);
		assertNull(nullStudentDTO);

		// with non null student reference
		Student student = new Student(null, 123, null);
		StudentDTO studentDTO = IfPresentUtil.toStudentDtoBeforeJava8(student);
		assertTrue(studentDTO.getRollNumber().equals(student.getRollNumber()));
	}

	@Test
	void test_convertStudentToStudentDto_sinceJava8() {

		// with null student reference
		Optional<StudentDTO> nullStudentDTO = IfPresentUtil.toStudentDtoSinceJava8(null);
		assertTrue(nullStudentDTO.isEmpty());

		// with non null student reference
		Student student = new Student(null, 123, null);
		Optional<StudentDTO> studentDtoOptinal = IfPresentUtil
				.toStudentDtoSinceJava8(student);
		if (studentDtoOptinal.isPresent()) { // force null check
			StudentDTO studentDTO = studentDtoOptinal.get();
			assertTrue(studentDTO.getRollNumber().equals(student.getRollNumber()));
		}

	}

}
