package Assignment.Model;
import Assignment.Controller.FactoryClass;
import Assignment.Controller.ObserverKeywordsAdded;
import Assignment.Controller.ObserverKeywordsTrending;
import Assignment.Controller.ObserverTalkingPointAdded;

/*******************************************
 * Purpose: A subclass of person which is created when user specifies
 * strategist
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 ********************************************/
public class Strategist extends Person
{
	/*************************************
	 * Purpose: Create a strategist
	 * @param name
	 **************************************/
	public Strategist(String name)
	{
		super(name); //Create a person using super
		type = "Strategist"; //Change type
		idNumber = ++count; //increment count and set as ID
	}

	/*****************************************
	 * Purpose: Use a factory to create new keyword trending observer.
	 * Then add it to the list of observer which can notify this person
	 * @param policyArea
	 ***************************************/
	private void addKeywordTrendingNotification(PolicyArea policyArea)
	{
		ObserverKeywordsTrending keywordTrending =
				FactoryClass.getKeywordTrendingObserver(this);
		//creation of observer using factory
		//then pass into list
		policyArea.addObserverKeywordsTrending(keywordTrending);
	}

	/*****************************************
	 * Purpose: Use a factory to create new keyword trending observer.
	 * Then add it to the list of observer which can notify this person
	 * @param policyArea
	 ***************************************/
	private void addTalkingPointNotification(PolicyArea policyArea)
	{
		ObserverTalkingPointAdded talkingPointAdded =
				FactoryClass.getTalkingPointAddedObserver(this);
		//creation of observer using factory
		//then pass into list
		policyArea.addObserverTalkingPointAdded(talkingPointAdded);
	}

	/****************************************
	 * Purpose: Calls private methods to add a notification for talkingPoint
	 * and KeywordTrending
	 * @param policyArea
	 ****************************************/
	public void addNotification(PolicyArea policyArea)
	{
		addKeywordTrendingNotification(policyArea);
		//creation of observer using factory
		//then pass into list
		addTalkingPointNotification(policyArea);
	}


}
