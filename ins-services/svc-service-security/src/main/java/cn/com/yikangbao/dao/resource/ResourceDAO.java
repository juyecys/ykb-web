package cn.com.yikangbao.dao.resource;

import cn.com.yikangbao.dao.common.BaseDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import cn.com.yikangbao.entity.resource.Resource;

import java.util.List;

@Component
public interface ResourceDAO extends BaseDAO<Resource, Resource> {
    List<Resource> findResourceByRoleName(@Param("roleName") String roleName);
}
