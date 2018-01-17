package cn.com.yikangbao.entity.common;

import java.util.Collections;
import java.util.List;

public class Page<E> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5874717906598880778L;
	private int pageSize = 10;
	private int totalPage;
	private int totalCount;
	private int start;
	private int nowPage;
	private List<E> result = Collections.emptyList();

	public Page() {
	}

	public Page(int pageSize, int nowPage) {
		this.pageSize = pageSize;
		this.nowPage = nowPage;
	}

	public int getStart() {
		start = (getNowPage() - 1) * getPageSize();
		if (start < 0) {
			start = 0;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getResult() {
		return result;
	}

	public void setResult(List<E> result) {
		this.result = result;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalPage() {
		return (int) Math.ceil(totalCount * 1.0 / pageSize);
	}

	public int getNowPage() {
		if (nowPage <= 0)
			nowPage = 1;
		return nowPage;
	}

	@Override
	public String toString() {
		return "Page{" +
				"pageSize=" + pageSize +
				", totalPage=" + totalPage +
				", totalCount=" + totalCount +
				", start=" + start +
				", nowPage=" + nowPage +
				", result=" + result +
				'}';
	}

}