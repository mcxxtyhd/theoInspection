package com.theo.vo.common;

import java.io.Serializable;

/**
 * JSON 信息模型对象,用于前台操作信息响应
 * @author wzs
 *
 */
public class Json implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3487903139456458998L;
	
	private boolean success = false;// 是否成功
	private String msg = "";// 提示信息
	private Object obj = null;// 其他信息

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
