package vaccination_analysis.parsing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.*;
import jxl.read.biff.BiffException;
import vaccination_analysis.models.ExcelExport;

public class ExcelReader {

	private final String YES_STRING = "y";
	private List<ExcelExport> excelExports = new ArrayList<ExcelExport>();

	public List<ExcelExport> readFile(String filename) {

		if (!filename.endsWith(".xls") || !filename.endsWith(".xlsx")) {
			filename += ".xls";
		}

		try {
			Workbook workbook = Workbook.getWorkbook(new File(
					"src/main/resources/TwittererTextFiles/" + filename));
			Sheet sheet = workbook.getSheet(0);

			int amount_columns = sheet.getColumns();
			int amount_rows = sheet.getRows();

			System.out.println("first row:");
			for (int i = 0; i <= amount_columns; i++) {
				System.out.println(sheet.getCell(i, 0).getContents());
			}

			// create ExcelExport-Files
			for (int i = 1; i <= amount_rows; i++) {

				long id = Long.parseLong(sheet.getCell(0, i).getContents());
				String username = sheet.getCell(1, i).getContents();
				boolean isAntivaxxer = sheet.getCell(2, i).getContents()
						.equals(YES_STRING);
				int amountOfFriends = Integer.parseInt(sheet.getCell(3, i)
						.getContents());
				int amountOfFollowers = Integer.parseInt(sheet.getCell(4, i)
						.getContents());
				long meanNumberOfMentions = Long.parseLong(sheet.getCell(5, i)
						.getContents());
				long meanNumberOfHashstags = Long.parseLong(sheet.getCell(6, i)
						.getContents());
				long meanNumberOfHtmls = Long.parseLong(sheet.getCell(7, i)
						.getContents());
				int meanTextLength = Integer.parseInt(sheet.getCell(8, i)
						.getContents());
				int messagesPosted = Integer.parseInt(sheet.getCell(9, i)
						.getContents());
				int messagesFavorited = Integer.parseInt(sheet.getCell(10, i)
						.getContents());
				int daysOnTwitter = Integer.parseInt(sheet.getCell(11, i)
						.getContents());
				long frequency_I = Long.parseLong(sheet.getCell(12, i)
						.getContents());
				long frequency_The = Long.parseLong(sheet.getCell(13, i)
						.getContents());
				long frequency_And = Long.parseLong(sheet.getCell(14, i)
						.getContents());
				long frequency_To = Long.parseLong(sheet.getCell(15, i)
						.getContents());
				long frequency_A = Long.parseLong(sheet.getCell(16, i)
						.getContents());
				long frequency_Of = Long.parseLong(sheet.getCell(17, i)
						.getContents());
				long frequency_That = Long.parseLong(sheet.getCell(18, i)
						.getContents());
				long frequency_In = Long.parseLong(sheet.getCell(19, i)
						.getContents());
				long frequency_It = Long.parseLong(sheet.getCell(20, i)
						.getContents());
				long frequency_My = Long.parseLong(sheet.getCell(21, i)
						.getContents());
				long frequency_Is = Long.parseLong(sheet.getCell(22, i)
						.getContents());
				long frequency_You = Long.parseLong(sheet.getCell(23, i)
						.getContents());
				long frequency_Was = Long.parseLong(sheet.getCell(24, i)
						.getContents());
				long frequency_For = Long.parseLong(sheet.getCell(25, i)
						.getContents());
				long frequency_Have = Long.parseLong(sheet.getCell(26, i)
						.getContents());
				long frequency_With = Long.parseLong(sheet.getCell(27, i)
						.getContents());
				long frequency_He = Long.parseLong(sheet.getCell(28, i)
						.getContents());
				long frequency_Me = Long.parseLong(sheet.getCell(29, i)
						.getContents());
				long frequency_On = Long.parseLong(sheet.getCell(30, i)
						.getContents());
				long frequency_But = Long.parseLong(sheet.getCell(31, i)
						.getContents());

				ExcelExport e = new ExcelExport(id, username, isAntivaxxer,
						amountOfFriends, amountOfFollowers,
						meanNumberOfMentions, meanNumberOfHashstags,
						meanNumberOfHtmls, meanTextLength, messagesPosted,
						daysOnTwitter, messagesFavorited);
				e.setFrequency_A(frequency_A);
				e.setFrequency_And(frequency_And);
				e.setFrequency_But(frequency_But);
				e.setFrequency_For(frequency_For);
				e.setFrequency_Have(frequency_Have);
				e.setFrequency_He(frequency_He);
				e.setFrequency_I(frequency_I);
				e.setFrequency_In(frequency_In);
				e.setFrequency_Is(frequency_Is);
				e.setFrequency_It(frequency_It);
				e.setFrequency_Me(frequency_Me);
				e.setFrequency_My(frequency_My);
				e.setFrequency_Of(frequency_Of);
				e.setFrequency_On(frequency_On);
				e.setFrequency_That(frequency_That);
				e.setFrequency_The(frequency_The);
				e.setFrequency_To(frequency_To);
				e.setFrequency_Was(frequency_Was);
				e.setFrequency_With(frequency_With);
				e.setFrequency_You(frequency_You);
				excelExports.add(e);
				System.out.println("read username " + e.getUsername());
			}
			workbook.close();
			return excelExports;
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return excelExports;

	}

	public List<Long> getIDsFromFile(File file) {
		List<Long> result = new ArrayList<Long>();
		try {
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int amount_rows = sheet.getRows();
			for (int i = 1; i <= amount_rows-1; i++) {
				Long id = Long.parseLong(sheet.getCell(1, i).getContents());
				System.out.println("ID is " + id);
				result.add(id);
			} 
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return result;
}
}
