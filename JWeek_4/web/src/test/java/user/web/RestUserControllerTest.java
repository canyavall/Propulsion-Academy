package user.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import user.domain.User;
import user.repository.UserRepository;
import user.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.http.MediaType.*; //accept HSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc(print = MockMvcPrint.SYSTEM_ERR)
@Transactional
public class RestUserControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	

	@Autowired
	UserRepository repo;

	
	@Test
	public void retrieveAllUsers() throws Exception {
		mockMvc.perform(get("/users").accept(APPLICATION_JSON))
			.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
			.andExpect(status().isOk())//
			.andExpect(jsonPath("$[2]").exists())//
			.andExpect(jsonPath("$[?(@.lastName =~ /Smith/)].firstName",
					hasItems("John")));
	}
	
	@Test
	public void retrieveUser() throws Exception {
		mockMvc.perform(get("/users/1").accept(APPLICATION_JSON))
			.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
			.andExpect(status().isOk())//
			.andExpect(jsonPath("$[?(@.lastName =~ /Smith/)].firstName",
					hasItems("John")));
	}
	
	@Test
	public void createUser() throws Exception{
		String json = "{\"firstName\": \"Test\", \"lastName\": \"User\", \"age\": 99}";
		mockMvc.perform(post("/users/").contentType(APPLICATION_JSON)
			.content(json))
			.andExpect(status().isCreated());
	}
	
	@Test
	public void updateUser() throws Exception{
		String json = "{\"id\": \"1\",\"firstName\": \"asdasd\", \"lastName\": \"asdasd\", \"age\": 99}";
		mockMvc.perform(put("/users/1").contentType(APPLICATION_JSON).content(json))
			.andExpect(status().isNoContent());

		User updatedUser = repo.findOne(1L);
		assertThat(updatedUser.getLastName()).isEqualTo("asdasd");
	}
	

	@Test
	public void deleteUser() throws Exception {
		mockMvc.perform(delete("/users/{id}", 3))//
				.andExpect(status().isNoContent());

		User deletedUser = repo.findOne(3L);
		assertThat(deletedUser).isNull();
	}

}
