import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;

import java.io.IOException;

import java.util.Date;
import java.util.Calendar;
import java.text.DecimalFormat;
import java.lang.Math; 

import com.google.gson.*;

public class HealthModel
{
    private JsonElement jse;
   
   private int index;
    
	public boolean getInfo(String ingred, int count)
	{
      index = count;
   
        try
		{
         ingred = ingred.replaceAll(", ", ",").toLowerCase();
         ingred = ingred.replaceAll(" ", "%20").toLowerCase();
         
            URL url = new URL("http://www.recipepuppy.com/api/?i=" + ingred);
                        
			InputStream is = url.openStream(); // throws an IOException
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			jse = new JsonParser().parse(br);
      
			// Close the connection
			is.close();
			br.close();
		}
        catch (java.io.UnsupportedEncodingException uee)
        {
            System.out.println("1");
            return false;
        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("2");
            return false;
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("3");
            return false;
        }
        catch (java.lang.NullPointerException npe)
        {
            System.out.println("4");
            return false;
        }
        
        return isValid();
        
    }
    
    public boolean isValid()
    {
        try {
            String error = jse.getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("title").getAsString();
            return true;
        }

        catch (java.lang.IllegalStateException npe)
        {
            System.out.println("5");
            return false;
        }
        catch (java.lang.IndexOutOfBoundsException npe) {
         return false;
        }
    }
    
    
    public String getTitle()
    {
        try {
            return jse.getAsJsonObject().get("results").getAsJsonArray().get(index).getAsJsonObject().get("title").getAsString();

        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    public String getLink()
    {
        try {
            return jse.getAsJsonObject().get("results").getAsJsonArray().get(index).getAsJsonObject().get("href").getAsString();
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    public String getIngred()
    {
        try {
            return jse.getAsJsonObject().get("results").getAsJsonArray().get(index).getAsJsonObject().get("ingredients").getAsString();
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    
    public Image getImage()
    {   
        BufferedImage image = null;
        try {
            URL url = new URL(jse.getAsJsonObject().get("results").getAsJsonArray().get(index).getAsJsonObject().get("thumbnail").getAsString());
            image = ImageIO.read(url);
        } catch (IOException e) {
        	return new Image("badartistname.png");
        } catch (java.lang.UnsupportedOperationException npe) {
            return new Image("badartistname.png");
        }
        Image icon = SwingFXUtils.toFXImage(image, null);
        return icon;
        
    }
        
}
