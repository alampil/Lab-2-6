package methods;

import java.util.ArrayList;
import java.util.stream.Collectors;

import interfaces.IAirportMethods;
import models.Airport;

public class AirportMethods implements IAirportMethods {

	private ArrayList<Airport> airportList;

	@Override
	public void createAirport(Airport airport) {
		airportList = new ArrayList<Airport>();
		airportList.add(airport);

	}

	@Override
	public void editAirport(Airport airport) {
		Airport airportEdit = airportList.stream().filter((p) -> p.getId() == airport.getId()).findAny().get();
		airportEdit.setName(airport.getName());
		airportEdit.setAirplane(airport.getAirplane());

	}

	@Override
	public void deleteAirport(int idAirport) {
		ArrayList<Airport> newList = new ArrayList<Airport>();
		newList = airportList.stream().filter((p) -> ((Airport) p).getId() != idAirport).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
		airportList = newList;

	}

	@Override
	public Airport getAirportById(int idAirport) {
		return airportList.stream().filter((p) -> p.getId() == idAirport).findFirst().get();
	}

	@Override
	public ArrayList<Airport> getAllAirport() {
		// TODO Auto-generated method stub
		return airportList.stream().collect(Collectors.toCollection(ArrayList::new));
	}

}
