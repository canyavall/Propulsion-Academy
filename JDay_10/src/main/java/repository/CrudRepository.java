package repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, ID extends Serializable> {

	void save(T entity, ID id);

	T findById(ID id);

	List<T> findAll();

	void deleteById(ID id);

	void deleteAll();

}