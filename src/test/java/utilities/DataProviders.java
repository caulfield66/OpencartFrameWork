package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException {
        String path = "/Users/ruslan/Desktop/Selenium/FirstFramework/testData/testData.xlsx";
        ExcelUtility exutil = new ExcelUtility(path);
        int totalRows = exutil.getRowCount("Sheet1");
        int totalCells = exutil.getCellCount("Sheet1", 1);

        String loginData[][] = new String[totalRows][totalCells];

        for(int i = 1; i<=totalRows; i++){
            for(int j = 0; j < totalCells; j++){
                loginData[i-1][j] = exutil.getCellData("Sheet1",i,j);
            }
        }
        return loginData;
     }
}
