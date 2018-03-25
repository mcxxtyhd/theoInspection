package com.theo.service;

import java.util.List;

import com.theo.model.system.TSUser;
import com.theo.vo.system.PageUser;

public interface SystemServiceI {
	
	//验证用户是否存在
	TSUser checkUserExits(PageUser user);
	
	//查询对象类列表
	<T> List<T> findByProperty(Class<T> paramClass, String paramString, Object paramObject);
		
}
