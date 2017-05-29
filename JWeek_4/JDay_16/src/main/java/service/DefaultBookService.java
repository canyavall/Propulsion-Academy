package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Book;
import repository.BookRepository;

@Service
@Transactional(readOnly = true)
public class DefaultBookService implements BookService {

	private final BookRepository bookRepository;

	@Autowired
	public DefaultBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveBook(Book book) {
		this.bookRepository.save(book);
	}

	@Override
	public Book findById(Integer id) {
		return this.bookRepository.findById(id);
	}

	@Override
	public Book findByIsbn(String isbn) {
		return this.bookRepository.findByIsbn(isbn);
	}

	@Override
	public List<Book> findAllByAuthor(String author) {
		return this.bookRepository.findAllByAuthor(author);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Integer id) {
		this.bookRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteByIsbn(String isbn) {
		this.bookRepository.deleteByIsbn(isbn);
	}

}