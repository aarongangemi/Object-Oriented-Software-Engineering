package Assignment.Controller;
import Assignment.Controller.ObserverKeywordsAdded;
import Assignment.Controller.ObserverKeywordsTrending;
import Assignment.Model.Person;
import Assignment.Model.PolicyArea;

public class KeywordTrending implements ObserverKeywordsAdded,
										ObserverKeywordsTrending
{
	private Person person;

	public KeywordTrending(Person person)
	{
		this.person = person;
	}

	@Override
	public void update(PolicyArea policyArea)
	{
		person.isTrending(policyArea.getName());
	}

	@Override
	public boolean checkPerson(Person p)
	{
		return p.getIdNumber() == person.getIdNumber();
	}

}
