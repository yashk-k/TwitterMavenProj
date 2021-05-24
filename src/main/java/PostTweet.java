import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PostTweet {
    public static void postTweet(String message) {
        InputStream is = PostTweet.class.getResourceAsStream("/config.properties");
        Properties props = new Properties();
        try {
            props.load(is);
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey((String) props.get("OAuthConsumerKey"))
                    .setOAuthConsumerSecret((String) props.get("OAuthConsumerSecret"))
                    .setOAuthAccessToken((String) props.get("OAuthAccessToken"))
                    .setOAuthAccessTokenSecret((String) props.get("OAuthAccessTokenSecret"));
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            twitter.updateStatus(message);
        } catch (TwitterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        if ("post".equals(args[0])) {
            postTweet("Hey there! This is an automated post from Yash!");
        } else if ("retrieve".equals(args[0])) {
            RetrieveTimeline.retrieveTimeLine();
        }
    }
}


