package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalValidationTest {
	/**
	 * This test shows how we can use isEmpty method to check if there is a value in
	 * it or not
	 */
	@Test
	void test_isEmpty() {

		Optional<String> emptyOptional = Optional.ofNullable(null);
		assertTrue(emptyOptional.isEmpty());//created without value so it's empty

		Optional<String> nonEmptyOptional = Optional.ofNullable("testOptional");
		assertFalse(nonEmptyOptional.isEmpty());//created with value so it's not empty

	}

	/**
	 * This test shows how we can use isPresent method to check if there is a value
	 * in it or not
	 */
	@Test
	void test_isPresent() {

		Optional<String> emptyOptional = Optional.ofNullable(null);
		assertFalse(emptyOptional.isPresent());//created without value so value is not present

		Optional<String> nonEmptyOptional = Optional.ofNullable("testOptional");
		assertTrue(nonEmptyOptional.isPresent());//created with value so value is present

	}
}
