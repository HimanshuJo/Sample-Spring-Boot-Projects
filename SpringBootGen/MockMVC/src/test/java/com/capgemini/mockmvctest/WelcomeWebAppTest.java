package com.capgemini.mockmvctest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WelcomeWebAppTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	// We have to write out expectations and the
	// expectations need to match with actuals
	// When this is run, it imitates and accesses
	// the web layer and get the output.
	public void testWelcome() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/").param("name", "Geeks"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attribute("welcome",
						"Welcome, Geeks to the world of programming!!!"))
				.andExpect(MockMvcResultMatchers.view().name("welcome-page"))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testWelcomeToEvent() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/event").param("name", "Geeks"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attribute("welcomeToEvent",
						"Welldone , Geeks You are selected to the contest!!!"))
				.andExpect(MockMvcResultMatchers.view().name("event-page"))
				.andDo(MockMvcResultHandlers.print());
	}

}