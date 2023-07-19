package es.cic.ejerc003;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

class GestionAlumnosTest {

	GestionAlumnos gestAlum = new GestionAlumnos();

	@Test
	void testCrearAlumno() {
		gestAlum.CrearAlumno(998, "Prueba", 8, "pr@pr.es");
		List<Alumnos> listado = gestAlum.CrearAlumno(999, "Test", 9, "test@test.es");

		assertEquals(999, listado.get(listado.size() - 1).id, 0.000001);
		assertEquals("Test", listado.get(listado.size() - 1).nombre);
		assertEquals(9, listado.get(listado.size() - 1).nota, 0.000001);
		assertEquals("test@test.es", listado.get(listado.size() - 1).contacto);
	}

	@Test
	void testEliminarAlumno() {
		int id = 999;
		boolean validacion = true;
		List<Alumnos> listado = gestAlum.EliminarAlumno(id);

		for (Alumnos l : listado) {
			if (l.getId() == id) {
				validacion = false;
			}
		}
		assertTrue(validacion);

		id = 998;
		validacion = false;
		for (Alumnos l : listado) {
			if (l.getId() == id) {
				validacion = true;
			}
		}
		assertTrue(validacion);
		gestAlum.EliminarAlumno(id);
	}

	@Test
	void testObtenerRuta() {
		File csv = new File(gestAlum.obtenerRuta());
		assertTrue(csv.exists());
	}
}
