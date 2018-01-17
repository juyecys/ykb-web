package cn.com.yikangbao.service.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/17.
 */
public interface BaseService<T, ID extends Serializable> {
    public T create(T entity);

    public T update(T entity);

    public T findById(ID id);

    public void deleteById(ID id);

    public Iterable<T> findAll();

    public long count();

    public boolean isExistsById(ID id);
}

