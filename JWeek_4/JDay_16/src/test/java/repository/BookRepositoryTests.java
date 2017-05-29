package repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import config.TestDataAccessConfig;
import domain.Book;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataAccessConfig.class, RepositoryConfig.class })
@ActiveProfiles("dev")
@Sql("/test-data.sql")
@Transactional
public class BookRepositoryTests {

	/**
	 * Number of books inserted in test-data.sql
	 */
	private static final int NUM_BOOKS = 100;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * "Can't Wait for Summer" is assigned ID #1 in test-data.sql.
	 */
	Book summer = new Book(1, "978-3-16-148410-0", "Angelica", "Can't Wait for Summer", 120);
	Book spring = new Book("978-0-59-680193-9", "Sam Brannen", "Spring in a Nutshell", 700);

	@Test
	public void save() {
		assertNumBooks(NUM_BOOKS);

		bookRepository.save(spring);
		assertNumBooks(NUM_BOOKS + 1);
	}

	@Test
	public void count() {
		assertNumBooks(NUM_BOOKS);
		assertThat(bookRepository.count()).isEqualTo(NUM_BOOKS);
	}

	@Test
	public void deleteById() {
		assertNumBooks(NUM_BOOKS);

		bookRepository.deleteById(summer.getId());
		assertNumBooks(NUM_BOOKS - 1);
	}

	@Test
	@Sql(statements = "insert into book(isbn, author, title, num_pages) values('111', 'Angelica', 'Cannot Wait for Summer', 120)")
	@Sql(statements = "insert into book(isbn, author, title, num_pages) values('222', 'Bart', 'Cannot Wait for Springfield', 10)")
	@Sql(statements = "delete from book", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void deleteByIsbn() {
		assertNumBooks(2);
		assertThat(bookRepository.findByIsbn("111")).isNotNull();
		assertThat(bookRepository.findByIsbn("222")).isNotNull();

		bookRepository.deleteByIsbn("111");
		assertNumBooks(1);
		bookRepository.deleteByIsbn("222");
		assertNumBooks(0);
	}

	@Test
	public void findById() {
		assertNumBooks(NUM_BOOKS);

		assertThat(bookRepository.findById(summer.getId())).isEqualTo(summer);
	}

	@Test
	public void findByIsbn() {
		assertNumBooks(NUM_BOOKS);

		assertThat(bookRepository.findByIsbn(summer.getIsbn())).isEqualTo(summer);
	}

	@Test
	public void findAll() {
		assertNumBooks(NUM_BOOKS);
		bookRepository.save(spring);
		assertNumBooks(NUM_BOOKS + 1);

		assertThat(bookRepository.findAll()).contains(summer, spring);
	}

	@Test
	public void findAllByAuthor() {
		assertNumBooks(NUM_BOOKS);
		bookRepository.save(spring);
		assertNumBooks(NUM_BOOKS + 1);

		assertThat(bookRepository.findAllByAuthor(summer.getAuthor())).containsExactly(summer);
	}

	private void assertNumBooks(int expected) {
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "book")).isEqualTo(expected);
	}

}