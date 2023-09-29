package Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Huesped {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private LocalDate fecha_de_nacimiento;
	private String nacionalidad;
	private String telefono;
	@OneToMany
	private List<Reserva> reserva = new ArrayList<>();

	public Huesped() {

	}

	public Huesped(String nombre, String apellido, LocalDate fecha_de_nacimiento, String nacionalidad, String telefono, Reserva reserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reserva.add(reserva);
	}

	public Huesped(Long id, String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono, List<Reserva> reservas) {
		this.id = id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_de_nacimiento= fechaDeNacimiento;
		this.nacionalidad= nacionalidad;
		this.telefono=telefono;
		this.reserva= reservas;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Huesped huesped = (Huesped) o;
		return Objects.equals(id, huesped.id) && Objects.equals(nombre, huesped.nombre) && Objects.equals(apellido, huesped.apellido) && Objects.equals(fecha_de_nacimiento, huesped.fecha_de_nacimiento) && Objects.equals(nacionalidad, huesped.nacionalidad) && Objects.equals(telefono, huesped.telefono) && Objects.equals(reserva, huesped.reserva);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, reserva);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(LocalDate fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Huesped{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", fecha_de_nacimiento=" + fecha_de_nacimiento +
				", nacionalidad='" + nacionalidad + '\'' +
				", telefono='" + telefono + '\'' +
				", reserva=" + reserva +
				'}';
	}
}
