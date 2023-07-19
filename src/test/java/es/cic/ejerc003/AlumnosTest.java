package es.cic.ejerc003;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnosTest {

	Alumnos alumn = new Alumnos(999, "Test", 9, "test@test.es");

	@Test
	void testGetId() {
		assertEquals(999, alumn.getId(), 0.000001);
	}

	@Test
	void testSetId() {
		alumn.setId(998);
		assertEquals(998, alumn.getId(), 0.000001);
	}

	@Test
	void testGetNombre() {
		assertEquals("Test", alumn.getNombre());
	}

	@Test
	void testSetNombre() {
		alumn.setNombre("testset");
		assertEquals("testset", alumn.getNombre());
	}

	@Test
	void testGetNota() {
		assertEquals(9, alumn.getNota(), 0.000001);
	}

	@Test
	void testSetNota() {
		alumn.setNota(8);
		assertEquals(8, alumn.getNota(), 0.000001);
	}

	@Test
	void testGetContacto() {
		assertEquals("test@test.es", alumn.getContacto());
	}

	@Test
	void testSetContacto() {
		alumn.setContacto("testset");
		assertEquals("testset", alumn.getContacto());
	}

	@Test
	void testToString() {
		assertEquals("\n999,Test,9,test@test.es", alumn.toString());
	}

}
