package testsss;

import basetests.BaseTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class Testing_Test extends BaseTest {
    @Test
    public void TestingTest(){
        var mainpage = homepage.login_predefined();
        Wait(15);
       mainpage.clickTableCell(2,1);
        System.out.println(mainpage.getDDLelements(mainpage.activityperiod_DDL));
        mainpage.selectDropDown(mainpage.activityperiod_DDL,"July");
        mainpage.selectDropDown(mainpage.type_DDL,"Credit");
        clickOn(mainpage.goButton);




    }

    public static void main(String[] args) throws Exception {
        String excelpath = "C:\\Users\\12378\\IdeaProjects\\AutomationPractice\\TestData\\TestData.xlsx";
        String filename= "TestData";
        String sheetname = "Tabelle1";
        File file = new File(excelpath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetname);
        System.out.println(sheet.getLastRowNum());

    }
}
