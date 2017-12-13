package methods;

import java.util.ArrayList;
import java.util.stream.Collectors;

import interfaces.IAirplaneMethods;
import models.Airplane;

public class AirplaneMethods implements IAirplaneMethods {

	private static ArrayList<Airplane> airplaneList;

	@Override
	public void createAirplane(Airplane airplane) {
		airplaneList = new ArrayList<Airplane>();
		airplaneList.add(airplane);

	}

	@Override
	public void editAirplane(Airplane airplane) {
		Airplane airplaneEdit = airplaneList.stream().filter((p) -> p.getId() == airplane.getId()).findFirst().get();
		airplaneEdit.setCompanyName(airplane.getCompaneName());
		airplaneEdit.setDepartureTime(airplane.getDepartureTime());
		airplaneEdit.setArrivalTime(airplane.getArrivalTime());
		airplaneEdit.setCityFrom(airplane.getCityFrom());
		airplaneEdit.setCityTo(airplane.getCityTo());

	}

	@Override
	public void deleteAirplane(int idAirplane) {
		ArrayList<Airplane> newList = new ArrayList<Airplane>();
		newList = airplaneList.stream().filter((p) -> p.getId() != idAirplane).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
		airplaneList = newList;

	}

	@Override
	public Airplane getAirplaneById(int idAirplane) {
		return airplaneList.stream().filter((p) -> p.getId() == idAirplane).findFirst().get();
	}

	@Override
	public ArrayList<Airplane> getAllAirplane() {
		return airplaneList.stream().collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCityFrom(String cityFrom) {
		return airplaneList.stream().filter((p) -> p.getCityFrom().equals(cityFrom)).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCityTo(String cityTo) {
		return airplaneList.stream().filter((p) -> p.getCityTo().equals(cityTo)).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCompane(String company) {
		return airplaneList.stream().filter((p) -> p.getCompaneName().equals(company)).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
