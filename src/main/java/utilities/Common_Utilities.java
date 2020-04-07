package utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Common_Utilities
{
    public static void BrokenLinks(List<WebElement> links) throws IOException
    {
        int statusCode=0;
        HttpURLConnection connection = null;
        try
        {
            for (WebElement link : links)
            {
                String href = link.getAttribute("href");
                //System.out.println(link.getAttribute("href"));
                connection = (HttpURLConnection) new URL(href).openConnection();
                connection.connect();
                statusCode = connection.getResponseCode();
                Assert.assertEquals("Broken link " + href + " - response code  :" + statusCode , 200, statusCode);
                System.out.println(href + " - response code :" + statusCode);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            connection.disconnect();
        }
    }
    public static void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        }
        catch (Exception e)
        {

        }
    }

}
