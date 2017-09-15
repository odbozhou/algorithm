package azure.quickstarts;

/**
 * Created by zhoubo on 2017/7/7.
 */

// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ComputerVision {
    public static void main(String[] args) {
        HttpClient httpclient = new DefaultHttpClient();

        try {
            // NOTE: You must use the same location in your REST call as you used to obtain your subscription keys.
            //   For example, if you obtained your subscription keys from westus, replace "westcentralus" in the
            //   URL below with "westus".
            URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/vision/v1.0/analyze");

            builder.setParameter("visualFeatures", "Categories");
            builder.setParameter("details", "Celebrities");
            builder.setParameter("language", "en");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/json");

            // NOTE: Replace the example key with a valid subscription key.
            request.setHeader("Ocp-Apim-Subscription-Key", "c8d980c17d494213958318ed78c1b8d4");
//            request.setHeader("Ocp-Apim-Subscription-Key", "2400853ded8f401a8eebc2a8cc1ca8b4");

            // Request body. Replace the example URL with the URL for the JPEG image of a celebrity.
//            StringEntity reqEntity = new StringEntity("{\"url\":\"http://a.hiphotos.baidu.com/zhidao/pic/item/e4dde71190ef76c647fd64809c16fdfaaf51676a.jpg\"}");
            StringEntity reqEntity = new StringEntity("{\"url\":\"http://a.hiphotos.baidu.com/zhidao/pic/item/e4dde71190ef76c647fd64809c16fdfaaf51676a.jpg\"}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }

            generateThumbnail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void generateThumbnail()
    {
        HttpClient httpClient = new DefaultHttpClient();

        try
        {
            // NOTE: You must use the same location in your REST call as you used to obtain your subscription keys.
            //   For example, if you obtained your subscription keys from westus, replace "westcentralus" in the
            //   URL below with "westus".
            URIBuilder uriBuilder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/vision/v1.0/generateThumbnail");

            uriBuilder.setParameter("width", "100");
            uriBuilder.setParameter("height", "150");
            uriBuilder.setParameter("smartCropping", "true");

            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/json");

            // NOTE: Replace the "Ocp-Apim-Subscription-Key" value with a valid subscription key.
            request.setHeader("Ocp-Apim-Subscription-Key", "c8d980c17d494213958318ed78c1b8d4");

            // Request body. Replace the example URL with the URL for the JPEG image of a person.
            StringEntity requestEntity = new StringEntity("{\"url\":\"http://a.hiphotos.baidu.com/zhidao/pic/item/e4dde71190ef76c647fd64809c16fdfaaf51676a.jpg\"}");
            request.setEntity(requestEntity);

            HttpResponse response = httpClient.execute(request);
            System.out.println(response);

            // Display the thumbnail.
            HttpEntity httpEntity = response.getEntity();
            displayImage(httpEntity.getContent());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void displayImage(InputStream inputStream)
    {
        try {
            BufferedImage bufferedImage = ImageIO.read(inputStream);

            ImageIcon imageIcon = new ImageIcon(bufferedImage);

            JLabel jLabel = new JLabel();
            jLabel.setIcon(imageIcon);

            JFrame jFrame = new JFrame();
            jFrame.setLayout(new FlowLayout());
            jFrame.setSize(100, 150);

            jFrame.add(jLabel);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
