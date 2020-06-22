package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OptionalCreateTest {

	/**
	 * Optional.empty creates an optional which have value is null
	 */
	@Test
	void test_create_emptyOptional() {
		Optional<String> emptyOptional = Optional.empty();
		assertTrue(emptyOptional.isEmpty());//created without value so it's empty
		assertFalse(emptyOptional.isPresent());//created without value so it's not having any value
		
		//empty Optional Object don't have any value so, emptyOptional.get() will throw NoSuchElementException.
		assertThrows(NoSuchElementException.class, () -> emptyOptional.get());
	}

	/**
	 * Optional.of creates an optional for a variable which should be non-null.
	 */
	@Test
	void test_create_nonEmptyOptional() {

		Optional<String> nonEmptyOptional = Optional.of("testOptional");
		assertFalse(nonEmptyOptional.isEmpty());// created with value so it's not empty
		assertTrue(nonEmptyOptional.isPresent());// created with value so it's having value
		
		//nonEmptyOptional Object have value(testOptional) so, nonEmptyOptional.get() will not throw any exception.
		assertDoesNotThrow(() -> nonEmptyOptional.get());
		// Optional.of method throw NullPointerException if value passed to this method is null.
		assertThrows(NullPointerException.class, () -> Optional.of(null));
	}

	/**
	 * Optional.ofNullable creates an optional for a variable which might be null or
	 * non-null.
	 */
	@Test
	void test_createOptional_with_nullOrNonNullValue() {

		Optional<String> emptyOptional = Optional.ofNullable(null);
		assertTrue(emptyOptional.isEmpty());//created without value so it's empty
		assertFalse(emptyOptional.isPresent());//created without value so it's not having any value
		
		//empty Optional Object don't have any value so, emptyOptional.get() will throw NoSuchElementException.
		assertThrows(NoSuchElementException.class, () -> emptyOptional.get());

		Optional<String> nonEmptyOptional = Optional.ofNullable("testOptional");
		assertFalse(nonEmptyOptional.isEmpty());//created with value so it's not empty
		assertTrue(nonEmptyOptional.isPresent());//created with value so it's having value
		
		//nonEmptyOptional Object have value(testOptional) so, nonEmptyOptional.get() will not throw any exception.
		assertDoesNotThrow(() -> nonEmptyOptional.get());
	}

}
