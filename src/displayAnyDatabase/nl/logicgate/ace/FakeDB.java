package displayAnyDatabase.nl.logicgate.ace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDB implements DB {
	
	//variables here
	
	//TODO populate with fake data
	public FakeDB(){}
	
	//get list of tablenames
	public List<String> getTableNames(){
		List<String> names = new ArrayList<String>();
		names.add("mmse");
		return names;
	}
	
	//get the names of the columns for a table
		public List<String> getColNames(String tablename){
			List<String> colNames = new ArrayList<String>();
			colNames.add("patientID");
			colNames.add("datetime");
			colNames.add("mmseItem1");
			colNames.add("mmseItem2");
			colNames.add("mmseItem3");
			colNames.add("mmseTotal");
			return colNames;
		}
		
	//get all data in table for patient (parameter tablename, patientnr)
	public List<Map<String, Object>> getPatientData(String tablename, int patientNr){
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		Map<String,Object> row = new HashMap<String,Object>();
		row.put("patientID", 1);
		row.put("datetime", "2018-01-30 19:44");
		row.put("mmseItem1", "2018");
		row.put("mmseItem2", "winter");
		row.put("mmseItem3", "january");
		row.put("mmseTotal", 3);
		rows.add(row);
		return rows;
	}

}
