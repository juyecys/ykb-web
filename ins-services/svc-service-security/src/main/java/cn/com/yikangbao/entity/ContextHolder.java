package cn.com.yikangbao.entity;

import java.util.HashMap;
import java.util.Map;

import cn.com.yikangbao.entity.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 线程数据存取类（包含登录信息等）
 * 
 * @author xiaqiang
 *
 */
public class ContextHolder {
	private static ThreadLocal<HashMap<String, Object>> holder = new ThreadLocal<HashMap<String, Object>>() {
		@Override
		protected HashMap<String, Object> initialValue() {
			return new HashMap<>();
		}
	};

	private static final String KEY_USER = "user";
	private static final String KEY_MINI_PROGRAM_ACCOUNT = "mini_program_account";
	private static final String KEY_OPEN_ID = "open_id";
	private static final String KEY_UNION_ID = "union_id";

	private ContextHolder() {
	}
	/**
	 * 清除ThreadLocal中所有数据
	 */
	public static void clear() {
		holder.remove();
	}

	/**
	 * Map经历了初始化,一定不为null
	 * 
	 * @return
	 */
	public static Map<String, Object> getHolder() {
		return holder.get();
	}

	/**
	 * 存放数据
	 * 
	 * @param key
	 * @param data
	 */
	public static void setData(String key, Object data) {
		getHolder().put(key, data);
	}

	/**
	 * 获取数据
	 * 
	 * @param key
	 * @return
	 */
	public static Object getData(String key) {
		return getHolder().get(key);
	}

	public static void setUser(User user) {
		setData(KEY_USER, user);
	}

	public static User getUser() {
		User user = (User) getData(KEY_USER);
		if (user == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null) {
				Object obj = authentication.getPrincipal();
				if (obj instanceof User) {
					user = (User) obj;
				}
			}
		}
		return user;
	}

	public static void setOpenId(String openId) {
		setData(KEY_OPEN_ID, openId);
	}
	
	public static void setUnionId(String unionId) {
		setData(KEY_UNION_ID, unionId);
	}

}
