package methodsJson;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

import interfaces.IAirplaneMethods;
import models.Airplane;

public class AirplaneMethodsJson implements IAirplaneMethods {

	private static ArrayList<Airplane> airplaneList;
	private static GenericProviderJson<Airplane> genericProvider;

	public AirplaneMethodsJson() {
		genericProvider = new GenericProviderJson<Airplane>(new File("airplane"));
	}

	@Override
	public void createAirplane(Airplane airplane) {
		airplaneList = new ArrayList<Airplane>();
		airplaneList.add(airplane);
		try {
			genericProvider.serialize(airplaneList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void editAirplane(Airplane airplane) {
		try {
			airplaneList = genericProvider.deserialize();
			Airplane airplaneEdit = airplaneList.stream().filter((p) -> p.getId() == airplane.getId()).findFirst()
					.get();
			airplaneEdit.setCompanyName(airplane.getCompaneName());
			airplaneEdit.setDepartureTime(airplane.getDepartureTime());
			airplaneEdit.setArrivalTime(airplane.getArrivalTime());
			airplaneEdit.setCityFrom(airplane.getCityFrom());
			airplaneEdit.setCityTo(airplane.getCityTo());
			airplaneList.add(airplane);
			genericProvider.serialize(airplaneList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public void deleteAirplane(int idAirplane) {

		try {
			airplaneList = genericProvider.deserialize();
			ArrayList<Airplane> newList = new ArrayList<Airplane>();
			newList = airplaneList.stream().filter((p) -> p.getId() != idAirplane).distinct()
					.collect(Collectors.toCollection(ArrayList::new));
			airplaneList = newList;
			genericProvider.serialize(airplaneList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Airplane getAirplaneById(int idAirplane) {
		try {
			airplaneList = genericProvider.deserialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplaneList.stream().filter((p) -> p.getId() == idAirplane).findFirst().get();
	}

	@Override
	public ArrayList<Airplane> getAllAirplane() {
		try {
			airplaneList = genericProvider.deserialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplaneList.stream().collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCityFrom(String cityFrom) {
		try {
			
			airplaneList = genericProvider.deserialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplaneList.stream().filter((p) -> p.getCityFrom().equals(cityFrom)).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCityTo(String cityTo) {
		try {
			airplaneList = genericProvider.deserialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplaneList.stream().filter((p) -> p.getCityTo().equals(cityTo)).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCompane(String company) {
		try {
			airplaneList = genericProvider.deserialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplaneList.stream().filter((p) -> p.getCompaneName().equals(company)).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
