package vaccination_analysis.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vaccination_analysis.models.ExcelExport;
import vaccination_analysis.parsing.ExcelWriter;

public class ExcelWriterTest {

	private static ExcelWriter ew = new ExcelWriter();
	
	public static void main(String... aArguments) throws IOException {
		
		String filename = "test.xls";
		
		List<ExcelExport> list = new ArrayList<ExcelExport>();
		list.add(new ExcelExport(Long.parseLong("29122"), "tester", true, 22, 12, 2.90f, 
				1.09f, 1.09f, 200, 21, 
				41, 22));
		
		ew.writeFile(filename, list);
		
	}
}
