package challenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import challenge.controllers.Api;

@RunWith(SpringRunner.class)
@WebMvcTest(Api.class)
@AutoConfigureMockMvc
public class GetTest {

	@MockBean
	Api api;

	 @Autowired
	  MockMvc mock;
	 
	 @Before
		public void run() throws Exception {
			this.mock.perform(post("/url").content("{\"url\": \"http://www.dailymail.co.uk\"}").contentType("application/json")).andExpect(status().isCreated());
					
		}
	
	 
	 @Test
		public void getTest() throws Exception {
			this.mock.perform(get("/url/1")).andExpect(status().isOk());
					
		}
	
}
