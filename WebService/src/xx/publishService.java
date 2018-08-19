package xx;

import javax.xml.ws.Endpoint;

public class publishService {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:6789/hello",new UPload() );
	}
}
