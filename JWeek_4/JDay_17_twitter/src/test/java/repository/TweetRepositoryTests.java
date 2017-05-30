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

package repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import config.RepositoryConfig;
import config.TestDataAccessConfig;
import domain.Tweet;
import org.junit.runners.MethodSorters;

/**
 * Integration tests for the {@link JdbcTweetRepository}, running
 * against the <em>production</em> database.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataAccessConfig.class, RepositoryConfig.class })
@ActiveProfiles("dev")
@Transactional
@Sql("/test-data.sql")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TweetRepositoryTests {

	private int NUM_ROWS = 5;

	@Autowired
	TweetRepository repository;

	@Test 
	public void findById() {
		assertNumTweets(NUM_ROWS);
		Integer id = repository.findAll().get(0).getId();
		Tweet tweet = repository.findById(id);
		assertThat(tweet.getAuthor()).isEqualTo("jsmith");
		assertThat(tweet.getText()).isEqualTo("Hello, World!");
	}
	
	@Test
	public void findAll() {
		assertNumTweets(NUM_ROWS);
		assertThat(repository.count()).isEqualTo((repository.findAll().size()));		
	}
	
	@Test
	public void findAllByUsernameWithExactMatch() {
		List<String> tweetTexts = repository.findAllByUsername("jsmith")
				.stream()
				.map(Tweet::getText)
				.collect(toList());
		assertThat(tweetTexts).containsExactlyInAnyOrder("Hello, World!", "Progamming is fun", "#Spring makes develping #Java apps easier", "#JUnit makes testing #Java apps easier", "@SpringFramework 4.3.6 released! #Java #Spring");
	}

	@Test
	public void findAllContainingWithExactMatch() {
		List<String> tweetTexts = repository.findAllContaining("World")
				.stream()
				.map(Tweet::getText)
				.collect(toList());
		assertThat(tweetTexts).containsExactly("Hello, World!");
	}

	@Test
	public void findAllUsernames() {
		assertThat(repository.findAllUsernames()).containsExactlyInAnyOrder("jsmith");
	}
	
	@Test
	public void deleteById() {
		assertNumTweets(NUM_ROWS);
		repository.deleteById(repository.findAll().get(0).getId());
		assertNumTweets(NUM_ROWS-1);
	}
	
	@Test
	public void save() {
		assertNumTweets(NUM_ROWS);
		repository.save(new Tweet("jsmith", "Hello, Twitter!"));
		assertNumTweets(NUM_ROWS + 1);
	}


	@Test
	public void deleteAll() {
		assertNumTweets(NUM_ROWS);
		repository.deleteAll();
		assertNumTweets(0);
	}


	private void assertNumTweets(int expected) {
		assertThat(repository.count()).isEqualTo(expected);
	}

}
