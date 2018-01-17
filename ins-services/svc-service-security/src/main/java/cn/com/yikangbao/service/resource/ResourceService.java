package cn.com.yikangbao.service.resource;

import cn.com.yikangbao.service.common.BaseService;
import cn.com.yikangbao.entity.resource.Resource;

import java.util.List;

public interface ResourceService extends BaseService<Resource, Resource> {
    List<Resource> findResourceByRoleName(String name);
}
