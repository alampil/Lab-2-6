package main;

import java.time.LocalTime;
import java.util.ArrayList;

import models.*;
import providersSql.*;
import methods.AirplaneMethods;
import methods.AirportMethods;
import methodsXml.AirplaneMethodsXml;
import methodsXml.AirportMethodsXml;
import methodsJson.AirplaneMethodsJson;
import methodsJson.AirportMethodsJson;
import providersSql.AirplaneMethodsSql;

public class Program {

	private static AirplaneMethodsSql airplaneMethods;
	private static AirportMethodsSql airportMethods;
	private static Airplane airplane;
	private static Airport airport;
	private static ArrayList<Airplane> listAirplane;
	private static ArrayList<Airport> listAirport;

	
	
	public static void main(String[] args) {
		//AirplaneMethodsJson methods = new AirplaneMethodsJson();
		//AirplaneMethodsXml methods = new AirplaneMethodsXml();
		airplaneMethods = new AirplaneMethodsSql();
		airportMethods = new AirportMethodsSql();

		airplane = new Airplane(1, "Some name.", LocalTime.parse("10:00"), LocalTime.parse("14:00"), "Kyiv", "London.");
		airport = new Airport(1, "Boruspil.", airplane);

		
		airplane = airplaneMethods.getAirplaneById(1);
		airplaneMethods = new AirplaneMethodsSql();
		airplaneMethods.createAirplane(airplane);
		airplane.setCityTo("Tokio");
		airplane.setDepartureTime(LocalTime.parse("15:00"));
		airplane.setArrivalTime(LocalTime.parse("12:00"));
		airplane.setCompanyName("Japan airlines");
		airplaneMethods.editAirplane(airplane);
		airplaneMethods.deleteAirplane(4);
		listAirplane = new ArrayList<Airplane>();
		
		airplane = airplaneMethods.getAirplaneById(2);
		airplaneMethods = new AirplaneMethodsSql();
		airplaneMethods.createAirplane(airplane);
		airplane.setCityTo("Lviv");
		airplane.setDepartureTime(LocalTime.parse("21:00"));
		airplane.setArrivalTime(LocalTime.parse("22:00"));
		airplane.setCompanyName("Ukraine airlines");
		airplaneMethods.editAirplane(airplane);
		airplaneMethods.deleteAirplane(4);
		listAirplane = new ArrayList<Airplane>();
		
		airplane = airplaneMethods.getAirplaneById(3);
		airplaneMethods = new AirplaneMethodsSql();
		airplaneMethods.createAirplane(airplane);
		airplane.setCityTo("Paris");
		airplane.setDepartureTime(LocalTime.parse("11:00"));
		airplane.setArrivalTime(LocalTime.parse("15:00"));
		airplane.setCompanyName("France airlines");
		airplaneMethods.editAirplane(airplane);
		airplaneMethods.deleteAirplane(4);
		listAirplane = new ArrayList<Airplane>();
		
		/*System.out.println("Airplane by id " + 1);
		System.out.println(airplane.getId() + " Company name: " + airplane.getCompaneName() + " Departure time: "
				+ airplane.getDepartureTime() + " Arrival time: " + airplane.getArrivalTime() + " City from: "
				+ airplane.getCityFrom() + " City to: " + airplane.getCityTo());*/
		
		listAirplane = airplaneMethods.getAllAirplane();
		System.out.println("All airplane ");
		for (Airplane airplane : listAirplane) {
			System.out.println(airplane.getId() + " Company name: " + airplane.getCompaneName() + ". Departure time: "
					+ airplane.getDepartureTime() + ". Arrival time: " + airplane.getArrivalTime() + ". City from: "
					+ airplane.getCityFrom() + ". City to: " + airplane.getCityTo());
		}

		listAirport = new ArrayList<Airport>();
		airport = airportMethods.getAirportById(4);
		System.out.println("Airport by id " + 4);

		listAirport = airportMethods.getAllAirport();
		System.out.println("All airports ");
		for (Airport airport : listAirport) {
			System.out.println("id " + airport.getId() + " Airport name: " + airport.getName() + " flight: "
					+ airport.getAirplane());
				
		}/*
		for (Airplane airplane : methods.getAirplaneByCityFrom("Kiev")) {
			System.out.println(airplane.getId() + " Company name: " + airplane.getCompaneName() + ". Departure time: "
					+ airplane.getDepartureTime() + ". Arrival time: " + airplane.getArrivalTime() + ". City from: "
					+ airplane.getCityFrom() + ". City to: " + airplane.getCityTo());
		}*/

	}

}
