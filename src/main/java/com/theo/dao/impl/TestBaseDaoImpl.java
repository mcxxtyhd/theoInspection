package com.theo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.theo.dao.AnnotatedHibernateDaoSupport;
import com.theo.dao.TestBaseDaoI;

@Repository("testBaseDao")
public class TestBaseDaoImpl extends AnnotatedHibernateDaoSupport implements TestBaseDaoI{

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(String hql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find(hql);
	}

}
