package com.techgurukul.stream.optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class OptioanStreamTest {
	@Test
	void test_stream() {
		Optional<Integer> integerOptioanl = Optional.of(Integer.valueOf(2));
		Stream<Integer> integerStream = integerOptioanl.stream();
		assertTrue(integerStream.findFirst().isPresent());

	}
}
