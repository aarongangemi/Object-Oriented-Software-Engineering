package Assignment.Model;

import Assignment.Controller.FactoryClass;
import Assignment.Controller.ObserverTalkingPointAdded;

/*******************************************
 * Purpose: This is the Candidate Class. It is a subclass of Person.
 * The candidate stores the class and a method to add a notification which
 * will store a method to add a notification for the person
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 ****************************************/
public class Candidate extends Person
{

	/*********************************
	 * Purpose: To create the candidate
	 * @param name
	 **********************************/
	public Candidate(String name)
	{
		super(name);
		type = "Candidate";
		idNumber = ++count;
		//Create a person and store the type
	}

	/*******************************************
	 * Purpose: is to create a new TalkingPointNotification for the person
	 * create. This is then added to the observer list in policy area
	 * @param policyArea
	 */
	private void addTalkingPointNotification(PolicyArea policyArea)
	{
		ObserverTalkingPointAdded talkingPointAdded =
				FactoryClass.getTalkingPointAddedObserver(this);
		//Uses a factory to create the specified talking point
		policyArea.addObserverTalkingPointAdded(talkingPointAdded);
		//adds the talkingPoint notification the the observerList
	}

	/*****************************************
	 * Purpose: To add a talking point notification - > call above method
	 * @param policyArea
	 *****************************************/
	@Override
	public void addNotification(PolicyArea policyArea)
	{
		addTalkingPointNotification(policyArea);
	}
}
