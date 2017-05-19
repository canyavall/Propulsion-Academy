package repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractCrudRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {

	private final Map<ID, T> database = new LinkedHashMap<>();

	@Override
	public void save(T entity, ID id) {
		this.database.put(id, entity);
	}

	@Override
	public T findById(ID id) {
		return this.database.get(id);
	}

	@Override
	public List<T> findAll() {
		return new ArrayList<>(this.database.values());
	}

	@Override
	public void deleteById(ID id) {
		this.database.remove(id);
	}

	@Override
	public void deleteAll() {
		this.database.clear();
	}

}
