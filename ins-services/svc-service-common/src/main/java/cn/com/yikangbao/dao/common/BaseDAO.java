package cn.com.yikangbao.dao.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<M,QM>{
	
	void create(M m);

	int update(M m);

	void deleteById(@Param("id") String id);

	QM findById(@Param("id") String id);

	List<QM> findAll();

	List<QM> findByConditionPage(QM qm);

	QM findOneByCondition(QM qm);
}
