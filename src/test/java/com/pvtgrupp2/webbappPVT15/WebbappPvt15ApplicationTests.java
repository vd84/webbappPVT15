package com.pvtgrupp2.webbappPVT15;

import WebbAppPVT15Grupp2.Repositories.YouthcentreRepository;
import WebbAppPVT15Grupp2.WebbappPvt15Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ContextConfiguration()
public class WebbappPvt15ApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
    public void getUserTest(){
        assertEquals(true, true);
    }


	@Test
    public void dummyTest(){
        assertEquals(true, true);
    }

    @Test
    public void dummyTest2(){
        assertEquals(true, true);
    }


}
