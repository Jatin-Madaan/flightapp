package com.flightapp.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="SCHEDULE_MASTER")
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="SCHEDULE_ID")
	@GeneratedValue
	private int scheduleId;
	
	@ManyToOne
	@JoinColumn(name="SOURCE_ID")
	private Airport sourceAirport;
	
	@ManyToOne
	@JoinColumn(name="DEST_ID")
	private Airport destinationAirport;
	
	@NotNull
	private Timestamp departureTime;
	
	@NotNull
	private Timestamp arrivalTime;

	@OneToOne(mappedBy = "schedule")
	private ScheduleFlight scheduleFlight;
	
	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public Timestamp getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
}
