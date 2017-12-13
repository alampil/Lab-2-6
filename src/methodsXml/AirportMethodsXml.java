package methodsXml;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

import interfaces.IAirportMethods;
import models.Airport;

public class AirportMethodsXml implements IAirportMethods {

	private ArrayList<Airport> airportList;
	private static GenericProviderXml<Airport> genericProvider;

	public AirportMethodsXml() {
		genericProvider = new GenericProviderXml<Airport>(new File("airport"));
	}

	@Override
	public void createAirport(Airport airport) {
		airportList = new ArrayList<Airport>();
		airportList.add(airport);
		try {
			genericProvider.serialize(airportList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void editAirport(Airport airport) {
		try {
			airportList = genericProvider.deserialize();
			Airport airportEdit = airportList.stream().filter((p) -> p.getId() == airport.getId()).findAny().get();
			airportEdit.setName(airport.getName());
			airportEdit.setAirplane(airport.getAirplane());
			genericProvider.serialize(airportList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAirport(int idAirport) {
		try {
			ArrayList<Airport> newList = new ArrayList<Airport>();
			airportList = genericProvider.deserialize();
			newList = airportList.stream().filter((p) -> ((Airport) p).getId() != idAirport).distinct()
					.collect(Collectors.toCollection(ArrayList::new));
			airportList = newList;
			genericProvider.serialize(airportList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Airport getAirportById(int idAirport) {
		try {
			airportList = genericProvider.deserialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airportList.stream().filter((p) -> p.getId() == idAirport).findFirst().get();
	}

	@Override
	public ArrayList<Airport> getAllAirport() {
		try {
			airportList = genericProvider.deserialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airportList.stream().collect(Collectors.toCollection(ArrayList::new));
	}

}

