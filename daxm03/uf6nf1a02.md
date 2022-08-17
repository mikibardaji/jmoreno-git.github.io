### Relació entre vols i passatgers

Per implementar la relació mxn entre vols i passatgers crearem una
classe amb les claus foranes que mapegen la taula de la relació.

``` java
/**
 * Transport persistence class for flight-passenger mxn relationship.
 * @author ProvenSoft
 */
public class FlightPassenger {
    private long flightId;
    private long passengerId;

    public FlightPassenger(long flightId, long passengerId) {
        this.flightId = flightId;
        this.passengerId = passengerId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.flightId ^ (this.flightId >>> 32));
        hash = 37 * hash + (int) (this.passengerId ^ (this.passengerId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FlightPassenger other = (FlightPassenger) obj;
        if (this.flightId != other.flightId) {
            return false;
        }
        if (this.passengerId != other.passengerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlightPassenger{flightId=").append(flightId);
        sb.append(", passengerId=").append(passengerId);
        sb.append('}');
        return sb.toString();
    }
    
}
```

I per a la persistència de la relació, crearem la classe
*FlightPassengerDao*.

``` java
/**
 * DAO for flight-passsenger relationship persistence.
 * @author ProvenSoft
 */
public class FlightPassengerDao {
    protected final Map<String, String> queries;
    protected final DbConnect dbConnect;
    private final String TABLE_NAME;

    public FlightPassengerDao() throws ClassNotFoundException {
        this.TABLE_NAME = "flightpassenger";
        this.dbConnect = DbConnect.getInstance();
        this.queries = new HashMap<>();
        initQueries();
    }    

    /**
     * converts resultset entry to entity object.
     * @param rs resultset to get data from.
     * @return object with data in current position of resultset.
     */
    private FlightPassenger fromResultSet(ResultSet rs) throws SQLException {
        FlightPassenger p = null;
        long flightId = rs.getLong("flight_id");
        long passengerId = rs.getLong("passenger_id");
        p = new FlightPassenger(flightId, passengerId);
        return p;
    }
    
    /**
     * selects all entities from database.
     * @return list of entities of null in case of error.
     */
    public List<FlightPassenger> selectAll() {
        List<FlightPassenger> result = new ArrayList<>();
        try {
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                String query = queries.get("sAll");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    FlightPassenger obj = fromResultSet(rs);
                    if (obj != null) {
                        result.add(obj);
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }
     
    /**
     * inserts a flightpassenger in database.
     * @param flightpassenger the flightpassenger to insert.
     * @return number of rows affected.
     */
    public int insert(FlightPassenger flightpassenger) {
        int result = 0;
        try {
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                String query = queries.get("insert");
                PreparedStatement st = conn.prepareStatement(query);
                st.setLong(1, flightpassenger.getFlightId());
                st.setLong(2, flightpassenger.getPassengerId());
                result = st.executeUpdate();
            }
        } catch (SQLException ex) {
            result = -1;
        }        
        return result;
    }
    
    public List<FlightPassenger> selectWhereFlightId(long id) {
        List<FlightPassenger> result = new ArrayList<>();
        try {
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                String query = queries.get("sWhereFlightId");
                PreparedStatement st = conn.prepareStatement(query);
                st.setLong(1, id);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    FlightPassenger obj = fromResultSet(rs);
                    if (obj != null) {
                        result.add(obj);
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }

    public List<FlightPassenger> selectWherePassengerId(long id) {
        List<FlightPassenger> result = new ArrayList<>();
        try {
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                String query = queries.get("sWherePassengerId");
                PreparedStatement st = conn.prepareStatement(query);
                st.setLong(1, id);
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    FlightPassenger obj = fromResultSet(rs);
                    if (obj != null) {
                        result.add(obj);
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }
    
    private void initQueries() {
        queries.put("sAll", String.format("select * from %s", TABLE_NAME));
        queries.put("insert", String.format("insert into %s values (?, ?)", TABLE_NAME));
        queries.put("sWhereFlightId", String.format("select * from %s where flight_id = ?", TABLE_NAME));
        queries.put("sWherePassengerId", String.format("select * from %s where passenger_id = ?", TABLE_NAME));
    }
}
```

Per fer les consultes creuades, crearem al Model mètodes que utilizin
les classes anteriors.

``` java
    /**
     * search passengers in given flight.
     * @param flight the flight to search passengers in.
     * @return list of passengers or null in case of error.
     */
    public List<Passenger> searchPassengersByFlight(Flight flight) {
        List<Passenger> result = new ArrayList<>();
        List<FlightPassenger> flightpassengerList = flightpassengerDao.selectWhereFlightId(flight.getId());
        if (flightpassengerList != null) {
            for (FlightPassenger fp: flightpassengerList) {
                Passenger p = passengerDao.selectWhereId(fp.getPassengerId());
                if (p != null) {
                    result.add(p);
                }
            }            
        }
        return result;
    }
```

Exercici: A partir del codi mostrat, cal completar les consultes que
falten.
