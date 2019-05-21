package Assignment.Controller;
import Assignment.Model.Person;
import Assignment.Model.PolicyArea;

/****************************************
 * Purpose: The purpose of TalkingPointAdded is to act as a
 * concrete class for the observer. This will connect the person to
 * the observer
 ***********************************************/
public class TalkingPointAdded implements ObserverTalkingPointAdded
{
	private Person person;

	/**********************************
	 * Purpose: To set the person.
	 * @param person
	 *************************************/
	public TalkingPointAdded(Person person)
	{
		this.person = person;
	}

	/************************************
	 * Purpose: The purpose of update() is to notify the person about
	 * the policy that has been updated.
	 * @param policyArea
	 ***************************************/
	@Override
	public void update(PolicyArea policyArea)
	{
		person.notifyPerson(policyArea.getName());
	}

	/***********************************
	 * Purpose: to check the person passed in is the same as the person
	 * in the observer
	 * @param p
	 * @return
	 *****************************************/
	@Override
	public boolean checkTalkingPoints(Person p)
	{
		return p.getIdNumber() == person.getIdNumber();
	}
}
