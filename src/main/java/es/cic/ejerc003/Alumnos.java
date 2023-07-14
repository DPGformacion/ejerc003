package es.cic.ejerc003;

public class Alumnos {
	
	public int id;
	public String nombre;
	public int nota;
	public String contacto;
	
	/*public Alumnos() {
		int id = 0;
		String nombre = "";
		int nota = 0;
		String contacto = "";
	}*/
	
	public Alumnos(int id, String nombre, int nota, String contacto) {
		this.id = id;
		this.nombre = nombre;
		this.nota = nota;
		this.contacto = contacto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "\n" + id + ", " + nombre + ", " + nota + ", " + contacto;
	}

}