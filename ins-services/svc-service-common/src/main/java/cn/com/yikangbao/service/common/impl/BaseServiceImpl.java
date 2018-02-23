package cn.com.yikangbao.service.common.impl;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.common.Base;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.service.common.BaseService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BaseServiceImpl<M extends Base, QM extends M>  implements BaseService<M, QM> {
    private BaseDAO dao = null;

    public void setDAO(BaseDAO dao){
        this.dao = dao;
    }

    @Override
    public M create(M entity) {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatedDate(new Date());
        dao.create(entity);
        return entity;
    }

    @Override
    public M update(M entity) {
        entity.setUpdatedDate(new Date());
        dao.update(entity);
        return entity;
    }

    @Override
    public M createOrUpdate(M entity) throws Exception {
        if (entity.getId() == null) {
            return create(entity);
        }
        return update(entity);
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }

    @Override
    public List<QM> findByCondition(QM qm) {
        List<QM> list = dao.findByCondition(qm);
        if (!list.isEmpty()) {
            for (QM one: list) {
                one.setPage(null);
            }
        }
        return list;
    }

    @Override
    public Page<QM> findByConditionPage(QM qm) {
        if (qm.getPage() == null) {
            qm.setPage(new Page(10));
        }
        List<QM> list = dao.findByConditionPage(qm);
        qm.getPage().setResult(list);
        return qm.getPage();
    }

    @Override
    public QM findOneByCondition(QM qm) {
        return (QM) dao.findOneByCondition(qm);
    }
}
