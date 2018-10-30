package football.sharing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloFootballSharingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHelloWorld() {
		String check = "hello";
		assertEquals(check, "hello");
	}

}
