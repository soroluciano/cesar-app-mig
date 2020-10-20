package distcenter.api.controller;

import java.text.ParseException;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import admin.api.repo.AdminRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration("application-context-test.xml")
public class RepositoryTests {
	

	@Autowired AdminRepository conciliacionRepository;
	@Autowired EntityManager em;
	
	@Test
	public void testCon() throws ParseException {

		//ConciliacionController c = new ConciliacionController(conciliacionServiceRest);
	}
	


}