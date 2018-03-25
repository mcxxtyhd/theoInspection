package com.theo.vo.common;

public class BaseVo {
	private int id;
	private String ids;
	private int entid; // 企业ID
	private int page;// 当前页
	private int rows;// 每页显示记录数
	private String q;// 搜索条件
	public BaseVo() {
		super();
	}
	public BaseVo(int id, String ids, int entid, int page, int rows, String q) {
		super();
		this.id = id;
		this.ids = ids;
		this.entid = entid;
		this.page = page;
		this.rows = rows;
		this.q = q;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public int getEntid() {
		return entid;
	}
	public void setEntid(int entid) {
		this.entid = entid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	
}
