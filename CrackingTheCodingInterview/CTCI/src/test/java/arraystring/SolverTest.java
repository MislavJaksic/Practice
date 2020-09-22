package arraystring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolverTest {

	Solver solver = new Solver();

	@Test
	void testUnique() {
		assertTrue(solver.isUnique("abcdefg"));
	}

	@Test
	void testNotUnique() {
		assertFalse(solver.isUnique("abcddfg"));
	}

	@Test
	void testNull() {
		assertTrue(solver.isUnique(null));
	}

	@Test
	void testEmpty() {
		assertTrue(solver.isUnique(""));
	}

}
