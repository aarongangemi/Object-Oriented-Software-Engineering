package edu.curtin.messaging;

import Assignment.Model.PolicyArea;
import java.util.*;

public class TwitterChild extends TwitterMessenger
{
	private PolicyArea policyArea;
	public TwitterChild()
	{
		//Used for notification
	}

	public TwitterChild(Set<String> keywords)
	{
		//Get current time in milliseconds
		long currentTime = System.currentTimeMillis();
		int delayTime = 10000;
		setKeywords(keywords);
		Timer timer = new Timer();
		//Create new timer
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{

				Map<String, Integer> keywordsMap = new HashMap<>();
				//create new map of keywords
				keywordsDetected(keywordsMap,currentTime);
				//detect keywords in map - include filling
				if(System.currentTimeMillis() - currentTime >= delayTime)
				{
					timer.cancel();
					//cancel thread
				}
			}

		}, delayTime);
	}

	@Override
	protected void keywordsDetected(Map<String, Integer> keywords,
									long timestamp)
	{
		//Random rand = new Random();
		for(String str : keywordsSet)
		{
			keywords.put(str,100);
		}
		for(String str1 : keywords.keySet())
		{
			if(keywords.get(str1) >= 50)
			{
				policyArea.notifyObserverKeywordsTrending();
			}
		}
	}

	public void setPolicyArea(PolicyArea policyArea)
	{
		this.policyArea = policyArea;
	}



}
