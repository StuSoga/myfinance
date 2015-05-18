package com.mf.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<T> find(String queryString) {

		return (List<T>) getHibernateTemplate().execute(
				new HibernateCallback<T>() {
					@Override
					public T doInHibernate(org.hibernate.Session session)
							throws org.hibernate.HibernateException {
						Query query = session.createQuery(queryString);
						List<T> rows = query.list();
						return (T) rows;
					}
				});
	}

	public T findUnique(String queryString) {

		return getHibernateTemplate().execute(new HibernateCallback<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public T doInHibernate(org.hibernate.Session session)
					throws org.hibernate.HibernateException {
				Query query = session.createQuery(queryString);
				T row = (T) query.uniqueResult();
				return row;
			}
		});
	}

	public T save(T model) {

		return getHibernateTemplate().execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(org.hibernate.Session session)
					throws org.hibernate.HibernateException {
				session.save(model);
				return null;
			}
		});
	}

	public void update(T model) {

		getHibernateTemplate().execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(org.hibernate.Session session)
					throws org.hibernate.HibernateException {
				session.update(model);
				return null;
			}
		});
	}

	public void delete(T model) {

		getHibernateTemplate().execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(org.hibernate.Session session)
					throws org.hibernate.HibernateException {
				session.delete(model);
				return null;
			}
		});
	}

}
