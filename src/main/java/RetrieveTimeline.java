import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RetrieveTimeline {

    public static void retrieveTimeLine() {

        InputStream is = PostTweet.class.getResourceAsStream("/config.properties");
        Properties props = new Properties();
        List<Status> statuses = new ArrayList<Status>();
        try {
            props.load(is);
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey((String) props.get("OAuthConsumerKey"))
                    .setOAuthConsumerSecret((String) props.get("OAuthConsumerSecret"))
                    .setOAuthAccessToken((String) props.get("OAuthAccessToken"))
                    .setOAuthAccessTokenSecret((String) props.get("OAuthAccessTokenSecret"))
                    .setJSONStoreEnabled(true);
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            Paging paging = new Paging(10);
            statuses = twitter.getHomeTimeline(paging);


            String strInitialDataSet = DataObjectFactory.getRawJSON(statuses);
            JSONArray JATweets = new JSONArray(strInitialDataSet);

            for (int i = 0; i < JATweets.length(); i++) {
                JSONObject JOTweets = JATweets.getJSONObject(i);
                System.out.println("Time Line:" + JOTweets.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
