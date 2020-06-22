package com.techgurukul.stream.optional;

import java.util.Optional;

public class OrElseThrowCustomExceptionUtil {

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
		if (null != student.getGender()) {
			studentDTO.setGender(student.getGender());
		} else {
			throw new RuntimeException("Gender can not be empty.");
		}
		return studentDTO;
	}

	public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

		if (student == null) {
			return Optional.empty();
		}

		StudentDTO studentDTO = new StudentDTO();

		Optional.ofNullable(student.getName()).ifPresent(studentDTO::setName);
		Optional.ofNullable(student.getRollNumber()).ifPresent(rN -> studentDTO.setRollNumber(rN));

		Optional.ofNullable(student.getEmail()).ifPresent(email -> {
			if (!email.isEmpty()) {
				studentDTO.setEmail(email);
			}
		});
		studentDTO.setGender(Optional.ofNullable(student.getGender())
				.orElseThrow(() -> new RuntimeException("Gender can not be empty.")));

		return Optional.of(studentDTO);
	}

	private OrElseThrowCustomExceptionUtil() {
	}

}
