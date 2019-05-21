package Assignment.Model;
import Assignment.Controller.ObserverKeywordsAdded;
import Assignment.Controller.ObserverKeywordsTrending;
import Assignment.Controller.ObserverTalkingPointAdded;
import Assignment.View.DisplayDetails;
import edu.curtin.messaging.FacebookChild;
import edu.curtin.messaging.FacebookMessenger;
import edu.curtin.messaging.TwitterChild;
import edu.curtin.messaging.TwitterMessenger;

import java.util.*;

/***************************************
 * Purpose: This is the PolicyArea Class. It is responsible for storing data
 * related to the policyArea including keywords and talkingPoints. It holds
 * 3 observer lists which are used to observer different events.
 * Author: Aaron Gangemi
 */
public class PolicyArea
{
	private String name;
	private Set<String> keywords;
	private Set<String> talkingPoints;
	private List<ObserverKeywordsAdded> observerListA;
	private List<ObserverKeywordsTrending> observerListB;
	private List<ObserverTalkingPointAdded> observerListC;
	//Classfields

	/*******************************************
	 * Purpose: Constructs a policy Area given the name
	 * @param name
	 ******************************************/
	public PolicyArea(String name)
	{
		this.name = name;
		keywords = new HashSet<>();
		talkingPoints = new HashSet<>();
		observerListA = new ArrayList<>();
		observerListB = new ArrayList<>();
		observerListC = new ArrayList<>();
	}

	/*******************************************
	 * Purpose: Accessor for policy name
	 * @return
	 *****************************************/
	public String getName()
	{
		return name;
	}

	/********************************************
	 * Purpose: Accessor for keywords
	 * @return keywords
	 *******************************************/
	public Set<String> getKeywords()
	{
		return keywords;
	}

	/********************************************
	 * Purpose: Accessor for talking Points
	 * @return talkingPoints
	 ********************************************/
	public Set<String> getTalkingPoints()
	{
		return talkingPoints;
	}


	/******************************************
	 * Purpose: Adds a keyword then notify the observer which will
	 * notify all the people who are required to be notified
	 * @param keyword
	 *********************************************/
	public void addKeyword(String keyword)
	{
		keywords.add(keyword);
		notifyObserverKeywordsAdded(); //calls notify
		checkTrending();
	}

	/***********************************************
	 * Purpose: Adds a talking point then notifies the observer which
	 * notifies the people who are required to be notified
	 * @param talkingPoint
	 **********************************************/
	public void addTalkingPoint(String talkingPoint)
	{
		talkingPoints.add(talkingPoint);
		notifyObserverTalkingPointAdded(); //calls notify
	}

	/********************************************
	 * Purpose: Used to remove an observer
	 * @param obs
	 ********************************************/
	public void removeObserverKeywordAdded(ObserverKeywordsAdded obs)
	{
		observerListA.remove(obs);

	}
	/********************************************
	 * Purpose: Used to remove an observer
	 * @param obs
	 ********************************************/
	public void removeObserverKeywordTrending(ObserverKeywordsTrending obs)
	{
		observerListB.remove(obs);
	}
	/********************************************
	 * Purpose: Used to remove an observer
	 * @param obs
	 ********************************************/
	public void removeObserverTalkingPointAdded(ObserverTalkingPointAdded obs)
	{
		observerListC.remove(obs);
	}

