package Assignment.Controller;

import Assignment.Model.*;

/***************************************
 * Purpose: The purpose of the factory class is to create objects of different
 * types. From this, each method will be called somewhere throughout my program.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2018
 **************************************/
public class FactoryClass
{
	/******************************************
	 * Purpose: To return the keywordAdded observer
	 * @param person
	 * @return
	 ********************************************/
	public static ObserverKeywordsAdded getKeywordAddedObserver(Person person)
	{
		ObserverKeywordsAdded ObserverKeywordsAdded = new KeywordAdded(person);
		return ObserverKeywordsAdded;
	}

	/***********************************************
	 * Purpose: To return the keywordTrending observer
	 * @param person
	 * @return
	 ****************************************************/
	public static ObserverKeywordsTrending getKeywordTrendingObserver
														(Person person)
	{
		ObserverKeywordsTrending observer = new KeywordTrending(person);
		return observer;
	}

	/***********************************************
	 * Purpose: To return the TalkingPointAdded observer
	 * @param person
	 * @return
	 ****************************************************/
	public static ObserverTalkingPointAdded getTalkingPointAddedObserver
														(Person person)
	{
		ObserverTalkingPointAdded observerC = new TalkingPointAdded(person);
		return observerC;
	}

	/***************************************************
	 * Purpose: is to take is the person name and type of person.
	 * From this, the type is checked to determine what type of person
	 * will be created. Then the person is constructed and returned
	 * @param name
	 * @param charType
	 * @return
	 ****************************************************/
	public Person createPerson(String name, char charType)
	{
		Person person = null;
		if(charType == 'V')
		{
			person = new Volunteer(name);
		}
		else if(charType == 'S')
		{
			person = new Strategist(name);
		}
		else if(charType == 'C')
		{
			person = new Candidate(name);
		}
		return person;
	}

	/*************************************************
	 * Purpose: To create a new Policy area
	 * @param policyName
	 * @return
	 *************************************************/
	public PolicyArea createPolicy(String policyName)
	{
		return new PolicyArea(policyName);
	}


}
