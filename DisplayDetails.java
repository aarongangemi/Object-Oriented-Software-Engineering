package Assignment.View;
import java.util.*;
public class DisplayDetails
{
	public static void showContacts(Map<Integer, String> contactDetails)
	{
		for(String str : contactDetails.values())
		{
			System.out.print(" ," + str);
		}
		System.out.print("]");
		System.out.println();
	}

	public static void showData(String str)
	{
		System.out.println(str);
	}

}
