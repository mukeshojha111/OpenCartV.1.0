package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String path = ".//testData//LoginTestData.xlsx"; // taking xls file from testData folder

		ExcelUtility xlUtil = new ExcelUtility(path); // creating an object for XLUtility

		int totalrows = xlUtil.getRowCount("Sheet1");
		int totalcols = xlUtil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				logindata[i-1][j] = xlUtil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;

	}

}
