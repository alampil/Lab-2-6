package interfaces;

import java.util.ArrayList;

import models.Airplane;

public interface IAirplaneMethods {

	void createAirplane(Airplane airplane);

	void editAirplane(Airplane airplane);

	void deleteAirplane(int idAirplane);

	Airplane getAirplaneById(int idAirplane);

	ArrayList<Airplane> getAllAirplane();

	ArrayList<Airplane> getAirplaneByCityFrom(String cityFrom);

	ArrayList<Airplane> getAirplaneByCityTo(String cityTo);

	ArrayList<Airplane> getAirplaneByCompane(String company);
}
