package Assignment.Controller;
import Assignment.Model.Person;
import Assignment.Model.PersonIDException;
import Assignment.Model.PolicyArea;
import Assignment.Model.PolicyExistsException;
import Assignment.View.MenuClass;
import java.util.*;

/****************************************************
 * Purpose: The remove class is a subclass of the menu option interface.
 * It contains all the methods to implement the removal of a person,
 * policy area, talking point or keyword. This class implements the
 * MenuOptionInterface
 *********************************************************/
public class RemoveController implements MenuOptionInterface
{
	private MenuClass menuObj;

	public RemoveController(MenuClass menuObj)
	{
		this.menuObj = menuObj;
	}
	@Override
	public void runPersonOption(Map<Integer,Person> personMap,
								Map<String, PolicyArea> policyAreaMap)
								throws PersonIDException
	{
		int removalID = menuObj.getPersonID();
		if(personMap.containsKey(removalID))
		{
			for(PolicyArea policyArea : policyAreaMap.values())
				//loop through all policy areas
			{
				policyArea.removePersonNotifications(personMap.get(removalID));
				//remove all notifications
			}
			personMap.remove(removalID); //Then remove person with ID from map
		}
		else
		{
			throw new PersonIDException("Person ID doesn't exist");
		}

	}

	/**********************************************
	 * Purpose: is to remove the specified policy from the map.
	 * The method first asks for confirmation to delete then call remove()
	 * @param policyAreaMap
	 * @throws PolicyExistsException
	 ************************************************/
	@Override
	public void runPolicyAreaOption(Map<String, PolicyArea> policyAreaMap)
									throws PolicyExistsException
	{
		boolean deletePolicy;
		String policyName = menuObj.getInputData("Policy name"); //get name
		if(!policyAreaMap.containsKey(policyName))
		{
			throw new PolicyExistsException("The specified policy doesn't " +
													"exist, please try again");
			//throw exception if policy doesn't exist
		}
		else
		{
			deletePolicy = menuObj.confirmPolicyRemoval(policyAreaMap.get
														(policyName));
			//Ask for removal, delete policy returns a boolean representing
			// true/false
			if (deletePolicy)
			{
				policyAreaMap.remove(policyName);
				//remove policy
			}
		}
	}

	/********************************************
	 * Purpose: is to remove the specified talking point from the map
	 * @param policyAreaName
	 * @param policyAreaMap
	 * @throws PolicyExistsException
	 ***********************************************/
	@Override
	public void runTalkingPointOption(String policyAreaName,
									  Map<String, PolicyArea> policyAreaMap)
										throws PolicyExistsException
	{
		if(policyAreaMap.containsKey(policyAreaName))
		{
			//check policy exists
			String talkingPoint = menuObj.getInputData("Talking Point");
			//get the talking point name
			policyAreaMap.get(policyAreaName).getTalkingPoints().remove
					(talkingPoint);
			//remove talking point
		}
		else
		{
			throw new PolicyExistsException("Policy name doesn't exist");
		}
	}

	/*************************************************
	 * Purpose: To remove the specified keyword from the specified policy area
	 * @param policyAreaName
	 * @param policyAreaMap
	 * @throws PolicyExistsException
	 ***************************************************/
	public void runKeywordOption(String policyAreaName,
								 Map<String, PolicyArea> policyAreaMap)
									throws PolicyExistsException
	{
		if(policyAreaMap.containsKey(policyAreaName))
		{
			//check policy exists
			String keyword = menuObj.getInputData("Keyword");
			//get the keyword
			policyAreaMap.get(policyAreaName).getKeywords().remove
					(keyword);
		}
		else
		{
			throw new PolicyExistsException("Policy name doesn't exist");
			//Throw exception if policy doesn't exist
		}
	}


}
