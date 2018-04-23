package com.jungleegames.game.server.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This test class logs in a few users. Ask them to join tables , checks if game starts and then disconnects them.
 * @author naveen.upadhyay
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(GameServerController.class)
@WebAppConfiguration
public class GameServerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	@WithMockUser(username = "user1", password = "pwd", roles = "USER")
	public void testGameFlow() {
		
	}
}
