package com.robertojr.PROJECT_API_REST.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.robertojr.PROJECT_API_REST.entities.enums.HistoryStatus;
import com.robertojr.PROJECT_API_REST.entities.enums.RacerStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_historico")
public class Historico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String origem;
	private String destino;
	private HistoryStatus status;
	private String motorista;
	private Integer vagasTotais;
	private Integer vagasDisponiveis;

	private Integer vagasReservadas;
	private Double valorUnitario;
	private Double valorTotal;
	private Instant data;

	private Racer corrida;
	private Reserve reserva;

	public Historico() {

	}

	public Historico historicoDriver(Racer corrida) {
		this.origem = corrida.getOrigin();
		this.destino = corrida.getDestiny();
		this.status = (corrida.getRacerStatus() == RacerStatus.COMPLETED) ? HistoryStatus.COMPLETED
				: (corrida.getRacerStatus() == RacerStatus.ACTIVE ? HistoryStatus.ACTIVE : HistoryStatus.CANCELLED);
		this.motorista = corrida.getDriver().getName();
		this.vagasTotais = corrida.getVacancies();
		this.vagasDisponiveis = corrida.getAvailableVacancies();
		this.valorUnitario = corrida.getPricePerVacancy();
		this.data = corrida.getTime();

		return this;
	}

	public Historico historicoCustomer(Reserve reserva) {
		RacerStatus CorridaStatus = reserva.getRacer().getRacerStatus();
		this.origem = reserva.getRacer().getOrigin();
		this.destino = reserva.getRacer().getDestiny();
		this.status = (CorridaStatus == RacerStatus.ACTIVE) ? HistoryStatus.ACTIVE
				: (CorridaStatus == RacerStatus.CANCELLED ? HistoryStatus.CANCELLED : HistoryStatus.COMPLETED);
		this.motorista = reserva.getRacer().getDriver().getName();
		this.vagasReservadas = reserva.getVacancy();
		this.valorUnitario = reserva.getRacer().getPricePerVacancy();
		this.valorTotal = reserva.getRacer().getPricePerVacancy() * reserva.getVacancy();
		this.data = reserva.getDataReserve();

		return this;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public HistoryStatus getStatus() {
		return status;
	}

	public void setStatus(HistoryStatus status) {
		this.status = status;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public Integer getVagasTotais() {
		return vagasTotais;
	}

	public void setVagasTotais(Integer vagasTotais) {
		this.vagasTotais = vagasTotais;
	}

	public Integer getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(Integer vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public Integer getVagasReservadas() {
		return vagasReservadas;
	}

	public void setVagasReservadas(Integer vagasReservadas) {
		this.vagasReservadas = vagasReservadas;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Racer getCorrida() {
		return corrida;
	}

	public void setCorrida(Racer corrida) {
		this.corrida = corrida;
	}

	public Reserve getReserva() {
		return reserva;
	}

	public void setReserva(Reserve reserva) {
		this.reserva = reserva;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, destino, id, motorista, origem, reserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historico other = (Historico) obj;
		return Objects.equals(data, other.data) && Objects.equals(destino, other.destino)
				&& Objects.equals(id, other.id) && Objects.equals(motorista, other.motorista)
				&& Objects.equals(origem, other.origem) && Objects.equals(reserva, other.reserva);
	}

	
}
