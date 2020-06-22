package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class OrElseVsOrElseGetUtilTest {

	static int timeTakenInOrElse = 0;
	/**
	 * When Optional.orElse used, this method execute statement defined in orElse
	 * part as well, it doeson't matter whether the optional is empty/null or not.
	 * 
	 * In below test rollNumber is already provided but still getRollNumber() method
	 * executed which sleeps for 2sec, due to this test method will take 2 or more
	 * Second to complete the execution.
	 * 
	 * It means if the called method(like getRollNumber()) have some complex or
	 * transaction logic which should be executed only if optional null/empty will
	 * always if executed. So use orElse method with care else you will get unwanted
	 * results in your code.
	 */
	@Test
	@Order(1)    
	void test_toStudentDto_By_OrElse() {

		Student student = new Student("test", 123, null);
		long startTime = System.currentTimeMillis();
		Optional<StudentDTO> optionalStudentDTO = OrElseVsOrElseGetUtil.toStudentDtoByOrElse(student);
		long endTime = System.currentTimeMillis();
		timeTakenInOrElse = (int )(endTime - startTime) / 1000;
		assertTrue(timeTakenInOrElse >= 2);

		if (optionalStudentDTO.isPresent()) {
			StudentDTO studentDTO = optionalStudentDTO.get();
			assertTrue(studentDTO.getName().equals("test"));
			assertTrue(studentDTO.getEmail().equals("test@test.com"));
			assertNotNull(studentDTO.getRollNumber());
		}
	}

	/**
	 * When Optional.orElseGet used, this method execute statement defined in
	 * orElseGet only if optional is empty/null.
	 * 
	 * In below test rollNumber is already provided so, getRollNumber() will not be
	 * invoke unlike orElse method described above.
	 * 
	 * By default every time use orElseGet method unless there is specific
	 * requirement (like the called method just return object which is already
	 * defined. ) to use orElse
	 * 
	 * The below test will always take less time compare to first method.
	 */

	@Test
	@Order(2)    
	void test_toStudentDto_By_OrElseGet() {

		long startTime = System.currentTimeMillis();
		Student student = new Student("test", 123, null);
		long endTime = System.currentTimeMillis();
		assertTrue((endTime - startTime) / 1000 < timeTakenInOrElse);

		Optional<StudentDTO> optionalStudentDTO = OrElseVsOrElseGetUtil.toStudentDtoByOrElseGet(student);
		if (optionalStudentDTO.isPresent()) {
			StudentDTO studentDTO = optionalStudentDTO.get();
			assertTrue(studentDTO.getName().equals("test"));
			assertTrue(studentDTO.getEmail().equals("test@test.com"));
			assertNotNull(studentDTO.getRollNumber());
		}
	}

}
