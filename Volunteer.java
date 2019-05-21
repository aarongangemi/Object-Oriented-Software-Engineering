package Assignment.Model;
import Assignment.Controller.FactoryClass;
import Assignment.Controller.ObserverKeywordsAdded;
import Assignment.Controller.ObserverKeywordsTrending;
import Assignment.Controller.ObserverTalkingPointAdded;
public class Volunteer extends Person
{
	/**************************************
	 * Purpose: Used to create a volunteer when the user specifies
	 * @param name
	 *******************************************/
	public Volunteer(String name)
	{
		super(name);
		type = "Volunteer";
		idNumber = ++count;
	}

	/*****************************************
	 * Purpose: Use a factory to create new keyword added observer.
	 * Then add it to the list of observer which can notify this person
	 * @param policyArea
	 ***************************************/
	private void addKeywordAddedNotification(PolicyArea policyArea)
	{
		ObserverKeywordsAdded keywordAdded =
				FactoryClass.getKeywordAddedObserver(this);
		//creation of observer using factory
		//then pass into list
		policyArea.addObserverKeywordsAdded(keywordAdded);
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
	 * Purpose: Use a factory to create new TalkingPoint observer.
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

	/***************************************
	 * Purpose: Calls above method to add notification for volunteer
	 * @param policyArea
	 ******************************************/
	@Override
	public void addNotification(PolicyArea policyArea)
	{
		addKeywordAddedNotification(policyArea);
		addKeywordTrendingNotification(policyArea);
		addTalkingPointNotification(policyArea);
	}


}
