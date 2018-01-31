package cn.com.yikangbao.interceptor;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2018/1/17.
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class
        })
})
public class AuditableInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuditableInterceptor.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        Object result = null;

        if (target instanceof Executor) {
            long start = System.currentTimeMillis();
            Method method = invocation.getMethod();
            /**执行方法*/
            result = invocation.proceed();
            long end = System.currentTimeMillis();
            final Object[] args = invocation.getArgs();

            //获取原始的ms
            MappedStatement ms = (MappedStatement) args[0];
            String commandName = ms.getSqlCommandType().name();

            Object parameterObject = args[1];
            BoundSql boundSql = ms.getBoundSql(parameterObject);
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            //String parameterObjects = mapper.writeValueAsString(boundSql.getParameterObject());
            Object parameterObjects = boundSql.getParameterObject();
            logger.debug("parameterObjects: {}", parameterObjects);
            if (commandName.startsWith("INSERT")) {
                if (parameterObjects instanceof Base) {
                    Base base = (Base) parameterObjects;
                   // base.setCreatedBy();
                    base.setCreatedDate(new Date());
                }
                /*Base base = mapper.readValue(parameterObjects, Base.class);
                base.setCreatedDate(new Date());*/
            } else if (commandName.startsWith("UPDATE")) {

            } else if (commandName.startsWith("DELETE")) {

            } else if (commandName.startsWith("SELECT")) {
            }


        }
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
