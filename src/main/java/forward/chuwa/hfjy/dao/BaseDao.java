package forward.chuwa.hfjy.dao;

import java.util.List;

public interface BaseDao<T> {
	public T load(Long id);
	
	public T get(Long id);

	public T save(T obj);

	public T update(T obj);

	public T saveOrUpdate(T obj);

	public void delete(T obj);

	public void delete(Long id);

	public List<T> find(String condition);

	public List<T> find(String condition, List<?> params);

	public List<T> find(String condition, int start, int length);

	public List<T> find(String condition, List<?> params, int start, int length);

	public Long count(String condition);

	public Long count(String condition, List<?> params);
}
