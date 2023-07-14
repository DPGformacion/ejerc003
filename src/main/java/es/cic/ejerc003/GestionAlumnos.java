package es.cic.ejerc003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

			FileReader fr = new FileReader("/home/d/Desktop/Alumnos");
			BufferedReader lecturaDatos = new BufferedReader(fr);
			String[] linea = new String[4];

			lecturaDatos.readLine();

			while (lecturaDatos.ready()) {

				for (int i = 0; i < 4; i++) {
					linea[i] = lecturaDatos.readLine();
				}
				lista.add(new Alumnos(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), linea[3]));
			}
			lecturaDatos.close();
		} catch (IOException e) {

		}
		return lista;

	}

	public void GuardarDatos(List<Alumnos> listado) {
		try {

			FileWriter fw = new FileWriter("/home/d/Desktop/Alumnos");
			BufferedWriter escrituraDatos = new BufferedWriter(fw);

			escrituraDatos.write("ID , NOMBRE , CONTACTO , NOTA\n");

			for (Alumnos l : listado) {
				escrituraDatos.write(l.toString());
			}

			escrituraDatos.close();
		} catch (IOException e) {

		}
	}

}
