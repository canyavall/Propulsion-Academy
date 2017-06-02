/*
 * Copyright 2010-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package user.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import user.domain.User;
import user.repository.UserRepository;

/**
 * Spring MVC integration tests for the {@link RestUserController}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc(print = MockMvcPrint.SYSTEM_ERR)
@Transactional
public class RestUserControllerTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserRepository repo;

	@Test
	public void retrieveAllUsers() throws Exception {
		mockMvc.perform(get("/users").accept(APPLICATION_JSON))//
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))//
				.andExpect(status().isOk())//
				.andExpect(jsonPath("$[2]").exists())//
				.andExpect(jsonPath("$[?(@.firstName =~ /J.+/)].firstName", hasItems("John", "Jane")));
	}

	@Test
	public void retrieveUser() throws Exception {
		mockMvc.perform(get("/users/{id}", 3).accept(APPLICATION_JSON))//
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))//
				.andExpect(status().isOk())//
				.andExpect(jsonPath("$.id", is(3)))//
				.andExpect(jsonPath("$.firstName", is("Jane")))//
				.andExpect(jsonPath("$.lastName", is("Doe")))//
				.andExpect(jsonPath("$.age", is(36)));
	}

	@Test
	public void retrieveNonexistentUser() throws Exception {
		mockMvc.perform(get("/users/{id}", 12345).accept(APPLICATION_JSON))//
				.andExpect(status().isNotFound());
	}

	@Test
	public void createUser() throws Exception {

		String json = "{\"firstName\": \"Test\", \"lastName\": \"User\", \"age\": 99}";

		mockMvc.perform(post("/users/").contentType(APPLICATION_JSON)//
				.content(json))//
				.andExpect(status().isCreated());
	}

	@Test
	public void updateUser() throws Exception {

		String json = "{\"id\": 3, \"firstName\": \"Jane\", \"lastName\": \"Edited\", \"age\": 36}";

		mockMvc.perform(put("/users/{id}", 3).contentType(APPLICATION_JSON).content(json))//
				.andExpect(status().isNoContent());

		User updatedUser = repo.findOne(3L);
		assertThat(updatedUser.getLastName()).isEqualTo("Edited");
	}

	@Test
	public void deleteUser() throws Exception {
		mockMvc.perform(delete("/users/{id}", 3))//
				.andExpect(status().isNoContent());

		User deletedUser = repo.findOne(3L);
		assertThat(deletedUser).isNull();
	}

}
