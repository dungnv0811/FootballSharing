package football.sharing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class HelloFootballSharingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHelloWorld() {
		String check = "hello world";
		assertEquals(check, "hello world");
	}

}
