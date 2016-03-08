package WallpaperChanger;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.paginators.Sorting;
import net.dean.jraw.paginators.SubredditPaginator;


public class imageGetter {
	private static boolean saveImage(Image img){
		Date date = new Date();
		String filePath = "C:\\Users\\richa\\Desktop\\Wallpaper\\" + date.getTime() + ".jpg";
		try{
			File file = new File(filePath);
			ImageIO.write((BufferedImage)img, "JPEG", file);
			return true;
		} catch (Exception e) {
			System.out.println("Something screwed up");
			return false;
		}
	}
	private Image getImage(String fileURL){
		//	Get the image and return it
		Image image = null;
		try{
			URL url = new URL(fileURL);	// URL to the image
			image = ImageIO.read(url);
			System.out.println("Image successfully downloaded");
		} catch (IOException e) {
			System.out.println("There was an error");
		}
		return image;
	}
	private void browseReddit(String subreddit){
		try{
			UserAgent myUserAgent = UserAgent.of("desktop", "hedzup456/script1", "v0.1", "hedzup456");
			RedditClient redditClient = new RedditClient(myUserAgent);
			Credentials credentials = Credentials.script("King_Richard_", "naughty-secret-password-man", "vfLSMpt4J2QYbQ", "TQbFi-pw1A6rYJvELS8zAPUGw3U");
			OAuthData authData = redditClient.getOAuthHelper().easyAuth(credentials);
			redditClient.authenticate(authData);
		
			SubredditPaginator sp = new SubredditPaginator(redditClient);
			sp.setLimit(100);
			sp.setSorting(Sorting.HOT);
			sp.setTimePeriod(null);
			sp.setSubreddit(subreddit);
			
			Listing<Submission> submissions = sp.next();	//	Get next page of submissions
			int count = 1;
			for (Submission post: submissions){
				String postUrl = post.getUrl();
				System.out.print(count + " - " + post.getTitle() + ": ");
				if (postUrl.contains(".jpg") || postUrl.contains(".jpeg")){	//	Don't want anything not a jpeg. Can't be bothered to deal with that
					BufferedImage image = (BufferedImage)getImage(postUrl);
					if (image.getWidth()/16 == image.getHeight()/9 && image.getWidth() >= 1920){
						System.out.print("Saving.");
						saveImage(image);
					} else {
						System.out.print("Image does not match resolution specification.");
					}
				} else{
					System.out.print("Not an image of jpg type.");
				}
				System.out.print("\n");
				count++;
			}
		} catch (Exception e) {
			System.out.println("Something's wrong");
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		imageGetter i = new imageGetter();
/*		Image img = i.getImage("http://i.imgur.com/2vnR3zi.jpg");	// NOTEDLY NSFW IMAGHE FOR TESTING
		saveImage(img);*/
		i.browseReddit("wallpapers");	//	Similarly NSFW subreddit
	}

}
