package cn.com.yikangbao.filter;

import cn.com.yikangbao.contants.SystemConstants;
import org.slf4j.MDC;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

public class SetTraceIdPreRpcFilter implements Filter {
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		invocation.getAttachments().put(SystemConstants.TRACE_ID, MDC.get(SystemConstants.TRACE_ID));

		return invoker.invoke(invocation);
	}
}
