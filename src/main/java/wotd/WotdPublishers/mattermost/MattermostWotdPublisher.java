package wotd.WotdPublishers.mattermost;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import wotd.Util.AppConfig;
import wotd.Util.MessageFormatter;
import wotd.Util.Wotd;
import wotd.WotdPublishers.WotdPublisher;

import java.io.IOException;
import java.nio.charset.Charset;

public class MattermostWotdPublisher implements WotdPublisher {
    private String url;
    private String user;
    private Gson gson;

    public MattermostWotdPublisher(String url, String user) {
        this.url = url;
        this.user = user;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void publishWotd(Wotd wotd, AppConfig config) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(this.url);

            MattermostMessage message = new MattermostMessage(MessageFormatter.formatMessage(wotd, config), this.user);
            StringEntity entity = new StringEntity(gson.toJson(message), Charset.forName("UTF-8"));
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-type", "application/json; charset=UTF-8");

            CloseableHttpResponse response = client.execute(httpPost);
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
