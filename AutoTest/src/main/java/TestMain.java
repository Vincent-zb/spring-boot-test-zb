import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMain {

    public static void main(String[] args) throws Exception {

        ///如下为对百度网页进行一次搜索的过程；///
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);    设置下 全局等待时间
        //webdriver.chrome.driver：固定的，指谷歌驱动，D:/chrome/chromedriver.exe：驱动的位置
        System.setProperty("webdriver.chrome.driver", "D:/chrome/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com/");
        //显式等待， 针对某个元素等待(等元素加载起来后才触发)
//        WebDriverWait类是由WebDirver提供的等待方法。在设置时间内，默认每隔一段时间检测一次当前页面元素是否存在，如果超过设置时间检测不到则抛出异常。具体格式如下：
//        WebDriverWait(driver, 10, 1)
//        driver： 浏览器驱动。 10： 最长超时时间， 默认以秒为单位。 1： 检测的的间隔（步长） 时间， 默认为 0.5s。
        WebDriverWait wait = new WebDriverWait(driver, 10, 1);
        wait.until(new ExpectedCondition<WebElement>() {


            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("kw"));
            }
        }).sendKeys("selenium111");
/*        wait.until(new ExpectedCondition() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("kw"));
            }
        }).sendKeys("selenium");*/
        //创建鼠标属性方法,然后获取id为kw的元素并点击。
        //Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.id("kw"))).perform();
        //通过元素属性id=kw找到百度输入框，并输入"Selenium java"；
        WebElement webElement = driver.findElement(By.id("kw"));//.sendKeys("Selenium java");
        webElement.sendKeys("java selenium");//文本输入
        Thread.sleep(1000);
        webElement.clear();//清除文本
        Thread.sleep(2000);
        webElement.sendKeys("java");
        Thread.sleep(1000);
        //通过元素属性id=su找到百度一下搜索按钮，并对按钮进行点击操作；
        //driver.findElement(By.id("su")).click();//模拟点击提交
        driver.findElement(By.id("su")).submit();//模拟回车按钮。
        driver.navigate().back();//模拟浏览器后退按钮
        //driver.navigate().forward();//模拟浏览器前进按钮


//        getSize() 返回元素的尺寸。
//        getText() 获取元素的文本。
 //       getAttribute(name) 获得属性值。
 //       isDisplayed() 设置该元素是否用户可见。

/*
模拟鼠标操作
        Actions action = new Actions(driver)
        contextClick() 右击
        clickAndHold() 鼠标点击并控制
        doubleClick() 双击
        dragAndDrop() 拖动
        release() 释放鼠标
        perform() 执行所有Actions中存储的行为
 */


/*    模拟键盘操作
    //输入框输入内容
        input.sendKeys("seleniumm");
        Thread.sleep(2000);

        //删除多输入的一个 m
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);

        //输入空格键+“教程”
        input.sendKeys(Keys.SPACE);
        input.sendKeys("教程");
        Thread.sleep(2000);

        //ctrl+a 全选输入框内容
        input.sendKeys(Keys.CONTROL,"a");
        Thread.sleep(2000);

        //ctrl+x 剪切输入框内容
        input.sendKeys(Keys.CONTROL,"x");
        Thread.sleep(2000);

        //ctrl+v 粘贴内容到输入框
        input.sendKeys(Keys.CONTROL,"v");
        Thread.sleep(2000);

        //通过回车键盘来代替点击操作
        input.sendKeys(Keys.ENTER);

        以下为常用的键盘操作：
sendKeys(Keys.BACK_SPACE) 回格键（BackSpace）
sendKeys(Keys.SPACE) 空格键(Space)
sendKeys(Keys.TAB) 制表键(Tab)
sendKeys(Keys.ESCAPE) 回退键（Esc）
sendKeys(Keys.ENTER) 回车键（Enter）
sendKeys(Keys.CONTROL,‘a’) 全选（Ctrl+A）
sendKeys(Keys.CONTROL,‘c’) 复制（Ctrl+C）
sendKeys(Keys.CONTROL,‘x’) 剪切（Ctrl+X）
sendKeys(Keys.CONTROL,‘v’) 粘贴（Ctrl+V）
sendKeys(Keys.F1) 键盘 F1
……
sendKeys(Keys.F12) 键盘 F12


        */


/*        获取断言信息
        不管是在做功能测试还是自动化测试，最后一步需要拿实际结果与预期进行比较。这个比较的称之为断言。
        我们通常可以通过获取title 、URL和text等信息进行断言。text方法在前面已经讲过，它用于获取标签对之间的文本信息。

        getTitle()： 用于获得当前页面的title。
        getCurrentUrl() ： 用户获得当前页面的URL。
        getText() 获取页面文本信息。*/

/*
        //显式等待， 针对某个元素等待
        WebDriverWait wait = new WebDriverWait(driver,10,1);

        wait.until(new ExpectedCondition<WebElement>(){
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("kw"));
            }
        }).sendKeys("selenium");

        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);*/


/*
        .隐式等待
WebDriver 提供了几种方法来等待元素。

implicitlyWait。识别对象时的超时时间。过了这个时间如果对象还没找到的话就会抛出NoSuchElement异常。
setScriptTimeout。异步脚本的超时时间。WebDriver可以异步执行脚本，这个是设置异步执行脚本脚本返回结果的超时时间。
pageLoadTimeout。页面加载时的超时时间。因为WebDriver会等页面加载完毕再进行后面的操作，所以如果页面超过设置时间依然没有加载完成，那么WebDriver就会抛出异常。

        //页面加载超时时间设置为 5s
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com/");

        //定位对象时给 10s 的时间, 如果 10s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("kw")).sendKeys("selenium");

        //异步脚本的超时时间设置成 3s
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);*/

