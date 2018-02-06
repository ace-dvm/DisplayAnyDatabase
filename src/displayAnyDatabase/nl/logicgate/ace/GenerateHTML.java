package displayAnyDatabase.nl.logicgate.ace;

import java.util.List;
import java.util.Map;

public class GenerateHTML {
/*
 * list of tableNames
for each tableName, a list of fields
for each field, a list of values
 */
	private DB db;
	private List<String> tableNames;
	private int patientNr;
	
	public GenerateHTML(int patientNr){
		this.patientNr = patientNr;
		db = new FakeDB();
		tableNames = db.getTableNames();
		makePage();
	}
	
	//TODO make a main class, so we can run it
	private void makePage(){
		String html = "<!DOCTYPE HTML PUBLIC \"//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
				+ "<html xml:lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\"><head>\n"
				+ "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n\n"
				+ "<title>Other</title>\n"
				+ "<meta name=\"Author\" content=\"Ace's AI equivalent\">\n"
				+ "<meta name=\"Description\" content=\"arbitrary patient data\">\n\n"
				+ "<style>\n</style>\n\n</head>"
				+ "<body>\n";
		for(String tableName:tableNames){
			html+="<h2>"+tableName+"</h2>\n<table>";
			List<String> fieldNames = db.getColNames(tableName);
			for(String fieldName:fieldNames){
				html+="<th>"+fieldName+"</th>";
			}
			html+="\n";
			List<Map<String, Object>> tableData = db.getPatientData(tableName, patientNr);
			for(Map<String, Object> row:tableData){
				html+="<tr>";
				for(String fieldName:fieldNames){
					Object o = row.get(fieldName);
					String oString = "";
					if(o==null){
						oString = "NULL";
					} else {			
						oString = o.toString().trim();
					}
					html+="<td>"+oString+"</td>";
				}
				html+="</td>\n";
			}
			html+="</table>";
		}
		html+="</body></html>";
	System.out.println(html);
	}
	
	
}
