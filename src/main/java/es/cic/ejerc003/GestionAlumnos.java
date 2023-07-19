package es.cic.ejerc003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionAlumnos {

	public List<Alumnos> CrearAlumno(int id, String nombre, int nota, String contacto) {

		List<Alumnos> listado = ObtenerDatos();

		listado.add(new Alumnos(id, nombre, nota, contacto));

		GuardarDatos(listado);
		return listado;
	}

	public List<Alumnos> EliminarAlumno(int id) {

		List<Alumnos> listado = ObtenerDatos();

		for (Alumnos l : listado) {
			if (l.getId() == id) {
				listado.remove(l);
				break;
			}
		}

		GuardarDatos(listado);
		return listado;
	}

	public List<Alumnos> ObtenerDatos() {

		List<Alumnos> lista = new ArrayList<Alumnos>();

		try {

			FileReader fr = new FileReader(obtenerRuta());
			BufferedReader lecturaDatos = new BufferedReader(fr);
			String linea = "";
			String[] columna = new String[4];

			lecturaDatos.readLine();

			while (lecturaDatos.ready()) {

				linea = lecturaDatos.readLine();
				columna = linea.split(",");
				lista.add(new Alumnos(Integer.parseInt(columna[0]), columna[1], Integer.parseInt(columna[2]),
						columna[3]));
			}
			lecturaDatos.close();
		} catch (IOException e) {

		}
		return lista;

	}

	public void GuardarDatos(List<Alumnos> listado) {
		try {

			FileWriter fw = new FileWriter(obtenerRuta());
			BufferedWriter escrituraDatos = new BufferedWriter(fw);

			escrituraDatos.write("ID,NOMBRE,CONTACTO,NOTA");

			for (Alumnos l : listado) {
				escrituraDatos.write(l.toString());
			}

			escrituraDatos.close();
		} catch (IOException e) {

		}
	}

	public String obtenerRuta() {

		String separador = "" + File.separatorChar;
		String ruta = "src" + separador + "test" + separador + "resources" + separador + "Alumnos.csv";
		return ruta;
	}

}
