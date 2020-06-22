package com.techgurukul.stream.optional;

import java.util.Optional;

public class OrUtil {

	public static Optional<Student> getStudent(Student student) {

		return Optional.ofNullable(student)
				.or(() -> Optional.of(new Student("defaultName", 001, "defualtEmail@email.com")));

	}

	private OrUtil() {
	}

}
