package com.fish.logback;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver","D:\\xm\\java\\code\\study\\2022\\check\\dataworks-check\\src\\main\\resources\\config\\chromedriver.exe");//下载的chromedriver位置
        WebDriver driver = new ChromeDriver();//实例化ChromeDriver对象
        String url="http://www.baidu.com/";
        driver.get(url);//打开指定网站

        //找到id为kw的元素，输入java+selenium
        //driver.findElement(By.id("kw")).sendKeys("java+selenium");
        //点击id为su的元素
        //driver.findElement(By.id("su")).click();

        //隐式等待，针对页面加载，一旦设置，这个隐式等待会在WebDriver对象实例的整个生命周期起作用，
        //它不针对某一个元素，是全局元素等待，即在定位元素时，需要等待页面全部元素加载完成，
        //才会执行下一个语句。如果超出了设置时间的则抛出异常。
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //显示等待是等待指定元素设置的等待时间 推荐
        WebElement we=new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"qrcode\"]/div/div[2]")));

        //获取浏览器当前网页标题与地址
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //获取单个元素
        WebElement element = driver.findElement(By.id("su"));
        System.out.println("单个元素："+element.getAttribute("class"));

        //获取多个元素
        List<WebElement> eList = driver.findElements(By.tagName("input"));
        for(WebElement e:eList) {
            System.out.println("获取多个元素："+e.getAttribute("name"));
        }

      //css定位层级元素
        WebElement e = driver.findElement(By.cssSelector("div.qrcode-text"));
        List<WebElement> list = e.findElements(By.tagName("p"));
        for (WebElement e1 : list) {
            System.out.println("css定位层级元素:"+e1.getAttribute("class"));
        }
      //xpath定位层级元素
        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"qrcode\"]/div/div[2]"));
        List<WebElement> list2 = e.findElements(By.tagName("p"));
        for (WebElement e1 : list) {
            System.out.println("xpath定位层级元素:"+e1.getAttribute("class"));
        }


       //获取当前的窗口
        String currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow);

      //获取所有的窗口
        Set<String> handles = driver.getWindowHandles();
        for(String s:handles) {
            System.out.println(s);
        }

      //遍历窗口
        Iterator<String> iterator = handles.iterator();
        while(iterator.hasNext()) {
            String next=iterator.next();//这里iterator.next()只能用一次，否则会产生越界
            if (currentWindow.equals(next))
                continue;
            //跳转到弹出的窗口
            WebDriver driver2 = driver.switchTo().window(next);
            driver2.getTitle();

        }

        //执行JS脚本
        String jsString="alert('Hello')";
        try {
            ((JavascriptExecutor)driver).executeScript(jsString);
        } catch (Exception ex) {
             //TODO Auto-generated catch block
            ex.printStackTrace();
        }

        //处理弹出框
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //alert.dismiss();//相当于点击取消
        alert.accept();//相当于点击确认
        //alert.sendKeys("testing");//输入值,如果可以


      //处理下拉列表
       /* Select select = new Select(driver.findElement(By.id("select")));
        select.selectByIndex(1);
        select.selectByValue("Value");
        select.selectByVisibleText("Text");
        //获取下拉框的全部选项
        List<WebElement> list3 = select.getOptions();
        for (WebElement webElement : list3) {
            webElement.click();//点击下拉框
        }*/

        //处理cookie
        //添加一个cookie
        Cookie cookie = new Cookie("sessionId","DF2334DFSDFOIFDFD221131");
        driver.manage().addCookie(cookie);

        //获取cookie
        Set<Cookie> cookieSet=driver.manage().getCookies();
        Iterator<Cookie> iteratorCookie = cookieSet.iterator();
        while(iteratorCookie.hasNext()) {
            Cookie c= iteratorCookie.next();
            System.out.println(c.getName());
            System.out.println(c.getValue());
        }

        //driver.manage().deleteAllCookies();删除所有cookie
        //driver.manage().deleteCookie(cookie);删除cookie这个对象
        //driver.manage().deleteCookieNamed("COOKIE");删除name为COOKIE的cookie

        //鼠标操作
        Actions action = new Actions(driver) ;
        //移动到元素上双击 加上perform()才生效
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"su\"]"))).doubleClick().perform();
        //移动到元素上右击
        action.moveToElement(driver.findElement(By.cssSelector("input#kw"))).contextClick().perform();

        driver.quit();//退出浏览器

    }

}