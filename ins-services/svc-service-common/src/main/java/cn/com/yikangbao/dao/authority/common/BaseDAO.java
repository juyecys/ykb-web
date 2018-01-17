package cn.com.yikangbao.dao.authority.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<M,QM>{
	
	void create(M m);
	int update(M m);
	void deleteById(@Param("id") Object id);
	void deleteByIds(Object[] ids);

	M findById(@Param("id") Object id);
	List<QM> getList();
	List<QM> findByConditionPage(QM qm);

	boolean isExistById(@Param("id") Object id);

}
