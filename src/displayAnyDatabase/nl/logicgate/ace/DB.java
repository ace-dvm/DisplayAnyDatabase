package displayAnyDatabase.nl.logicgate.ace;

import java.util.List;
import java.util.Map;

public interface DB {
	
	public List<String> getTableNames();
	
	public List<String> getColNames(String tablename);
	
	public List<Map<String, Object>> getPatientData(String tablename, int patientNr);

}
