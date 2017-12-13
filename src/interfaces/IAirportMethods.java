package interfaces;

import java.util.ArrayList;

import models.Airport;

public interface IAirportMethods {

	void createAirport(Airport airport);

	void editAirport(Airport airport);

	void deleteAirport(int idAirport);

	Airport getAirportById(int idAirport);

	ArrayList<Airport> getAllAirport();

}
