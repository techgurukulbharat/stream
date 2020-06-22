package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalGetTest {

	/**
	 * This test cases shows how we can retrieve value from a non-null optional
	 * using get method of Optional class optional
	 */
	@Test
	void test_get_OptionalValue() {

		Optional<String> emptyOptional = Optional.ofNullable(null);
		assertThrows(NoSuchElementException.class, () -> emptyOptional.get());
		
		Optional<String> nonEmptyOptionalByOfNullable = Optional.ofNullable("testOptional");
		assertTrue(nonEmptyOptionalByOfNullable.get().equals("testOptional"));

		Optional<String> nonEmptyOptionalByOf = Optional.of("testOptional");
		assertTrue(nonEmptyOptionalByOf.get().equals("testOptional"));

	}
	
	
}
