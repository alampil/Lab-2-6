package providersSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.IAirportMethods;
import models.Airport;

public class AirportMethodsSql implements IAirportMethods {
	private static GenericProviderSql<Airport> genericProvider;
	private static AirplaneMethodsSql airplaneMethods;

	public AirportMethodsSql() {
		try {
			airplaneMethods = new AirplaneMethodsSql();
			genericProvider = new GenericProviderSql<Airport>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Airport mappingResult(ResultSet result) throws SQLException {
		Airport airport = new Airport();
		try {
			while (result.next()) {
				airport.setId(result.getInt(1));
				airport.setName(result.getString(2));
				airport.setAirplane(airplaneMethods.getAirplaneById(result.getInt(3)));
			}
		} finally {
			if (result != null) {
				result.close();
			}
		}
		return airport;

	}

	private static ArrayList<Airport> mappingListResult(ResultSet result) throws SQLException {
		ArrayList<Airport> list = new ArrayList<Airport>();
		Airport airport = new Airport();
		try {
			while (result.next()) {
				airport.setId(result.getInt(1));
				airport.setName(result.getString(2));
				airport.setAirplane(airplaneMethods.getAirplaneById(result.getInt(3)));
				list.add(new Airport(airport.getId(), airport.getName(), airport.getAirplane()));
			}
		} finally {
			if (result != null) {
				result.close();
			}
		}
		return list;

	}

	@Override
	public void createAirport(Airport airport) {
		try {
			genericProvider.execute("call CreateAirport", new Object[] { airport.getName(), airport.getAirplane() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void editAirport(Airport airport) {
		try {
			genericProvider.execute("call EditAirport",
					new Object[] { airport.getId(), airport.getName(), airport.getAirplane() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAirport(int idAirport) {
		try {
			genericProvider.execute("call DeleteAirport", new Object[] { idAirport });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Airport getAirportById(int idAirport) {
		Airport airport = new Airport();
		try {
			airport = mappingResult(genericProvider.getList("call GetAirportById", new Object[] { idAirport }));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airport;
	}

	@Override
	public ArrayList<Airport> getAllAirport() {
		ArrayList<Airport> airport = new ArrayList<Airport>();
		try {
			airport = mappingListResult(genericProvider.getList("call GetAllAirport", new Object[] {}));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airport;
	}

}
