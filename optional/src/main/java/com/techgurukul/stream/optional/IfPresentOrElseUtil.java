package com.techgurukul.stream.optional;

import java.util.Optional;

public class IfPresentOrElseUtil {


	public static StudentDTO toStudentDtoBeforeJava8(Student student) {
		if (student == null) {
			return null;
		}

		StudentDTO studentDTO = new StudentDTO();

		if (null != student.getName()) {
			studentDTO.setName(student.getName());
		} else {
			studentDTO.setName("test");
		}
		if (null != student.getRollNumber()) {
			studentDTO.setRollNumber(student.getRollNumber());
		} else {
			studentDTO.setRollNumber(123);
		}
		if (null != student.getEmail() && !student.getEmail().isEmpty()) {
			studentDTO.setEmail(student.getEmail());
		} else {
			studentDTO.setLastName("one");
			studentDTO.setEmail("test@test.com");
		}
		return studentDTO;
	}

	public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

		if (student == null) {
			return Optional.empty();
		}

		StudentDTO studentDTO = new StudentDTO();

		Optional.ofNullable(student.getName()).ifPresentOrElse(studentDTO::setName, () -> studentDTO.setName("test"));
		Optional.ofNullable(student.getRollNumber()).ifPresentOrElse(rN -> studentDTO.setRollNumber(rN),
				() -> studentDTO.setRollNumber(123));
		Optional.ofNullable(student.getEmail()).ifPresentOrElse(email -> {
			if (!email.isEmpty()) {
				studentDTO.setEmail(email);
			}
		}, () -> {
			studentDTO.setLastName("one");
			studentDTO.setEmail("test@test.com");
		});

		return Optional.of(studentDTO);
	}

	private IfPresentOrElseUtil() {
	}
}
