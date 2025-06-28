package tests;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TaskPage;
import reuseableComponents.DB_Operations;
import reuseableComponents.ExcelOperations;
import testBase.ExtentFactory;
import testBase.TestBase;

public class TestCase extends TestBase {

	ExcelOperations excel = new ExcelOperations("TaskCreationData");
	
	
	
	
	@Test(dataProvider = "taskCreationData")
	public void TaskCreationTest(Object obj1) throws Throwable {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		ExtentFactory.getInstance().getExtent().info("Test Data for this execution run is: "+ testData);
		
		LoginPage loginpage = new LoginPage();
		HomePage homepage = new HomePage();
		TaskPage taskpage = new TaskPage();
		DB_Operations dbOps = new DB_Operations();
		
		loginpage.login(testData.get("UserName"), testData.get("Password"));

		homepage.checkIfDashBoardPageIsOpened();
		homepage.clickOnSideSubMenu("Tasks", "Add Task");
		taskpage.createTask(testData);
		taskpage.Search_Verify_TaskCreationOnUI(testData);
		
		//verify DB
		String sql = "SELECT * FROM `tasks` where name = '"+testData.get("TaskName")+"'";		
		HashMap<String, String> dbData = dbOps.getSqlResultInMap(sql);
		String TaskName = dbData.get("name");
		assertEqualsString_custom(testData.get("TaskName"), TaskName, "DB_Task_Name");
	
	}
	
	
	
	
	
	//Dataprovider method --> return object array
	@DataProvider (name = "taskCreationData" , parallel = true)
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
		
	}
	
//	@Test
//	public void tc2() {
//	
//	}
//	
//	@Test
//	public void tc3() {
//		
//	}
//	
	
	
	
	

	

	

}
