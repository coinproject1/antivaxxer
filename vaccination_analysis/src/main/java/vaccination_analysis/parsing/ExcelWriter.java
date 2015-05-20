package vaccination_analysis.parsing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import vaccination_analysis.models.ExcelExport;

public class ExcelWriter {

	private final String YES_STRING = "y";
	private final String NO_STRING = "n";
	private final String FILES_FOLDER = "src/main/resources/TwittererTextFiles/";

	public void writeFile(String filename, List<ExcelExport> list) {

		if (filename == null || list == null || list.size() == 0)

			if (!filename.endsWith(".xls") || !filename.endsWith(".xlsx")) {
				filename += ".xls";
			}

		try {
			File file = new File(FILES_FOLDER
					+ filename);
			// check if file already exists
			if (file.exists() && !file.isDirectory()) {
				System.out
						.println(filename
								+ "already exists in "+FILES_FOLDER);
				// write into an existing file
				System.out.println("writeIntoExistingFile called");
				writeIntoExistingFile(file, list);

			} else {
				// write into a new file
				System.out.println("writeIntoNewFile called");
				writeIntoNewFile(file, list);
			}
		} catch (Exception e) {

		}
	}

	private void writeIntoNewFile(File file, List<ExcelExport> list)
			throws RowsExceededException, WriteException, IOException {

		WritableWorkbook workbook = Workbook.createWorkbook(file);
		WritableSheet sheet = workbook.createSheet("Vaccination Analysis", 0);

		// create first row
		{
			for (int i = 0; i <= firstRow.length; i++) {
				sheet.addCell(new Label(0, i, firstRow[i]));
			}

		}
		int current_row = 1;
		// create rows for twitterers
		for (ExcelExport e : list) {
			sheet.addCell(new Label(current_row, 0, String.valueOf(e
					.getUsername())));
			sheet.addCell(new Label(current_row, 1, String.valueOf(e.getId())));
			sheet.addCell(new Label(current_row, 2,
					(e.isAntivaxxer() ? YES_STRING : NO_STRING)));
			sheet.addCell(new Label(current_row, 3, String.valueOf(e
					.getAmountOfFriends())));
			sheet.addCell(new Label(current_row, 4, String.valueOf(e
					.getAmountOfFollowers())));
			sheet.addCell(new Label(current_row, 5, String.valueOf(e
					.getMeanNumberOfMentions())));
			sheet.addCell(new Label(current_row, 6, String.valueOf(e
					.getMeanNumberOfHashstags())));
			sheet.addCell(new Label(current_row, 7, String.valueOf(e
					.getMeanNumberOfHtmls())));
			sheet.addCell(new Label(current_row, 8, String.valueOf(e
					.getMeanTextLength())));
			sheet.addCell(new Label(current_row, 9, String.valueOf(e
					.getMessagesPosted())));
			sheet.addCell(new Label(current_row, 10, String.valueOf(e
					.getMessagesFavorited())));
			sheet.addCell(new Label(current_row, 11, String.valueOf(e
					.getDaysOnTwitter())));
			sheet.addCell(new Label(current_row, 12, String.valueOf(e
					.getFrequency_I())));
			sheet.addCell(new Label(current_row, 13, String.valueOf(e
					.getFrequency_The())));
			sheet.addCell(new Label(current_row, 14, String.valueOf(e
					.getFrequency_And())));
			sheet.addCell(new Label(current_row, 15, String.valueOf(e
					.getFrequency_To())));
			sheet.addCell(new Label(current_row, 16, String.valueOf(e
					.getFrequency_A())));
			sheet.addCell(new Label(current_row, 17, String.valueOf(e
					.getFrequency_Of())));
			sheet.addCell(new Label(current_row, 18, String.valueOf(e
					.getFrequency_That())));
			sheet.addCell(new Label(current_row, 19, String.valueOf(e
					.getFrequency_In())));
			sheet.addCell(new Label(current_row, 20, String.valueOf(e
					.getFrequency_It())));
			sheet.addCell(new Label(current_row, 21, String.valueOf(e
					.getFrequency_My())));
			sheet.addCell(new Label(current_row, 22, String.valueOf(e
					.getFrequency_Is())));
			sheet.addCell(new Label(current_row, 23, String.valueOf(e
					.getFrequency_You())));
			sheet.addCell(new Label(current_row, 24, String.valueOf(e
					.getFrequency_Was())));
			sheet.addCell(new Label(current_row, 25, String.valueOf(e
					.getFrequency_For())));
			sheet.addCell(new Label(current_row, 26, String.valueOf(e
					.getFrequency_Have())));
			sheet.addCell(new Label(current_row, 27, String.valueOf(e
					.getFrequency_With())));
			sheet.addCell(new Label(current_row, 28, String.valueOf(e
					.getFrequency_He())));
			sheet.addCell(new Label(current_row, 29, String.valueOf(e
					.getFrequency_Me())));
			sheet.addCell(new Label(current_row, 30, String.valueOf(e
					.getFrequency_On())));
			sheet.addCell(new Label(current_row, 31, String.valueOf(e
					.getFrequency_But())));
			current_row++;
			workbook.write();
			workbook.close();
		}

	}

