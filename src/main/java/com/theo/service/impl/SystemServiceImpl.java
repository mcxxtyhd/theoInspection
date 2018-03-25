package com.theo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.theo.dao.BaseDaoI;
import com.theo.model.system.TSUser;
import com.theo.service.SystemServiceI;
import com.theo.vo.system.PageUser;

@Service("systemService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
public class SystemServiceImpl implements SystemServiceI{

	@Resource
	private BaseDaoI baseDao;
	
	public BaseDaoI getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoI baseDao) {
		this.baseDao = baseDao;
	}
	
	@SuppressWarnings("unchecked")
	public TSUser checkUserExits(PageUser user) {
	    List users = baseDao.find("from TSUser u where u.username = '" + user.getUsername() + "' and u.password='" + user.getPassword() + "'");
	    if ((users != null) && (users.size() > 0)){
	    	return ((TSUser)users.get(0));
	    }
	    return null;
	}
	
	public <T> List<T> findByProperty(Class<T> paramClass, String paramString,Object paramObject) {
		return this.baseDao.findByProperty(paramClass, paramString, paramObject);
	}

}
