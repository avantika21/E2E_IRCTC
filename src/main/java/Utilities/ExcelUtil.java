package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public XSSFSheet ExcelWSheet;

	public XSSFWorkbook ExcelWBook;

	public XSSFCell Cell;

	public XSSFRow Row;

	public void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			FileInputStream ExcelFile = new FileInputStream(Path);

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	public String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			if (Cell.getCellType().name().equals("STRING")) {
				String textp = Cell.getStringCellValue();
				return textp;
			} else if (Cell.getCellType().name().equals("NUMERIC")) {
				// String text= String.valueOf(Cell.getNumericCellValue());
				// return text;
				DataFormatter dataFormatter = new DataFormatter();
				String value = dataFormatter.formatCellValue(Cell);
				return value;
			} else {
				return "";
			}

			// String CellData = Cell.getStringCellValue();

			// return CellData;

		} catch (Exception e) {

			return "";

		}

	}
	
	public int getRowCount() {
		int rowCount=0;
		try {
			rowCount=ExcelWSheet.getPhysicalNumberOfRows();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int getColumnCount() {
		int columnCount=0;
		try {
			columnCount=ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return columnCount;
	}

	public void setCellData(String Path, String Result,  int RowNum, int ColNum) throws Exception	{

			try{

  			Row  = ExcelWSheet.getRow(RowNum);

  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

  				FileOutputStream fileOut = new FileOutputStream(Path);

  				ExcelWBook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);

			}

		}

}