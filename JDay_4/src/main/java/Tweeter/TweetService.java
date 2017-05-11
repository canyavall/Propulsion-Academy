package Tweeter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TweetService {

	private Map<String, Tweet> database = new HashMap<>();

	void save(Tweet tweet){
		database.put(tweet.getId(), tweet);
	}
	
	void delete(String id){
		try{
			database.remove(id);
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		
	}
	
	Tweet findById(String id){		
		return database.get(id);		
	}
	
	List<Tweet> findAll(){
		List<Tweet> tweetList = new ArrayList<Tweet>(database.values());
		return tweetList;
		
	}
	
	List<Tweet>  searchWord(String str){
		List<Tweet> tweetList = new ArrayList<Tweet>();
		for (Map.Entry entry : database.entrySet()) {
			String text = (String) entry.getValue();
			if (text.toLowerCase().contains(str.toLowerCase())){
				tweetList.put(entry);
			}
		}
		return tweetList;
		
	}
	
	void printAll(){
		for (Map.Entry entry : database.entrySet()) {
		    System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}

}
