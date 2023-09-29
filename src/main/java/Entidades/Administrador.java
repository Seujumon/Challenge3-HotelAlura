package Entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Administrador {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nombre_de_usuario;
	private String contrasenia;

	public Administrador() {
	}

	public Administrador(String nombre_de_usuario, String contrasenia) {

		this.nombre_de_usuario = nombre_de_usuario;
		this.contrasenia = contrasenia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_de_usuario() {
		return nombre_de_usuario;
	}

	public void setNombre_de_usuario(String nombre_de_usuario) {
		this.nombre_de_usuario = nombre_de_usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Administrador that = (Administrador) o;
		return Objects.equals(id, that.id) && Objects.equals(nombre_de_usuario, that.nombre_de_usuario) && Objects.equals(contrasenia, that.contrasenia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre_de_usuario, contrasenia);
	}

	@Override
	public String toString() {
		return "Administrador{" +
				"id=" + id +
				", nombre_de_usuario='" + nombre_de_usuario + '\'' +
				", contrasenia='" + contrasenia + '\'' +
				'}';
	}
}
