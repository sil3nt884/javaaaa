package challenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import challenge.controllers.Api;

@RunWith(SpringRunner.class)
@WebMvcTest(Api.class)
@AutoConfigureMockMvc
public class DeleteTest {


	@MockBean
	Api api;

	 @Autowired
	  MockMvc mock;
	 


	 
	 @Test
		public void getTest() throws Exception {
			this.mock.perform(get("/url/1")).andExpect(status().is(204));
					
		}
}
