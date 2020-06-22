package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalMapTest {
	/**
	 * This test shows how we can use filter method which return same optional if
	 * the optional is empty/null other wise given filter will be applied.
	 * 
	 * If give filter don't match then empty Optional will be returned, else same
	 * optional will be returned
	 */
	@Test
	void test_map() {

		// Null or empty optional
		Student nullStu = null;
		Optional<Student> nullStuOptioanl = Optional.ofNullable(nullStu);

		Optional<String> nameOptional = nullStuOptioanl.map(st -> st.getName());
		assertTrue(nameOptional.isEmpty());
		assertFalse(nameOptional.isPresent());

		// non null optional
		Student stu = new Student("test", 123, "test@email.com");
		Optional<Student> studentOptional = Optional.of(stu);

		// New Optional will be created with the type of getName, which is String in
		// this case
		// In simple terms Map takes one input and convert it to different response, in
		// below case input type is stu (Student) and output is name(String) of the
		// student.

		nameOptional = studentOptional.map(Student::getName);
		assertFalse(nameOptional.isEmpty());
		assertTrue(nameOptional.isPresent());
		assertTrue(nameOptional.get().equals(stu.getName()));

		// map chain
		Optional<Integer> rollNumber = studentOptional.map(st -> st.getRollNumber()).map(Integer::valueOf);
		assertTrue(rollNumber.isPresent());
		assertTrue(rollNumber.get().equals(123));

	}
}
