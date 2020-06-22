package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OrElseThrowUtilTest {

	@Test
	void test_toStudentDtoBeforeJava8() {
		// with null student reference
		StudentDTO nullStudentDTO = OrElseThrowUtil.toStudentDtoBeforeJava8(null);
		assertNull(nullStudentDTO);

		// with non null student reference
		Student student = new Student("test", null, null);
		assertThrows(NoSuchElementException.class, () -> OrElseThrowUtil.toStudentDtoBeforeJava8(student));
	}

	@Test
	void test_toStudentDtoSinceJava8() {
		// with null student reference
		Optional<StudentDTO> nullStudentDTO = OrElseThrowUtil.toStudentDtoSinceJava8(null);
		assertTrue(nullStudentDTO.isEmpty());

		// with non null student reference
		Student student = new Student("test", null, null);
		assertThrows(NoSuchElementException.class, () -> OrElseThrowUtil.toStudentDtoSinceJava8(student));

	}

}
