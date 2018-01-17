package cn.com.yikangbao.service.common;

import cn.com.yikangbao.entity.common.Base;
import cn.com.yikangbao.entity.common.Page;

import java.util.List;


/**
 * Created by Administrator on 2018/1/17.
 */
public interface BaseService<M extends Base,QM extends M> {
    M create(M entity);

    M update(M entity);

    void deleteById(String id);

    List<QM> findAll();

    Page<QM> getByConditionPage(QM qm);

    QM findOneByCondition(QM qm);
}

