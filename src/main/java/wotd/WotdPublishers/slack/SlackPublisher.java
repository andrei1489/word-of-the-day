package wotd.WotdPublishers.slack;

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
import wotd.WotdPublishers.Publisher;

import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;

public class SlackPublisher implements Publisher {
    private AppConfig config;
    private Gson gson ;

    public SlackPublisher(AppConfig config) {
        this.config = config;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void publishWotd(Wotd wotd) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(config.getSlackUrl());

            SlackMessage message = new SlackMessage(MessageFormatter.formatMessage(wotd, config));
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
