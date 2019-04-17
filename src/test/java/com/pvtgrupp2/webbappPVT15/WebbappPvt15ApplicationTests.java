package com.pvtgrupp2.webbappPVT15;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
    public void dummyTest(){
        assertEquals(true, false);
    }

    @Test
    public void dummyTest2(){
        assertEquals(true, false);
    }


}
