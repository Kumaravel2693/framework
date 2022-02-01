package org.frame;

import java.awt.Desktop.Action;
import java.io.File;
import java.util.List;
import java.util.Set;

import javax.swing.text.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {

	WebDriver driver;

	// 1.
	public void getdirver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2.
	public void loadurl(String url) {
		driver.get(url);
	}

	// 3.
	public void sendText(WebElement element, String data) {
		element.sendKeys(data);
	}

	// 4.
	public void click(WebElement element) {
		element.click();

	}

	// 5.
	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	// 6.
	public String geturl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	// 7.
	public String getText(WebElement element) {
		String text = element.getText();
		return text;

	}

	// 8.
	public WebElement findElementById(String AttributeValue) {
		WebElement element = driver.findElement(By.id(AttributeValue));
		return element;

	}

	// 9.
	public WebElement findElementsByName(String AttributeValue) {
		WebElement element = driver.findElement(By.name(AttributeValue));
		return element;

	}

	// 10.
	public WebElement findElementByClass(String AttributeValue) {
		WebElement element = driver.findElement(By.className(AttributeValue));
		return element;
	}

	// 11.
	public WebElement findElementByXpath(String Xpath) {
		WebElement element = driver.findElement(By.id(Xpath));
		return element;
	}

	// 12.
	// MethodOverloading
	public String getAttribute(WebElement element, String attributeName) {
		String data = element.getAttribute(attributeName);
		return data;

	}

	// 13.
	// methodOverloading
	public String getAttribute(WebElement element) {
		String data = element.getAttribute("value");
		return data;

	}

	// 14.
	public void quit() {
		driver.quit();

	}

	// 15.
	public void close() {
		driver.close();

	}

	// 16.
	public void maximize() {
		driver.manage().window().maximize();

	}

	// 17.
	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);

	}

	// 18.
	public void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	// 19.
	public void draganddrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).perform();

	}

	// 20.
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	// 21.
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	// 22.
	public void perform() {
		Actions action = new Actions(driver);
		action.perform();
	}

	// 23.
	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;

	}

	// 24.
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 25.
	public void aletrdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 26.
	public File screenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		return screenshotAs;

	}

	// 27.
	public void typetextJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].seAttribute('value','" + data + "')", element);

	}

	// 28.
	public void gettextJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAtrribute('value')", element);

	}

	// 29.
	public void clickbyJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	// 30.
	public void scrolldownbyJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	// 31.
	public void scrollupbyJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	// 32.
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 33.
	public void selectByAttributeValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 34.
	public void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 35.
	public boolean selectMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;

	}

	// 36.
	public List<WebElement> selectgetOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;

	}

	// 37.
	public WebElement firstSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;

	}

	// 38.
	public List<WebElement> allSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	// 39.
	private void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 40.
	private void deselectByAttributevalue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);

	}

	// 41.
	private void deselectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 42.
	private void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// 43.
	private void swithchToFrameByIndex(int index) {
		driver.switchTo().frame(index);

	}

	// 44.
	private void switchToFrameByName(String name) {
		driver.switchTo().frame(name);

	}

	// 45.
	private void switchToFrameByElementref(WebElement element) {
		driver.switchTo().frame(element);

	}

	// 46.
	private void parentFrame() {
		driver.switchTo().parentFrame();

	}

	// 47.
	private void frameToWebPage() {
		driver.switchTo().defaultContent();

	}

	// 48.
	private void switchToWindow(String data) {
		driver.switchTo().window(data);
	}

	// 49.
	private String parentWindowId() {
		String ParentWindowID = driver.getWindowHandle();
		return ParentWindowID;

	}

	// 50.
	private Set<String> allWindowID() {
		Set<String> allWindowID = driver.getWindowHandles();
		return allWindowID;

	}

	// 51.
	private List<WebElement> findelements(String data) {
		List<WebElement> findElements = driver.findElements(By.id(data));
		return findElements;

	}

	// 52.
	private List<WebElement> findelementsByelement(WebElement element, String tagName) {
		List<WebElement> elements = element.findElements(By.tagName(tagName));
		return elements;

	}

}
