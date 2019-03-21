package tv.buka.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class BaseResp extends HashMap<String,Object> {

	private static final long serialVersionUID = 1L;

	public BaseResp() {

	}
	public static BaseResp ok() {
		BaseResp baseResp = new BaseResp();
		baseResp.put("errorcode",0);
		return baseResp;
	}

	public static BaseResp verification_failed() {
		return error(-10,"身份验证失败");
	}
	public static BaseResp error(String msg) {
		return error(-1, msg);
	}

	public static BaseResp error() {
		return error(-1, "失败");
	}
	public static BaseResp wrong() {
		return error(-5, "系统繁忙，请开发者稍候再试");
	}
	public static BaseResp permit(String msg) {
		return error(-2, msg);
	}

	public static BaseResp wrong(String msg) {
		return error(-3, msg);
	}
	public static BaseResp exist(String msg) {
		return error(-4, msg);
	}

	public static BaseResp error(int code, String msg) {
		BaseResp r = new BaseResp();
		r.put("errorcode", code);
		r.put("errormsg", msg);
		return r;
	}

	public static BaseResp error_Rollback(int code, String msg) {
		if(code!=0){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		BaseResp r = new BaseResp();
		r.put("errorcode", code);
		r.put("errormsg", msg);
		return r;
	}

	public static BaseResp resulterror(String json) {
		try {
			Map<String, Object> map = JSONObject.parseObject(json);
			BaseResp baseResp = new BaseResp();
			baseResp.put("errorcode", map.get("errorcode"));
			baseResp.put("errormsg", map.get("errormsg"));
			return baseResp;
		} catch (Exception e) {
			return BaseResp.wrong();
		}
	}

	public static BaseResp result(Map<String, Object> map) {
		BaseResp baseResp = new BaseResp();
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			baseResp.put(entry.getKey(),entry.getValue());
		}
		return baseResp;
	}
	/*HashMap<String, Object> data = new HashMap<String, Object>();
38         Iterator it = jsonObject.keys();
39            // 遍历jsonObject数据，添加到Map对象
40            while (it.hasNext())
41            {
42                String key = String.valueOf(it.next());
43                String value = (String) jsonObject.get(key);
44                data.put(key, value);
45            }
46            System.out.println(data);*/

	public BaseResp put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
