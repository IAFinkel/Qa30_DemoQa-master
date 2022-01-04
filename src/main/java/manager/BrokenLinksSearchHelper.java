package manager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;
import static com.jayway.restassured.RestAssured.given;


public class BrokenLinksSearchHelper extends HelperBase {

    public BrokenLinksSearchHelper(WebDriver wd) {
        super(wd);
    }

    public void selectElements() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//h5[normalize-space()='Elements']"));

    }

    public void selectBrokenLinks() {
        hideFooter();
        click(By.xpath("//span[text()='Broken Links - Images']"));

    }


    public void checkBrokenLinks() {
        List<WebElement> links = wd.findElements(By.cssSelector("a[href]"));
        System.out.println("Total links on the page is-->" + links.size());
        for (WebElement el : links) {
            String href = el.getAttribute("href");
            verifyLinkRestAssert(href);
            //verifyLinkOkkHttp(href);
        }

    }

    private void verifyLinkRestAssert(String href) {
        try {
            int code = given().when().head(href).then().extract().statusCode();
            if (code == 200) {
                System.out.println(href + "-->" + code + "Not Broaken");
            } else {
                System.out.println(href + "-->" + code + "Broaken Link");
            }
        } catch (Exception e) {
            System.out.println(href);
            System.out.println("Error" + e.getMessage());
        }

    }

    private void verifyLinkOkkHttp(String href) {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(href)
                    .head()
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                System.out.println(href + "-->" + response.code() + "  " + response.message());
            } else {
                System.out.println(href + "-->" + response.code() + "  " + response.message());
            }
        } catch (IOException ex) {
            System.out.println(href);
            System.out.println("error" + ex.getMessage());
        }


    }

    public void checkBrokenImages() {
        List<WebElement> images = wd.findElements(By.tagName("img"));
        System.out.println("We have " + images.size() + " images");

        for (int i = 0; i < images.size(); i++) {
            WebElement img = images.get(i);
            String imgURL = img.getAttribute("src");
            System.out.println("URL of image " + i + " is " + imgURL);

            verifyLinkOkkHttp(imgURL);

        }

//        for (WebElement img : images) {
//            String imageURL = img.getAttribute("src");
//            System.out.println("URL of Image " + "  " + " is: " + imageURL);
//            verifyLinkRestAssert(imageURL);
//
//        }
    }

    public void checkBrokenImagesJS() {
        List<WebElement> images = wd.findElements(By.tagName("img"));
        System.out.println("We have "+images.size()+" images");

        for (int i = 0; i < images.size(); i++) {
            WebElement img = images.get(i);
            String imgURL = img.getAttribute("src");
            System.out.println("URL of image " + i + " is " + imgURL);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) wd)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0);", img);
                if(imageDisplayed){
                    System.out.println("Display - OK");
                    System.out.println("*************************");
                }
                else {
                    System.out.println("Display - Broaken");
                    System.out.println("**************************");
                }
            } catch (Exception e){
                System.out.println("Error");
            }

        }
    }
}
