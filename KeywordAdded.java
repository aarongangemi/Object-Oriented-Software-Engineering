package Assignment.Controller;
import Assignment.Model.Person;
import Assignment.Model.PolicyArea;

/*************************************
 * Purpose: is to act as a container class for the Observer of KeywordsAdded.
 * This class will keep track of a person which requires notification. More
 * specifically, keywordAdded acts as a link between the person and policy
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 */
public class KeywordAdded implements ObserverKeywordsAdded
{
	private Person person;  //person class field

	/************************************
	 * Purpose: The constructor sets the person here
	 * @param person
	 **************************************/
	public KeywordAdded(Person person)
	{
		this.person = person;
	}

	/**************************************
	 * Purpose: to notify the person about a policy area
	 * @param policyArea
	 ****************************************/
	@Override
	public void update(PolicyArea policyArea)
	{
		person.notifyPerson(policyArea.getName());
	}

	/*****************************************
	 * Purpose: To check if the person passed in and the person for
	 * keywordAdded are the same
	 * @param p
	 * @return
	 */
	@Override
	public boolean checkPerson(Person p)
	{
		return person.getIdNumber() == p.getIdNumber();
	}
}
