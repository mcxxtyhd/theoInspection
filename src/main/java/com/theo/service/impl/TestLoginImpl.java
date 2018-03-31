package com.theo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.theo.dao.TestBaseDaoI;
import com.theo.model.system.TSUser;
import com.theo.service.TestLoginI;

@Service("testLoginMethod")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
public class TestLoginImpl implements TestLoginI{

	@Resource
	private TestBaseDaoI testBaseDao;
	
	public TestBaseDaoI getTestBaseDao() {
		return testBaseDao;
	}

	public void setTestBaseDao(TestBaseDaoI testBaseDao) {
		this.testBaseDao = testBaseDao;
	}

	@Override
	public String getUserEmail(String username, String password) {
		
		List users=testBaseDao.find("from TSUser u where u.username='"+username+"' and u.password='"+password+"'");
		if ((users!=null) &&(users.size()>0)){
			TSUser user=(TSUser) users.get(0);
			return user.getEmail();
		}
		else{
			return "we didn't find this user";
		}
	}

}
