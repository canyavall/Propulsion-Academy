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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import user.domain.User;

@Repository
public class JpaUserRepository implements UserRepository {

	//private final JdbcTemplate jdbcTemplate;
	private EntityManager entityManager;

	@Override
	public long count() {
		return entityManager
				  .createQuery("Select count(*) from User", Long.class)
				  .getSingleResult();
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public List<User> findAll() {
		return entityManager
				.createQuery("from User", User.class)
				.getResultList();
	}

	@Override
	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return entityManager
				.createQuery("from User u where u.firstName = :firstName and u.lastName = :lastName", User.class)
				.setParameter("firstName", firstName)
				.setParameter("lastName", lastName)
				.getSingleResult();
	}

	@Override
	public void deleteAll() {
		entityManager.createQuery("Delete from User");
	}

	@Override
	public void deleteById(Long id) {
		entityManager.createQuery("Delete from User u where u.id = :id")
			.setParameter("id", id)
			.executeUpdate();
	}
	
	@Override
	public User findFirstByLastName(String lastName) {
		return entityManager
				.createQuery("from User u where u.lastName = :lastName order by firstName", User.class)
				.setParameter("lastName", lastName)
				.setMaxResults(1)
				.getSingleResult();
	}

	@Override
	public List<User> findFirst10ByLastName(String lastName) {
		return entityManager
				.createQuery("from User u where u.lastName = :lastName order by firstName", User.class)
				.setParameter("lastName", lastName)
				.setMaxResults(10)
				.getResultList();
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
