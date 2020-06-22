package com.techgurukul.stream.optional;

import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

public class OrElseVsOrElseGetUtil {

	private static final Logger LOGGER = Logger.getLogger(OrElseVsOrElseGetUtil.class.getName());

	static int maxRollNumber = 10;
	static int minRollNumber = 1;
	static Random r = new Random();

	private static Integer getRollNumber() {
		long startTime = System.currentTimeMillis();
		LOGGER.info("Generate random number.");
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			LOGGER.info("Error in thread sleep.");
			Thread.currentThread().interrupt();
		}
		int rollNumber = r.nextInt((maxRollNumber - minRollNumber) + 1) + minRollNumber;
		LOGGER.info(() -> "Generated random number is: " + rollNumber + " Total time taken: "
				+ (System.currentTimeMillis() - startTime)/1000 + "Sec");
		return rollNumber;
	}

	public static Optional<StudentDTO> toStudentDtoByOrElse(Student student) {

		if (student == null) {
			return Optional.empty();
		}

		StudentDTO studentDTO = new StudentDTO();

		studentDTO.setName(Optional.ofNullable(student.getName()).orElse("test"));
		studentDTO.setRollNumber(Optional.ofNullable(student.getRollNumber()).orElse(getRollNumber()));
		studentDTO.setEmail(Optional.ofNullable(student.getEmail()).orElse("test@test.com"));
		return Optional.of(studentDTO);
	}

	public static Optional<StudentDTO> toStudentDtoByOrElseGet(Student student) {

		if (student == null) {
			return Optional.empty();
		}

		StudentDTO studentDTO = new StudentDTO();

		studentDTO.setName(Optional.ofNullable(student.getName()).orElseGet(() -> "test"));
		studentDTO.setRollNumber(
				Optional.ofNullable(student.getRollNumber()).orElseGet(OrElseVsOrElseGetUtil::getRollNumber));
		studentDTO.setEmail(Optional.ofNullable(student.getEmail()).orElseGet(() -> "test@test.com"));
		return Optional.of(studentDTO);
	}

	private OrElseVsOrElseGetUtil() {
	}

}
