package edu.curtin.messaging;
import Assignment.View.DisplayDetails;
import java.util.*;
public abstract class TwitterMessenger
{
	protected Set<String> keywordsSet;

	public TwitterMessenger()
	{

	}

	public void sendPrivateMessage(String id, String message)
	{
		DisplayDetails.showData("Twitter private message: " + message +
										" was sent to ID: " + id);

	}

	public void setKeywords(Set<String> keywords)
	{
		//Replace the existing set of keywords to be monitored to a new set
		this.keywordsSet = keywords;
	}

	/**Called by monitoring thread after every search. For each keyword
	 * being monitored, the map parameter contains the number of times that
	 * keyword has been mentioned on Twitter since the previous search was
	 * performed. The timestamp parameter is the time of the search,
	 * measured in seconds since the "epoch" (01/01/1970)
	 */
	protected abstract void keywordsDetected(Map<String, Integer> keywords,
											 long timestamp);


}
