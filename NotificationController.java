package Assignment.Controller;

import Assignment.Model.Person;
import Assignment.Model.PersonIDException;
import Assignment.Model.PolicyArea;
import Assignment.Model.PolicyExistsException;
import Assignment.View.MenuClass;

import java.util.*;

/*********************************************
 * Purpose: The notification class is a combination of both static and
 * non-static methods. The static methods of this class are the
 * factories which return objects representing the event of the
 * notification. The non-static method is used to create a notification
 * and then add a policy.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 **********************************************/
public class NotificationController
{
	private MenuClass menuObj;

	public NotificationController(MenuClass menuObj)
	{
		this.menuObj = menuObj;
	}

	/*****************************************************
	 * Purpose: The function asks for the Person ID and policy name.
	 * This information is then validated and then adds a notification
	 * based on input.
	 * @throws PersonIDException
	 * @throws PolicyExistsException
	 *********************************************************/
	public void createNotification(Map<Integer, Person> personMap, Map<String, PolicyArea> policyAreaMap) throws PersonIDException, PolicyExistsException
	{
		int personID = menuObj.getPersonID();
		String policyName = menuObj.getInputData("Policy Name");
		PolicyArea policyArea;
		//Get the Person ID
		if (!personMap.containsKey(personID))
		{
			throw new PersonIDException("Person doesn't exist");
			//If the ID doesn't exist in the map of people,
			// then throw exception
		}
		//if the ID is valid, then get the policy name
		if (!policyAreaMap.containsKey(policyName))
		{
			throw new PolicyExistsException("Policy doesn't exist");
			//If the map of policies doesn't contain the policy entered,
			//then throw an exception
		}
		policyArea = policyAreaMap.get(policyName);
		personMap.get(personID).addNotification(policyArea);
		//add the notification for the person and policy
	}

	/******************************************************
	 * Purpose: The purpose of removeNotification() is to remove the
	 * notification upon specifying the policy area and person to delete from.
	 * The method will loop through each policy area and each observer and find
	 * any observers matching the criteria.
	 * @param policyAreaMap
	 * @param personMap
	 * @throws PolicyExistsException
	 * @throws PersonIDException
	 **********************************************************/
	public void removeNotification( Map<String, PolicyArea> policyAreaMap,
									Map<Integer, Person> personMap)
							throws PolicyExistsException, PersonIDException
	{
		int personID = menuObj.getPersonID();
		String policyName = menuObj.getInputData("Policy Name");
		PolicyArea policyArea = policyAreaMap.get(policyName);
		if (policyAreaMap.containsKey(policyArea.getName()))
		{
			//check policy exists
			if (personMap.containsKey(personID))
			{
				PolicyArea policy = policyAreaMap.get(policyArea.getName());
				//go through every policy
				for (ObserverKeywordsAdded obs : policy.getObserverListA())
				{
					//go through every observer
					if (obs.checkPerson(personMap.get(personID)))
					{
						policy.removeObserverKeywordAdded(obs);
						//remove
						break;
					}
				}
				//Both are same as above
				for (ObserverKeywordsTrending obs : policy.getObserverListB())
				{
					if (obs.checkPerson(personMap.get(personID)))
					{
						policy.removeObserverKeywordTrending(obs);
						break;
					}
				}
				for (ObserverTalkingPointAdded obs : policy.getObserverListC())
				{
					if (obs.checkTalkingPoints(personMap.get(personID)))
					{
						policy.removeObserverTalkingPointAdded(obs);
						break;
					}
				}
			}
			else
			{
				throw new PersonIDException("Person ID doesn't exist");
			}
		}
		else
		{
			throw new PolicyExistsException("Policy doesn't exist");
		}
	}

}
