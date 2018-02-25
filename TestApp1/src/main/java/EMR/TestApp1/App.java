package EMR.TestApp1;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class App 
{
  @Test
  public void test1()
    throws IOException, InterruptedException
  {
    System.out.println("test1");
    
    String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("mac")) {
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
    } else {
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
    }
    ChromeDriver driver = new ChromeDriver();
    
    String usernamedb = accessfromfile(0, 1, 1);
    String passworddb = accessfromfile(0, 2, 1);
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    driver.get("https://am2sit.emrdeliverybody.com");
    String titleofpage = driver.getTitle();
    
    System.out.println(titleofpage);
    
    driver.findElement(By.id("ctl00_IdWelcome_ExplicitLogin")).click();
    
    String currenttitleofpage = driver.getTitle();
    
    System.out.println(currenttitleofpage);
    
    WebElement user = driver.findElement(By.name("user"));
    WebElement pass = driver.findElement(By.name("pass"));
    
    user.sendKeys(new CharSequence[] { usernamedb });
    pass.sendKeys(new CharSequence[] { passworddb });
    
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    driver.findElement(By.name("btnLogin")).click();
    
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    WebElement pin = driver.findElement(By.name("txtSMS"));
    pin.sendKeys(new CharSequence[] { "123456" });
    driver.findElement(By.name("btnSMS")).click();
    
    driver.findElementByXPath("/html/body/form/div[6]/div/div[3]/table/tbody/tr/td[1]/div/div/ul[2]/li[8]/div[1]/div").click();
    Thread.sleep(2000L);
    
    driver.findElementByXPath("/html/body/form/div[6]/div/div[3]/table/tbody/tr/td[1]/div/div/ul[2]/li[8]/ul/li[3]/div[1]/a").click();
    Thread.sleep(2000L);
    
    driver.findElementByXPath("/html/body/form/div[6]/div/div[3]/table/tbody/tr/td[2]/span/div[4]/div/div/table/tbody/tr/td/div/div/div/div[1]/div/div/div[2]/table/tbody/tr/td/table[1]/tbody/tr/td/a/span[2]").click();
    Thread.sleep(5000L);
    
    driver.switchTo().frame(2);
    
    Thread.sleep(2000L);
    
    driver.findElementById("Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField").sendKeys(new CharSequence[] { accessfromfile(1, 0, 2) });
    
    driver.findElementById("OpeningDeliveryYear_6f793ef2-d728-4a5b-a26a-74d3d1812788_$IntegerField").sendKeys(new CharSequence[] { accessfromfile(1, 1, 2) });
    
    Select dropdown = new Select(driver.findElementById("AuctionType_653c7f0a-f506-416b-94af-fd758ae6582d_$DropDownChoice"));
    dropdown.selectByVisibleText(accessfromfile(1, 2, 2));
    
    Select dropdownpv = new Select(driver.findElementById("AuctionPriceVariableType_61b4ce73-8fed-414c-bed8-ac3846241b35_$DropDownChoice"));
    dropdownpv.selectByVisibleText(accessfromfile(1, 3, 2));
    
    driver.findElementById("AuctionStartDate_c755ecca-2ae0-4029-a803-4f9d4c8a6059_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 4, 2) });
    
    driver.findElementById("AuctionEndDate_ec59e9f1-4981-4246-927b-352f09220f3f_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 5, 2) });
    
    driver.findElementById("PrequalificationOnOpeningDate_c13e1366-b6a9-47a3-a4f9-dfef5d3c30e0_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 6, 2) });
    
    driver.findElementById("PrequalificationOnClosingDate_81f27264-3611-4e01-945f-72f37daa81f8_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 7, 2) });
    
    driver.findElementById("ProductSelectioNOpenDateTime_5aff62bc-fbad-4bbc-9e75-e0f72b5abd2b_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 8, 2) });
    
    driver.findElementById("ProductSelectionCloseDateTime_6d5db127-5b7b-486f-ab4c-3913cc576c2b_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 9, 2) });
    
    driver.findElementById("PreqResultDatePQRD_a13a7088-8ba3-44e7-8498-688bc31445c1_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 10, 2) });
    
    driver.findElementById("RaisDispPreqDecDate_6a0dcf47-5d2e-4991-8a70-d4ed552d61d8_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 11, 2) });
    
    driver.findElementById("AuctionParamUpdateDate_c3790b6d-0656-4d16-9626-b5898775cc39_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 13, 2) });
    
    driver.findElementById("OptOutFixEndDate_20f85cae-db4b-4fd9-bcf4-7af8f95f83cc_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 14, 2) });
    
    driver.findElementById("PriceMakerTakerReqSD_a7964f59-f478-470a-9e7f-a5c05802b322_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 15, 2) });
    
    driver.findElementById("PriceMakerTakerFD_785ea9b9-3e61-4a2d-9021-93ac5903748b_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 16, 2) });
    
    driver.findElementById("PriceMakerStatusConfDate_a1448671-eed3-4c3e-aa5e-13a997d20664_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 17, 2) });
    
    driver.findElementById("ConfDSRBidCapSD_f877efea-7362-4817-ac0c-30f088ea21cb_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 18, 2) });
    
    driver.findElementById("ConfDSRBidCapED_b51dc757-49c4-4d20-962a-1da0cd13be96_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 19, 2) });
    
    driver.findElementById("ConfLengthSDNewBUR_e8e8b563-4912-439c-a724-e023006ed11c_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 20, 2) });
    
    driver.findElementById("ConfLengthEDNewBUR_0049c2dd-bc86-4d51-b46d-4f98814eb60c_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 21, 2) });
    
    driver.findElementById("ConfLengthSDPR_c85a9463-1aa3-471f-bd01-b175e56c00dd_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 22, 2) });
    
    driver.findElementById("ConfLengthEDPR_4c9fa979-95f9-493c-84aa-b6740819e5de_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 23, 2) });
    
    driver.findElementById("ConApprovedAppRD_c41ea80c-ca98-4911-a2d9-3d1ee3f86e47_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 24, 2) });
    
    driver.findElementById("PlanConsentRD_c24fe707-7fab-4aaa-bfe7-7bb22af06216_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 25, 2) });
    
    driver.findElementById("LastDSubmitCCPQRD_07712e5f-c505-4450-955c-b3ee7e9bdfa4_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 26, 2) });
    
    driver.findElementById("LastDSubmitPCFPQRD_1da36a30-ee69-47fb-b0dd-ad8d18580c60_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 27, 2) });
    
    driver.findElementById("AuctionRDayARD_f5f85108-28cb-49d0-8eaa-385e95facaa3_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 28, 2) });
    
    driver.findElementById("CapAgrNoticeCANRCRD_69a8f1de-61cb-4407-833f-83c7036fabbd_$DateTimeFieldDate").sendKeys(new CharSequence[] { accessfromfile(1, 29, 2) });
    
    driver.findElementById("TerminationFee1_798ccb03-b38e-498c-9872-041887be520e_$TextField").sendKeys(new CharSequence[] { accessfromfile(1, 30, 2) });
    
    driver.findElementById("TerminationFee2_7ea2fd4c-7caf-4c46-97d8-77a369d8b91c_$TextField").sendKeys(new CharSequence[] { accessfromfile(1, 31, 2) });
    
    driver.findElementById("TerminationFee3_115a90dc-5662-4e72-aae3-fe7613935c15_$TextField").sendKeys(new CharSequence[] { accessfromfile(1, 32, 2) });
    
    driver.findElementById("TerminationFee4_02f0bcc5-31bb-45ea-b88f-564bb3aaff82_$TextField").sendKeys(new CharSequence[] { accessfromfile(1, 33, 2) });
    
    driver.findElementById("TerminationFee5_df612756-c32c-4a58-9e6d-4dae392e3fc6_$TextField").sendKeys(new CharSequence[] { accessfromfile(1, 34, 2) });
    
    driver.findElementById("MonthlyPenaltyCap_a7b62b61-197e-4ee6-9d3c-5183b3e68aa1_$NumberField").sendKeys(new CharSequence[] { accessfromfile(1, 35, 2) });
    
    driver.findElementById("AnnualPenaltyCap_64921f24-23a9-4eac-a16c-88da57458c11_$NumberField").sendKeys(new CharSequence[] { accessfromfile(1, 36, 2) });
    
    driver.findElementById("BasePeriod_4b68d35c-b630-48fd-a2b7-c1b9ee2f0b48_$TextField").sendKeys(new CharSequence[] { accessfromfile(1, 55, 2) });
    
    Select dropdownstatus = new Select(driver.findElementById("Auction_List_StatusField_-1"));
    dropdownstatus.selectByVisibleText("Active");
    
    driver.switchTo().defaultContent();
    
    driver.findElementByXPath("/html/body/div[5]/div/div[2]/div/div/div/div[2]/input[1]").click();
    
    Thread.sleep(2000L);
    
    driver.switchTo().frame(2);
    
    driver.findElementByName("ctl00$ctl50$g_4fe664df_167b_4a3b_9df9_aeed3bb7ff2f$ctl00$toolBarTbl$RightRptControls$ctl00$ctl00$diidIOSaveItem").click();
  }
  
  @Test
  public void test6()
  {
    System.out.println("test6");
  }
  
  @Test
  public void test4()
  {
    System.out.println("test4");
  }
  
  @Test
  public void test3()
  {
    System.out.println("test3");
  }
  
  public void test5()
    throws InterruptedException, IOException
  {
    String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("mac")) {
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
    } else {
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
    }
    ChromeDriver driver = new ChromeDriver();
    
    driver = new ChromeDriver();
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    driver.get("https://am2sit.emrdeliverybody.com");
    String titleofpage = driver.getTitle();
    
    System.out.println(titleofpage);
    
    driver.findElement(By.id("ctl00_IdWelcome_ExplicitLogin")).click();
    
    String currenttitleofpage = driver.getTitle();
    
    System.out.println(currenttitleofpage);
    
    WebElement user = driver.findElement(By.name("user"));
    WebElement pass = driver.findElement(By.name("pass"));
    
    user.sendKeys(new CharSequence[] { "am1a.mainadmin" });
    pass.sendKeys(new CharSequence[] { "Passw01!" });
    
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    driver.findElement(By.name("btnLogin")).click();
    
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    WebElement pin = driver.findElement(By.name("txtSMS"));
    pin.sendKeys(new CharSequence[] { "123456" });
    driver.findElement(By.name("btnSMS")).click();
    
    Thread.sleep(2000L);
    
    driver.switchTo().frame("MSOPageViewerWebPart_WebPartWPQ2");
    Thread.sleep(2000L);
    driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[1]/a")).click();
    
    driver.manage().timeouts().implicitlyWait(2000L, TimeUnit.MILLISECONDS);
    driver.manage().timeouts().pageLoadTimeout(40L, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(60L, TimeUnit.SECONDS);
    
    String data = RFApplicationsubmittion(0);
    
    Actions actions = new Actions(driver);
    WebElement createapplication = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div"));
    actions.moveToElement(createapplication);
    
    WebElement subMenu = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/ul/li[1]/a"));
    actions.moveToElement(subMenu);
    actions.click().build().perform();
    
    driver.findElement(By.id("select2-SelectCompany-container")).click();
    Thread.sleep(2000L);
    
    WebElement company = driver.findElement(By.className("select2-search__field"));
    company.sendKeys(new CharSequence[] { "2am1a" });
    
    driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).click();
    
    driver.findElement(By.id("select2-SelectCMU-container")).click();
    Thread.sleep(2000L);
    
    WebElement cmu = driver.findElement(By.className("select2-search__field"));
    cmu.sendKeys(new CharSequence[] { data });
    
    driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
    
    driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/span/span[1]/span")).click();
    Thread.sleep(2000L);
    
    WebElement Auction = driver.findElement(By.className("select2-search__field"));
    Auction.sendKeys(new CharSequence[] { "sahil_test_19feb" });
    
    Thread.sleep(2000L);
    driver.findElement(By.className("select2-results__option--highlighted")).click();
    
    Thread.sleep(5000L);
    
    driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/button[1]")).click();
    
    Thread.sleep(2000L);
    
    driver.findElement(By.id("btn-submit")).click();
    driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/button[1]")).click();
    driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/button[1]")).click();
    
    Thread.sleep(20000L);
    
    driver.close();
    driver.quit();
  }
  
  public void loginwithEp()
  {
    System.setProperty("webdriver.chrome.driver", "C:/Seleniumchrome/chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    driver.get("https://am2sit.emrdeliverybody.com");
    String titleofpage = driver.getTitle();
    
    System.out.println(titleofpage);
    
    driver.findElement(By.id("ctl00_IdWelcome_ExplicitLogin")).click();
    
    String currenttitleofpage = driver.getTitle();
    
    System.out.println(currenttitleofpage);
    
    WebElement user = driver.findElement(By.name("user"));
    WebElement pass = driver.findElement(By.name("pass"));
    
    user.sendKeys(new CharSequence[] { "am1a.mainadmin" });
    pass.sendKeys(new CharSequence[] { "Passw01!" });
    
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    driver.findElement(By.name("btnLogin")).click();
    
    driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
    
    WebElement pin = driver.findElement(By.name("txtSMS"));
    pin.sendKeys(new CharSequence[] { "123456" });
    driver.findElement(By.name("btnSMS")).click();
  }
  
  String RFApplicationsubmittion(int i)
    throws IOException
  {
    File src = new File(System.getProperty("user.dir") + "\\data.xlsx");
    FileInputStream fis = new FileInputStream(src);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheetAt(0);
    
    String data = sheet.getRow(i).getCell(0).getStringCellValue();
    System.out.println(i + data);
    ChromeDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(5L, TimeUnit.SECONDS);
    
    return data;
  }
  
  String accesscmufromfile(int sheetno, int i, int j)
    throws IOException
  {
    File src = new File("C:\\Seleniumchrome\\testdataforselenium\\CreateCMU.xlsx");
    FileInputStream fis = new FileInputStream(src);
    Workbook wb = new XSSFWorkbook(fis);
    Sheet sheet = wb.getSheetAt(sheetno);
    
    DataFormatter formatter = new DataFormatter();
    
    String data = formatter.formatCellValue(sheet.getRow(j).getCell(i));
    
    System.out.println(i + data);
    
    return data;
  }
  
  void cmudetails()
    throws InterruptedException
  {
    ChromeDriver driver = new ChromeDriver();
    WebElement cmuid = driver.findElement(By.id("Identifier"));
    cmuid.sendKeys(new CharSequence[] { "sm12f1" });
    
    driver.findElement(By.id("ui-id-4")).click();
    Thread.sleep(2000L);
    
    WebElement radioyes = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[1]/div[3]/div[1]/div[1]/input[6]"));
    radioyes.click();
    
    driver.findElement(By.xpath("/html/body/div[1]/div/div/form/table/tbody/tr/td[1]/input")).click();
    
    Thread.sleep(2000L);
    driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/button[1]")).click();
  }
  
  String accessfromfile(int sheetno, int i, int j)
    throws IOException
  {
    File src = new File(System.getProperty("user.dir") + "/data.xlsx");
    FileInputStream fis = new FileInputStream(src);
    Workbook wb = new XSSFWorkbook(fis);
    Sheet sheet = wb.getSheetAt(sheetno);
    
    DataFormatter formatter = new DataFormatter();
    
    String data = formatter.formatCellValue(sheet.getRow(i).getCell(j));
    boolean retval = data.contains("EDATE");
    if (!retval)
    {
      System.out.println(i + data);
      return data;
    }
    Date data2 = sheet.getRow(i).getCell(j).getDateCellValue();
    
    Format formatter2 = new SimpleDateFormat("dd/MM/YYYY");
    String s = formatter2.format(data2);
    return s;
  }
  
  @Test
  public void test10() {}
}
