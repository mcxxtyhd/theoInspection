package com.theo.dao;

import java.util.List;

public interface TestBaseDaoI {
	<T> List<T> find(String hql);
}