	/*********************************************
	 * Purpose: Takes a person and loops through each list and removes
	 * any notifications the person was related to. This is called one the
	 * person is deleted
	 * @param p
	 ********************************************/
	public void removePersonNotifications(Person p)
	{
		ListIterator<ObserverKeywordsAdded> keywordsAddedListIterator =
											observerListA.listIterator();
		ListIterator<ObserverTalkingPointAdded> talkingPointAddedListIterator =
											observerListC.listIterator();
		ListIterator<ObserverKeywordsTrending> keywordsTrendingListIterator =
											observerListB.listIterator();
		//Iterators initialised in order to loop through lists
		while(keywordsAddedListIterator.hasNext())
		{
			ObserverKeywordsAdded obs = keywordsAddedListIterator.next();
			//go to first
			if(obs.checkPerson(p)) //check if person exists
			{
				keywordsAddedListIterator.remove(); //remove observer
			}
		}
		while (keywordsTrendingListIterator.hasNext())
		{
			ObserverKeywordsTrending obs = keywordsTrendingListIterator.next();
			if(obs.checkPerson(p)) //check if person exists
			{
				keywordsTrendingListIterator.remove(); //remove observer
			}
		}
		while (talkingPointAddedListIterator.hasNext())
		{
			ObserverTalkingPointAdded obs = talkingPointAddedListIterator.next();
			if(obs.checkTalkingPoints(p)) //check if person exists
			{
				talkingPointAddedListIterator.remove(); //remove observer
			}
		}
	}

	/***********************************************
	 * Purpose: Views all talking points
	 ***********************************************/
	public void viewTalkingPoints()
	{
		for(String str : talkingPoints)
		{
			DisplayDetails.showData(str);
		}
	}

	/*************************************************
	 * Purpose: Views all keywords
	 **************************************************/
	public void viewKeywords()
	{
		for(String str : keywords)
		{
			DisplayDetails.showData(str);
		}
	}

	/****************************************************
	 * Purpose: Add keyword observer to list when keyword is Added
	 * @param obs
	 ******************************************************/
	public void addObserverKeywordsAdded(ObserverKeywordsAdded obs)
	{
		observerListA.add(obs);
	}

	/******************************************************
	 * Purpose: add keyword trending observer when keyword is trending
	 * @param obs
	 *******************************************************/
	public void addObserverKeywordsTrending(ObserverKeywordsTrending obs)
	{
		observerListB.add(obs);
	}

	/********************************************************
	 * Purpose: add Talking Point added observer when talking point is added
	 * @param obs
	 *******************************************************/
	public void addObserverTalkingPointAdded(ObserverTalkingPointAdded obs)
	{
		observerListC.add(obs);
	}


	/*******************************************************
	 * Purpose: calls update which notifies people of this policy
	 * being updated of keywords Added
	 ******************************************************/
	private void notifyObserverKeywordsAdded()
	{
		for(ObserverKeywordsAdded observer : observerListA)
		{
			observer.update(this);
		}
	}

	/*******************************************************
	 * Purpose: calls update which notifies people of this policy
	 * being updated of keywords Trending
	 ******************************************************/
	public void notifyObserverKeywordsTrending()
	{
		for(ObserverKeywordsTrending observer : observerListB)
		{
			observer.update(this);
		}
	}

	/*******************************************************
	 * Purpose: calls update which notifies people of this policy
	 * being updated of TalkingPoints Added
	 ******************************************************/
	private void notifyObserverTalkingPointAdded()
	{
		for(ObserverTalkingPointAdded observer : observerListC)
		{
			observer.update(this); //notify people
		}
	}

	/************************************************
	 * Purpose: Observer List accessor
	 * @return
	 ************************************************/
	public List<ObserverKeywordsAdded> getObserverListA()
	{
		return observerListA;
	}

	/************************************************
	 * Purpose: Observer List accessor
	 * @return
	 ************************************************/
	public List<ObserverKeywordsTrending> getObserverListB()
	{
		return observerListB;
	}

	/************************************************
	 * Purpose: Observer List accessor
	 * @return
	 ************************************************/
	public List<ObserverTalkingPointAdded> getObserverListC()
	{
		return observerListC;
	}

	public void checkTrending()
	{
		FacebookMessenger facebookMessenger = new FacebookChild(keywords);
		((FacebookChild) facebookMessenger).setPolicyArea(this);
		TwitterMessenger twitterMessenger = new TwitterChild(keywords);
		((TwitterChild) twitterMessenger).setPolicyArea(this);
	}

}
