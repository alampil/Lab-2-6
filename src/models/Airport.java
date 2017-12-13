package models;

public class Airport {
	private String name;
	private int id;
	private Airplane airplane;

	public Airport(int id, String name, Airplane airplane) {
		this.name = name;
		this.id = id;
		this.airplane = airplane;
	}

	public Airport() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Airport airport = (Airport) o;

		if (id != airport.id)
			return false;
		if (name != null ? !name.equals(airport.name) : airport.name != null)
			return false;
		return airplane != null ? airplane.equals(airport.airplane) : airport.airplane == null;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int newId) {
		this.id = newId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public Airplane getAirplane() {
		return this.airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	@Override
	public String toString() {
		return "Airport{" + "id=" + id + ", name='" + name + '\'' + ", airplane=" + airplane + "}\n"
				+ "------------------------------" + "------------------------------" + "------------------------------"
				+ "------------------------------";
	}

}