package edu.curtin.messaging;
import Assignment.Model.PolicyArea;
import java.util.*;

public class FacebookChild extends FacebookMessenger
{
	private PolicyArea policyArea;
	public FacebookChild()
	{
	}

	public FacebookChild(Set<String> keywords)
	{
		long currentTime = System.currentTimeMillis();
		//Get current epoch
		int delayTime = 10000;
		setKeywords(keywords);
		Timer timer = new Timer();
		//Create Timer
		timer.schedule(new TimerTask()
		{
			//Schedule timertask
			@Override
			public void run()
			{
				Map<String, Integer> keywordsMap = new HashMap<>();
				//create new map
				keywordsDetected(keywordsMap,currentTime);
				//add to map with time
				if(System.currentTimeMillis() - currentTime >= delayTime)
				{
					timer.cancel();
					//cancel thread running
				}
			}

		}, delayTime);
	}

	@Override
	protected void keywordsDetected(Map<String, Integer> keywords,
									long timestamp)
	{
		for(String str : keywordsSet)
		{
			keywords.put(str,100); //add to map
		}
		for(String str1 : keywords.keySet())
		{
			if(keywords.get(str1) >= 50)
			{
				policyArea.notifyObserverKeywordsTrending();
				//notify
			}
		}
	}

	public void setPolicyArea(PolicyArea policyArea)
	{
		this.policyArea = policyArea;
		//set associated policyArea
	}

}

