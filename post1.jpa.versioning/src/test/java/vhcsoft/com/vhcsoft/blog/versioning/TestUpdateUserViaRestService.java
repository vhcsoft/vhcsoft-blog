package vhcsoft.com.vhcsoft.blog.versioning;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUpdateUserViaRestService {

	@Sql("user.sql")
	public void updateUser() {
		
	}
 }
