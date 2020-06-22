package com.techgurukul.stream.optional;

import java.util.Optional;

public class IfPresentUtil {

	public static StudentDTO toStudentDtoBeforeJava8(Student student) {
		if (student == null) {
			return null;
		}

		StudentDTO studentDTO = new StudentDTO();

		if (null != student.getName()) {
			studentDTO.setName(student.getName());
		}
		if (null != student.getRollNumber()) {
			studentDTO.setRollNumber(student.getRollNumber());
		}
		if (null != student.getEmail() && !student.getEmail().isEmpty()) {
			studentDTO.setEmail(student.getEmail());
		}
		return studentDTO;
	}

	public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

		if (student == null) {
			return Optional.empty();
		}

		StudentDTO studentDTO = new StudentDTO();

		// There are multiple ways to use Optional
		Optional.ofNullable(student.getName()).ifPresent(studentDTO::setName);// Method reference
		Optional.ofNullable(student.getRollNumber()).ifPresent(rN -> studentDTO.setRollNumber(rN)); // normal setter

		// you can add extra logic as well like below if string is non empty then only
		// it set to studentDto
		Optional.ofNullable(student.getEmail()).ifPresent(email -> {
			if (!email.isEmpty()) {
				studentDTO.setEmail(email);
			}
		});

		return Optional.of(studentDTO);
	}

	private IfPresentUtil() {
	}

}
