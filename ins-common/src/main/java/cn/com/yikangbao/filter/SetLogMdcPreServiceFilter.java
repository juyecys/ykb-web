package cn.com.yikangbao.filter;

import cn.com.yikangbao.contants.SystemConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

public class SetLogMdcPreServiceFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(SetLogMdcPreServiceFilter.class);

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		String logId = RpcContext.getContext().getAttachment(SystemConstants.TRACE_ID);
		MDC.put(SystemConstants.TRACE_ID, logId);
		logger.trace("set traceid {} in SetLogMdcPreServiceFilter", logId);
		return invoker.invoke(invocation);
	}
}
