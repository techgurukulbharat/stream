package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalFilterTest {
	/**
	 * This test shows how we can use filter method which return same optional if
	 * the optional is empty/null other wise given filter will be applied.
	 * 
	 * If give filter don't match then empty Optional will be returned, else same
	 * optional will be returned
	 */
	@Test
	void test_filter() {

		// Null or empty optional
		Student nullStu = null;
		Optional<Student> nullStuOptioanl = Optional.ofNullable(nullStu);

		Optional<Student> nullStuOptioanlFilter = nullStuOptioanl.filter(st -> "test".equals(st.getName()));
		assertTrue(nullStuOptioanl.equals(nullStuOptioanlFilter)); // same optional check
		assertTrue(nullStuOptioanlFilter.isEmpty());

		// non null optional
		Student stu = new Student("test", 123, "test@email.com");
		Optional<Student> studentOptional = Optional.of(stu);

		// filter not matched, empty optional will be returned
		Optional<Student> emptyFilter = studentOptional.filter(st -> "default".equals(st.getName()));
		assertTrue(emptyFilter.equals(Optional.empty()));
		assertTrue(emptyFilter.isEmpty());

		// filter matched, same Optional will be returned
		Optional<Student> filteredStudentOptional = studentOptional.filter(st -> "test".equals(st.getName()));
		assertTrue(filteredStudentOptional.equals(studentOptional));
		assertTrue(filteredStudentOptional.isPresent());

		// filter in chain
		Optional<Student> chinFilteredStudentOptional = studentOptional.filter(st -> "test".equals(st.getName()))
				.filter(st -> "test@email.com".equals(st.getEmail())).filter(st -> st.getRollNumber().equals(123));

		assertTrue(chinFilteredStudentOptional.equals(studentOptional));
		assertTrue(chinFilteredStudentOptional.isPresent());
	}
}
