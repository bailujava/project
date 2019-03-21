package tv.buka.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**\
 * 系统启动时初始化方法，将OSS文件读取到内存
 */
@Component
public class LoadUrl {

	@Value("#{urlProperties}")
	protected Map urlMap;//获取property.propertis中的所有信息

	public static  Map urlMsg =new HashMap<String,String>();
	
	//public static Map systemCode;
	
	
    public void loadUrl() throws Exception {
    	
    	Set<String> keySet = urlMap.keySet();
    	for (String str : keySet) {
			urlMsg.put(str, urlMap.get(str));
		}
    }  

}
