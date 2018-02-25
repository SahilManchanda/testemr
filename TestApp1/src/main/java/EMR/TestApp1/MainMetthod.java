package EMR.TestApp1;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class MainMetthod
{
  @SuppressWarnings("deprecation")
public static void main(String[] args)
  {
    TestListenerAdapter tla = new TestListenerAdapter();
    TestNG testng = new TestNG();
    testng.setTestClasses(new Class[] { App.class });
    testng.addListener(tla);
    testng.run();
  }
}
