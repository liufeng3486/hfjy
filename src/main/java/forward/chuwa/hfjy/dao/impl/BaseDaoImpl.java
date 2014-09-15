package forward.chuwa.hfjy.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	public final Class<T> modelClass;

	public final String HQL_FIND;

	public final String HQL_COUNT;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		super();
		modelClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		HQL_FIND = "from " + modelClass.getSimpleName() + " t where 1 = 1 {0} ";
		HQL_COUNT = "select count(*) from " + modelClass.getSimpleName()
				+ " t where 1 = 1 {0} ";
	}

	protected Query setParams(Query query, List<?> params) {
		if (params != null) {
			for (int i = 0; i < params.size(); ++i) {
				if (params.get(i) instanceof Collection) {
					query.setParameterList("p" + (i + 1),
							(Collection<?>) params.get(i));
				} else {
					query.setParameter("p" + (i + 1), params.get(i));
				}
			}
		}

		return query;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public T load(Long id) {
		return (T) getSession().load(modelClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public T get(Long id) {
		return (T) getSession().get(modelClass, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T save(T obj) {
		getSession().save(obj);
		return obj;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T update(T obj) {
		getSession().update(obj);
		return obj;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T saveOrUpdate(T obj) {
		getSession().saveOrUpdate(obj);
		return obj;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(T obj) {
		getSession().delete(obj);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		delete(load(id));
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> find(String condition) {
		return getSession().createQuery(
				MessageFormat.format(HQL_FIND, condition)).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> find(String condition, List<?> params) {
		Query query = getSession().createQuery(
				MessageFormat.format(HQL_FIND, condition));
		return setParams(query, params).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> find(String condition, int start, int length) {
		return getSession()
				.createQuery(MessageFormat.format(HQL_FIND, condition))
				.setFirstResult(start).setMaxResults(length).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<T> find(String condition, List<?> params, int start, int length) {
		Query query = getSession().createQuery(
				MessageFormat.format(HQL_FIND, condition));
		return setParams(query, params).setFirstResult(start)
				.setMaxResults(length).list();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count(String condition) {
		return (Long) getSession().createQuery(
				MessageFormat.format(HQL_COUNT, condition)).uniqueResult();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count(String condition, List<?> params) {
		Query query = getSession().createQuery(
				MessageFormat.format(HQL_COUNT, condition));
		return (Long) setParams(query, params).uniqueResult();
	}


	
}