	private void writeIntoExistingFile(File file, List<ExcelExport> list) throws BiffException, IOException, RowsExceededException, WriteException {
		// remove doublets from list
		list = removeDoublets(list, file);
		// begin with current row
		int current_row = list.size();
		
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook copy = Workbook.createWorkbook(new File(FILES_FOLDER+"temp.xls"), workbook);
		WritableSheet sheet = copy.getSheet(0);
		
		for (ExcelExport e : list) {
			sheet.addCell(new Label(current_row, 0, String.valueOf(e
					.getUsername())));
			sheet.addCell(new Label(current_row, 1, String.valueOf(e.getId())));
			sheet.addCell(new Label(current_row, 2,
					(e.isAntivaxxer() ? YES_STRING : NO_STRING)));
			sheet.addCell(new Label(current_row, 3, String.valueOf(e
					.getAmountOfFriends())));
			sheet.addCell(new Label(current_row, 4, String.valueOf(e
					.getAmountOfFollowers())));
			sheet.addCell(new Label(current_row, 5, String.valueOf(e
					.getMeanNumberOfMentions())));
			sheet.addCell(new Label(current_row, 6, String.valueOf(e
					.getMeanNumberOfHashstags())));
			sheet.addCell(new Label(current_row, 7, String.valueOf(e
					.getMeanNumberOfHtmls())));
			sheet.addCell(new Label(current_row, 8, String.valueOf(e
					.getMeanTextLength())));
			sheet.addCell(new Label(current_row, 9, String.valueOf(e
					.getMessagesPosted())));
			sheet.addCell(new Label(current_row, 10, String.valueOf(e
					.getMessagesFavorited())));
			sheet.addCell(new Label(current_row, 11, String.valueOf(e
					.getDaysOnTwitter())));
			sheet.addCell(new Label(current_row, 12, String.valueOf(e
					.getFrequency_I())));
			sheet.addCell(new Label(current_row, 13, String.valueOf(e
					.getFrequency_The())));
			sheet.addCell(new Label(current_row, 14, String.valueOf(e
					.getFrequency_And())));
			sheet.addCell(new Label(current_row, 15, String.valueOf(e
					.getFrequency_To())));
			sheet.addCell(new Label(current_row, 16, String.valueOf(e
					.getFrequency_A())));
			sheet.addCell(new Label(current_row, 17, String.valueOf(e
					.getFrequency_Of())));
			sheet.addCell(new Label(current_row, 18, String.valueOf(e
					.getFrequency_That())));
			sheet.addCell(new Label(current_row, 19, String.valueOf(e
					.getFrequency_In())));
			sheet.addCell(new Label(current_row, 20, String.valueOf(e
					.getFrequency_It())));
			sheet.addCell(new Label(current_row, 21, String.valueOf(e
					.getFrequency_My())));
			sheet.addCell(new Label(current_row, 22, String.valueOf(e
					.getFrequency_Is())));
			sheet.addCell(new Label(current_row, 23, String.valueOf(e
					.getFrequency_You())));
			sheet.addCell(new Label(current_row, 24, String.valueOf(e
					.getFrequency_Was())));
			sheet.addCell(new Label(current_row, 25, String.valueOf(e
					.getFrequency_For())));
			sheet.addCell(new Label(current_row, 26, String.valueOf(e
					.getFrequency_Have())));
			sheet.addCell(new Label(current_row, 27, String.valueOf(e
					.getFrequency_With())));
			sheet.addCell(new Label(current_row, 28, String.valueOf(e
					.getFrequency_He())));
			sheet.addCell(new Label(current_row, 29, String.valueOf(e
					.getFrequency_Me())));
			sheet.addCell(new Label(current_row, 30, String.valueOf(e
					.getFrequency_On())));
			sheet.addCell(new Label(current_row, 31, String.valueOf(e
					.getFrequency_But())));
			current_row++;
		}
		copy.write(); 
		copy.close();
		
	}

	private List<ExcelExport> removeDoublets(List<ExcelExport> list, File file) {

		ExcelReader excelReader = new ExcelReader();
		List<Long> userIDs = excelReader.getIDsFromFile(file);

		for (ExcelExport e : list) {
			for (Long userID : userIDs) {
				if (e.getId() == userID) {
					list.remove(e);
				}
			}
		}
		return list;
	}

	private final String[] firstRow = new String[] { "USERNAME", "ID",
			"isAntivaxxer", "amountOfFriends", "amountOfFollowers",
			"meanNumberOfMentions", "meanNumberOfHashtags",
			"meanNumberOfHtmls", "meanTextLength", "messagesPosted",
			"messagesFavorited", "daysOnTwitter", "Frequency_I",
			"Frequency_The", "Frequency_And", "Frequency_To", "Frequency_A",
			"Frequency_Of", "Frequency_That", "Frequency_In", "Frequency_It",
			"Frequency_My", "Frequency_Is", "Frequency_You", "Frequency_Was",
			"Frequency_For", "Frequency_Have", "Frequency_With",
			"Frequency_He", "Frequency_Me", "Frequency_On", "Frequency_But", };
}
