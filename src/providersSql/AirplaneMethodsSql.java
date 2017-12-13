package providersSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

import interfaces.IAirplaneMethods;
import models.Airplane;

public class AirplaneMethodsSql implements IAirplaneMethods {
	private static GenericProviderSql<Airplane> genericProvider;

	public AirplaneMethodsSql() {
		try {
			genericProvider = new GenericProviderSql<Airplane>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Airplane mappingResult(ResultSet result) throws SQLException {
		Airplane airplane = new Airplane();
		try {
			while (result.next()) {
				airplane.setId(result.getInt(1));
				airplane.setCompanyName(result.getString(2));
				airplane.setDepartureTime(LocalTime.parse(result.getString(3)));
				airplane.setArrivalTime(LocalTime.parse(result.getString(4)));
				airplane.setCityFrom(result.getString(5));
				airplane.setCityTo(result.getString(6));
			}
		} finally {
			if (result != null) {
				result.close();
			}
		}
		return airplane;

	}

	private static ArrayList<Airplane> mappingListResult(ResultSet result) throws SQLException {
		ArrayList<Airplane> list = new ArrayList<Airplane>();
		Airplane airplane = new Airplane();
		try {
			while (result.next()) {
				airplane.setId(result.getInt(1));
				airplane.setCompanyName(result.getString(2));
				airplane.setDepartureTime(LocalTime.parse(result.getString(3)));
				airplane.setArrivalTime(LocalTime.parse(result.getString(4)));
				airplane.setCityFrom(result.getString(5));
				airplane.setCityTo(result.getString(6));
				list.add(new Airplane(airplane.getId(), airplane.getCompaneName(), airplane.getDepartureTime(),
						airplane.getArrivalTime(), airplane.getCityFrom(), airplane.getCityTo()));
			}
		} finally {
			if (result != null) {
				result.close();
			}
		}
		return list;

	}

	@Override
	public void createAirplane(Airplane airplane) {
		try {
			genericProvider.execute("call CreateAirplane",
					new Object[] { airplane.getCompaneName(), airplane.getDepartureTime(), airplane.getArrivalTime(),
							airplane.getCityFrom(), airplane.getCityTo() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void editAirplane(Airplane airplane) {
		try {
			genericProvider.execute("call EditAirplane",
					new Object[] { airplane.getId(), airplane.getCompaneName(), airplane.getDepartureTime(),
							airplane.getArrivalTime(), airplane.getCityFrom(), airplane.getCityTo() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAirplane(int idAirplane) {
		try {
			genericProvider.execute("call DeleteAirplane", new Object[] { idAirplane });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Airplane getAirplaneById(int idAirplane) {
		Airplane airplane = new Airplane();
		try {
			airplane = mappingResult(genericProvider.getList("call GetAirplaneById", new Object[] { idAirplane }));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplane;
	}

	@Override
	public ArrayList<Airplane> getAllAirplane() {
		ArrayList<Airplane> airplane = new ArrayList<Airplane>();
		try {
			airplane = mappingListResult(genericProvider.getList("call GetAllAirplane", new Object[] {}));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplane;
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCityFrom(String cityFrom) {
		ArrayList<Airplane> airplane = new ArrayList<Airplane>();
		try {
			airplane = mappingListResult(genericProvider.getList("call GetAirplaneByCityFrom", new Object[] { cityFrom }));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplane;
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCityTo(String cityTo) {
		ArrayList<Airplane> airplane = new ArrayList<Airplane>();
		try {
			airplane = mappingListResult(genericProvider.getList("call GetAirplaneByCityTo", new Object[] { cityTo }));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplane;
	}

	@Override
	public ArrayList<Airplane> getAirplaneByCompane(String company) {
		ArrayList<Airplane> airplane = new ArrayList<Airplane>();
		try {
			airplane = mappingListResult(genericProvider.getList("call GetAirplaneByCompany", new Object[] { company }));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplane;
	}

}
