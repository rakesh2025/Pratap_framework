package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class XMLdata {
	
	@Test
	public void xml(XmlTest xmlobj)
	{
		System.out.println(xmlobj.getParameter("browser"));
	}

}
