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

package user.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

	User findFirstByLastNameOrderByFirstName(String lastName, Pageable pageable);
	
	List<User> findFirst10ByLastNameOrderByFirstName(String lastName, Pageable pageable);
	

}
