package xx;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class UPload implements HelloService{

	@Override
	public String XX(String name) {
		System.out.println("打印出名字:"+name);
	return name;
	}



	
}
