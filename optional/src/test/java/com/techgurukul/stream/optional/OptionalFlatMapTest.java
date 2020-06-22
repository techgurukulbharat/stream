package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalFlatMapTest {

	/**
	 * This test shows how we can use flatMap method which is same as Map, the only
	 * thing it doesn't wrap the return value in Optional.
	 * 
	 * if given optional is empty/null then returns empty Optional.
	 * if given optional is non-empty then simply return the value without wrapping in Optional.
	 * 
	 * Simple map returns Optional of Optional whereas flatMap returns only Optional, if mapped value is Optional
	 * 
	 * Note: The mapped value should also be an optional
	 */
	@Test
	void test_flatMap() {

		// Null or empty optional
		Teacher nullTeacher = null;
		Optional<Teacher> nullTeacherOptioanl = Optional.ofNullable(nullTeacher);

		Optional<Optional<String>> nullTeacherMapOptional = nullTeacherOptioanl.map(Teacher::getDepartment);
		assertTrue(nullTeacherMapOptional.isEmpty());

		Optional<String> nullTeacherFlatMapOptional = nullTeacherOptioanl.flatMap(Teacher::getDepartment);
		assertTrue(nullTeacherFlatMapOptional.isEmpty());

		// Non null optional
		Optional<Teacher> teacher = Optional.of(new Teacher("tTest", "Computer"));
		Optional<Optional<String>> depMap = teacher.map(Teacher::getDepartment);
		assertTrue(depMap.get().get().equals("Computer"));

		Optional<String> depFlatMap = teacher.flatMap(Teacher::getDepartment);
		assertTrue(depFlatMap.get().equals("Computer"));

	}
}
