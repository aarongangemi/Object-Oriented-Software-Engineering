package edu.curtin.messaging;
import Assignment.View.DisplayDetails;
import java.util.*;
public abstract class FacebookMessenger
{
	protected Set<String> keywordsSet;
	public FacebookMessenger()
	{
	}

	public void sendPrivateMessage(String id, String message)
	{
		DisplayDetails.showData("Facebook private message sent to ID - "
										+ id + ": " + message);
	}

	public void setKeywords(Set<String> keywords)
	{
		this.keywordsSet = keywords;
	}

	protected abstract void keywordsDetected(Map<String, Integer> keywords,
											 long timestamp);




}
