package vaccination_analysis.parsing;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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

		System.out.println("filename is " + filename);

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
			e.printStackTrace();
		}
	}

	private void writeIntoNewFile(File file, List<ExcelExport> list)
			throws RowsExceededException, WriteException, IOException {

		WritableWorkbook workbook = Workbook.createWorkbook(file);
		WritableSheet sheet = workbook.createSheet("Vaccination Analysis", 0);

		// create first row
		{
			for (int i = 0; i <= firstRow.length-1; i++) {
				sheet.addCell(new Label(i, 0, firstRow[i]));
			}

		}
		int current_row = 1;
		// create rows for twitterers
		for (ExcelExport e : list) {
			sheet.addCell(new Label(0, current_row, String.valueOf(e
					.getUsername())));
			sheet.addCell(new Label(1, current_row, String.valueOf(e.getId())));
			sheet.addCell(new Label(2, current_row,
					(e.isAntivaxxer() ? YES_STRING : NO_STRING)));
			sheet.addCell(new Label(3, current_row, String.valueOf(e
					.getAmountOfFriends())));
			sheet.addCell(new Label(4, current_row, String.valueOf(e
					.getAmountOfFollowers())));
			sheet.addCell(new Label(5, current_row, String.valueOf(e
					.getMeanNumberOfMentions())));
			sheet.addCell(new Label(6, current_row, String.valueOf(e
					.getMeanNumberOfHashstags())));
			sheet.addCell(new Label(7, current_row, String.valueOf(e
					.getMeanNumberOfHtmls())));
			sheet.addCell(new Label(8, current_row, String.valueOf(e
					.getMeanTextLength())));
			sheet.addCell(new Label(9, current_row, String.valueOf(e
					.getMessagesPosted())));
			sheet.addCell(new Label(10, current_row, String.valueOf(e
					.getMessagesFavorited())));
			sheet.addCell(new Label(11, current_row, String.valueOf(e
					.getDaysOnTwitter())));
			sheet.addCell(new Label(12, current_row, String.valueOf(e
					.getFrequency_I())));
			sheet.addCell(new Label(13, current_row, String.valueOf(e
					.getFrequency_The())));
			sheet.addCell(new Label(14, current_row, String.valueOf(e
					.getFrequency_And())));
			sheet.addCell(new Label(15, current_row, String.valueOf(e
					.getFrequency_To())));
			sheet.addCell(new Label(16, current_row, String.valueOf(e
					.getFrequency_A())));
			sheet.addCell(new Label(17, current_row, String.valueOf(e
					.getFrequency_Of())));
			sheet.addCell(new Label(18, current_row, String.valueOf(e
					.getFrequency_That())));
			sheet.addCell(new Label(19, current_row, String.valueOf(e
					.getFrequency_In())));
			sheet.addCell(new Label(20, current_row, String.valueOf(e
					.getFrequency_It())));
			sheet.addCell(new Label(21, current_row, String.valueOf(e
					.getFrequency_My())));
			sheet.addCell(new Label(22, current_row, String.valueOf(e
					.getFrequency_Is())));
			sheet.addCell(new Label(23, current_row, String.valueOf(e
					.getFrequency_You())));
			sheet.addCell(new Label(24, current_row, String.valueOf(e
					.getFrequency_Was())));
			sheet.addCell(new Label(25, current_row, String.valueOf(e
					.getFrequency_For())));
			sheet.addCell(new Label(26, current_row, String.valueOf(e
					.getFrequency_Have())));
			sheet.addCell(new Label(27, current_row, String.valueOf(e
					.getFrequency_With())));
			sheet.addCell(new Label(28, current_row, String.valueOf(e
					.getFrequency_He())));
			sheet.addCell(new Label(29, current_row, String.valueOf(e
					.getFrequency_Me())));
			sheet.addCell(new Label(30, current_row, String.valueOf(e
					.getFrequency_On())));
			sheet.addCell(new Label(31, current_row, String.valueOf(e
					.getFrequency_But())));
			current_row++;
		}
		workbook.write();
		workbook.close();
	}

	private void writeIntoExistingFile(File file, List<ExcelExport> list) throws BiffException, IOException, RowsExceededException, WriteException {
		// remove doublets from list
		
		list = removeDoublets(list, file);
		// begin with current row
		int current_row = list.size();
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook copy = Workbook.createWorkbook(new File(FILES_FOLDER+"temp"+ ".xls"), workbook);
		WritableSheet sheet = copy.getSheet(0);
		
		// create rows for twitterers
		for (ExcelExport e : list) {
			sheet.addCell(new Label(0, current_row, String.valueOf(e
					.getUsername())));
			sheet.addCell(new Label(1, current_row, String.valueOf(e.getId())));
			sheet.addCell(new Label(2, current_row,
					(e.isAntivaxxer() ? YES_STRING : NO_STRING)));
			sheet.addCell(new Label(3, current_row, String.valueOf(e
					.getAmountOfFriends())));
			sheet.addCell(new Label(4, current_row, String.valueOf(e
					.getAmountOfFollowers())));
			sheet.addCell(new Label(5, current_row, String.valueOf(e
					.getMeanNumberOfMentions())));
			sheet.addCell(new Label(6, current_row, String.valueOf(e
					.getMeanNumberOfHashstags())));
			sheet.addCell(new Label(7, current_row, String.valueOf(e
					.getMeanNumberOfHtmls())));
			sheet.addCell(new Label(8, current_row, String.valueOf(e
					.getMeanTextLength())));
			sheet.addCell(new Label(9, current_row, String.valueOf(e
					.getMessagesPosted())));
			sheet.addCell(new Label(10, current_row, String.valueOf(e
					.getMessagesFavorited())));
			sheet.addCell(new Label(11, current_row, String.valueOf(e
					.getDaysOnTwitter())));
			sheet.addCell(new Label(12, current_row, String.valueOf(e
					.getFrequency_I())));
			sheet.addCell(new Label(13, current_row, String.valueOf(e
					.getFrequency_The())));
			sheet.addCell(new Label(14, current_row, String.valueOf(e
					.getFrequency_And())));
			sheet.addCell(new Label(15, current_row, String.valueOf(e
					.getFrequency_To())));
			sheet.addCell(new Label(16, current_row, String.valueOf(e
					.getFrequency_A())));
			sheet.addCell(new Label(17, current_row, String.valueOf(e
					.getFrequency_Of())));
			sheet.addCell(new Label(18, current_row, String.valueOf(e
					.getFrequency_That())));
			sheet.addCell(new Label(19, current_row, String.valueOf(e
					.getFrequency_In())));
			sheet.addCell(new Label(20, current_row, String.valueOf(e
					.getFrequency_It())));
			sheet.addCell(new Label(21, current_row, String.valueOf(e
					.getFrequency_My())));
			sheet.addCell(new Label(22, current_row, String.valueOf(e
					.getFrequency_Is())));
			sheet.addCell(new Label(23, current_row, String.valueOf(e
					.getFrequency_You())));
			sheet.addCell(new Label(24, current_row, String.valueOf(e
					.getFrequency_Was())));
			sheet.addCell(new Label(25, current_row, String.valueOf(e
					.getFrequency_For())));
			sheet.addCell(new Label(26, current_row, String.valueOf(e
					.getFrequency_Have())));
			sheet.addCell(new Label(27, current_row, String.valueOf(e
					.getFrequency_With())));
			sheet.addCell(new Label(28, current_row, String.valueOf(e
					.getFrequency_He())));
			sheet.addCell(new Label(29, current_row, String.valueOf(e
					.getFrequency_Me())));
			sheet.addCell(new Label(30, current_row, String.valueOf(e
					.getFrequency_On())));
			sheet.addCell(new Label(31, current_row, String.valueOf(e
					.getFrequency_But())));
			current_row++;
		}
		copy.write();
		copy.close();
		
	}

	private List<ExcelExport> removeDoublets(List<ExcelExport> list, File file) {

		ExcelReader excelReader = new ExcelReader();
		List<Long> userIDs = excelReader.getIDsFromFile(file);
		Iterator<ExcelExport> it = list.iterator();
		while (it.hasNext()) {
			long id=it.next().getId();
		    if (userIDs.contains(id)) {
		        it.remove();
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
			"Frequency_He", "Frequency_Me", "Frequency_On", "Frequency_But"};
}
