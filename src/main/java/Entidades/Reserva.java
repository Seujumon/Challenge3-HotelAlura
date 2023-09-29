package Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	private Double valor;
	@Enumerated
	private FormaDePago formaDePago;


	public Reserva(LocalDate fecha_entrada, LocalDate fecha_salida, Double valor, FormaDePago formaDePago) {
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public Reserva() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(LocalDate fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public LocalDate getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(LocalDate fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reserva reserva = (Reserva) o;
		return Objects.equals(id, reserva.id) && Objects.equals(fecha_entrada, reserva.fecha_entrada) && Objects.equals(fecha_salida, reserva.fecha_salida) && Objects.equals(valor, reserva.valor) && formaDePago == reserva.formaDePago;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fecha_entrada, fecha_salida, valor, formaDePago);
	}

	@Override
	public String toString() {
		return "Reserva{" +
				"id=" + id +
				", fecha_entrada=" + fecha_entrada +
				", fecha_salida=" + fecha_salida +
				", valor=" + valor +
				", formaDePago=" + formaDePago +
				'}';
	}
}
