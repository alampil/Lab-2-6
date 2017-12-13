package models;

import java.time.LocalTime;

public class Airplane {

	private int id;
	private String companyName;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private String cityFrom;
	private String cityTo;

	public Airplane() {
	}

	public Airplane(int id, String companyName, LocalTime departureTime,
			LocalTime arrivalTime, String cityFrom, String cityTo) {
		this.id = id;
		this.companyName = companyName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int newId) {
		this.id = newId;
	}

	public String getCompaneName() {
		return this.companyName;
	}

	public void setCompanyName(String newCompanyName) {
		this.companyName = newCompanyName;
	}

	public LocalTime getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(LocalTime newDepartureTime) {
		this.departureTime = newDepartureTime;
	}

	public LocalTime getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(LocalTime newArrivalTime) {
		this.arrivalTime = newArrivalTime;
	}

	public String getCityFrom() {
		return this.cityFrom;
	}

	public void setCityFrom(String newCityFrom) {
		this.cityFrom = newCityFrom;
	}

	public String getCityTo() {
		return this.cityTo;
	}

	public void setCityTo(String newCityTo) {
		this.cityTo = newCityTo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Airplane flight = (Airplane) o;

		if (id != flight.id)
			return false;
		if (departureTime != flight.departureTime)
			return false;
		if (companyName != null ? !companyName.equals(flight.companyName) : flight.companyName != null)
			return false;
		if (arrivalTime != null ? !arrivalTime.equals(flight.arrivalTime) : flight.arrivalTime != null)
			return false;
		if (cityFrom != flight.cityFrom)
			return false;
		return cityTo == flight.cityTo;
	}

	@Override
	public String toString() {
		return "Flight{" + "id=" + id + ", companyName='" + companyName + '\'' + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", cityFrom=" + cityFrom + ", cityTo=" + cityTo + '}';
	}

}
