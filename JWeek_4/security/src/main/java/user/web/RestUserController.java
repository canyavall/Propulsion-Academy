/*
 * Copyright 2016-2017 the original author or authors.
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

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import user.domain.User;
import user.service.UserService;

/**
 * Spring REST controller for the {@link User} domain entity.
 */
@RestController
@RequestMapping("/users")
public class RestUserController {

	private final UserService userService;

	@Autowired
	public RestUserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User retrieveUser(@PathVariable Long id) {
		return userService.findById(id);
	}

	@PostMapping
	public HttpEntity<Void> createUser(@RequestBody User postedUser) {
		User savedUser = userService.save(postedUser);

		// http://localhost:8080/users/
		// http://localhost:8080/users/{id}
		// http://localhost:8080/users/99

		UriComponents uriComponents = fromMethodCall(on(getClass()).retrieveUser(savedUser.getId())).build();

		return ResponseEntity.created(uriComponents.encode().toUri()).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void updateUser(@RequestBody User updatedUser, @PathVariable Long id) {
		userService.save(updatedUser);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteById(id);
	}

}
