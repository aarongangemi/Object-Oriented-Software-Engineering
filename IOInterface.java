package Assignment.Controller;

import java.util.*;

/******************************************
 * Purpose: The IOInterface is the interface to implement the stubs for the
 * save and load stubs. Each subclass if implemented, would have save and
 * load functionality.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 *******************************************/
public interface IOInterface
{
	void IOOption(Map<String, IOInterface> IOMap, String fileName);
}
