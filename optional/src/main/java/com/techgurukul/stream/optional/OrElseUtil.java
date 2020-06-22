package com.techgurukul.stream.optional;

import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

public class OrElseUtil {

	private static final Logger LOGGER = Logger.getLogger(OrElseUtil.class.getName());

	static int maxRollNumber = 10;
	static int minRollNumber = 1;
	static Random r = new Random();

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
			studentDTO.setRollNumber(getRollNumber());
		}
		if (null != student.getEmail() && !student.getEmail().isEmpty()) {
			studentDTO.setEmail(student.getEmail());
		} else {
			studentDTO.setEmail("test@test.com");
		}
		return studentDTO;
	}

	private static Integer getRollNumber() {
		LOGGER.info("Generate random number");
		int rollNumber = r.nextInt((maxRollNumber - minRollNumber) + 1) + minRollNumber;
		LOGGER.info("Generated random number is: " + rollNumber);
		return rollNumber;
	}

	public static Optional<StudentDTO> toStudentDtoSinceJava8(Student student) {

		if (student == null) {
			return Optional.empty();
		}

		StudentDTO studentDTO = new StudentDTO();

		studentDTO.setName(Optional.ofNullable(student.getName()).orElse("test"));
		studentDTO.setRollNumber(Optional.ofNullable(student.getRollNumber()).orElse(getRollNumber()));
		studentDTO.setEmail(Optional.ofNullable(student.getEmail()).orElse("test@test.com"));
		return Optional.of(studentDTO);
	}

	private OrElseUtil() {
	}

}