/*
        多表单切换
在 Web 应用中经常会遇到 frame/iframe 表单嵌套页面的应用， WebDriver 只能在一个页面上对元素识别与 定位， 对于 frame/iframe 表单内嵌页面上的元素无法直接定位。 这时就需要通过 switchTo().frame()方法将当前定 位的主体切换为 frame/iframe 表单的内嵌页面中
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.126.com");

        WebElement xf = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("username");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("dologin")).click();
        driver.switchTo().defaultContent();
        //……
    }
}
如果完成了在当前表单上的操作，则可以通过switchTo().defaultContent()方法跳出表单。*/


/*        多窗口切换
        在页面操作过程中有时候点击某个链接会弹出新的窗口， 这时就需要主机切换到新打开的窗口上进行操作。WebDriver提供了switchTo().window()方法可以实现在不同的窗口之间切换。
        以百度首页和百度注册页为例，在两个窗口之间的切换如下图。
        getWindowHandle()： 获得当前窗口句柄。
getWindowHandles()： 返回的所有窗口的句柄到当前会话。
switchTo().window()： 用于切换到相应的窗口，与上一节的switchTo().frame()类似，前者用于不同窗口的切换， 后者用于不同表单之间的切换。



        */


/*        下拉框选择
        有时我们会碰到下拉框，WebDriver提供了Select类来处理下接框。
        如百度搜索设置的下拉框，如下图：

    //<select>标签的下拉框选择
    WebElement el = driver.findElement(By.xpath("//select"));
    Select sel = new Select(el);
    sel.selectByValue("20");



        */


/*        警告框处理
        在 WebDriver中处理JavaScript所生成的alert、confirm以及prompt十分简单，具体做法是使用switch_to_alert()方法定位到alert/confirm/prompt，然后使用text/accept/dismiss/sendKeys等方法进行操作。

        getText()： 返回 alert/confirm/prompt 中的文字信息。
        accept()： 接受现有警告框。
        dismiss()： 解散现有警告框。
        sendKeys(keysToSend)： 发送文本至警告框。
        keysToSend： 将文本发送至警告框。*/


/*
        文件上传
        对于通过input标签实现的上传功能，可以将其看作是一个输入框，即通过sendKeys()指定本地文件路径的方式实现文件上传。

        WebDriver driver = new ChromeDriver();
        File file = new File("./HTMLFile/upfile.html");
        String filePath = file.getAbsolutePath();
        driver.get(filePath);
*/

/*        浏览器cookie操作
        有时候我们需要验证浏览器中Cookie是否正确， 因为基于真实Cookie的测试是无法通过白盒测试和集成测试进行的。WebDriver提供了操作Cookie的相关方法可以读取、 添加和删除Cookie信息。
        WebDriver 操作Cookie的方法：

        getCookies() 获得所有 cookie 信息。
        getCookieNamed(String name) 返回字典的key为“name”的Cookie信息。
        addCookie(cookie dict) 添加Cookie。“cookie_dict”指字典对象，必须有 name和value值。
        deleteCookieNamed(String name) 删除Cookie 信息。 “name”是要删除的 cookie的名称； “optionsString” 是该Cookie的选项，目前支持的选项包括“路径” ， “域” 。
        deleteAllCookies() 删除所有 cookie 信息。

        //定位上传按钮， 添加本地文件
        driver.findElement(By.name("file")).sendKeys("D:\\upload_file.txt");
        Thread.sleep(5000);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        Cookie c1 = new Cookie("name", "key-aaaaaaa");
        Cookie c2 = new Cookie("value", "value-bbbbbb");
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);

        //获得 cookie
        Set<Cookie> coo = driver.manage().getCookies();
        System.out.println(coo);

        //删除所有 cookie
        //driver.manage().deleteAllCookies();
  */

/*
        调用JavaScript代码
        虽然WebDriver提供了操作浏览器的前进和后退方法，但对于浏览器滚动条并没有提供相应的操作方法。在这种情况下，就可以借助JavaScript来控制浏览器的滚动条。WebDriver提供了executeScript()方法来执行JavaScript代码。
        用于调整浏览器滚动条位置的JavaScript代码如下：

<!-- window.scrollTo(左边距,上边距); -->
                window.scrollTo(0,450);
        window.scrollTo()方法用于设置浏览器窗口滚动条的水平和垂直位置。方法的第一个参数表示水平的左间距，第二个参数表示垂直的上边距。其代码如下：

    WebDriver driver = new ChromeDriver();


    //设置浏览器窗口大小
    driver.manage().window().setSize(new Dimension(700, 600));
    driver.get("https://www.baidu.com");


    //进行百度搜索
    driver.findElement(By.id("kw")).sendKeys("webdriver api");
    driver.findElement(By.id("su")).click();
    Thread.sleep(2000);


    //将页面滚动条拖到底部
    ((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
    Thread.sleep(3000);


通过浏览器打开百度进行搜索，并且提前通过window().setSize()方法将浏览器窗口设置为固定宽高显示，目的是让窗口出现水平和垂直滚动条。然后通过executeScript()方法执行JavaScripts代码来移动滚动条的位置。



*/
/*
        获取窗口截图

        自动化用例是由程序去执行，因此有时候打印的错误信息并不十分明确。如果在脚本执行出错的时候能对当前窗口截图保存，那么通过图片就可以非常直观地看出出错的原因。 WebDriver提供了截图函数getScreenshotAs()来截取当前窗口。

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File("d:\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

 */






        //移动到页面最底部
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(1000);
        for (int j = 1; j < 10; j++) {
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, " + j * 100 + ")");
        }
        System.out.println("退出循环了");
//        //刷新页面
//        driver.navigate().refresh();
        driver.quit();
    }

}

