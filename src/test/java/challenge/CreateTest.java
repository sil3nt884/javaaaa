package challenge;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import challenge.controllers.Api;


@RunWith(SpringRunner.class)
@WebMvcTest(Api.class)
@AutoConfigureMockMvc
public class CreateTest {

	@MockBean
	Api api;

	 @Autowired
	  MockMvc mock;
	
	 
	 @Test
		public void createTest() throws Exception {
			this.mock.perform(put("/url/1").content("{\"id\": 1, \"url\": \"http://www.thisismoney.co.uk\"}").contentType("application/json")).andExpect(status().isOk());
					
		}

	
}
