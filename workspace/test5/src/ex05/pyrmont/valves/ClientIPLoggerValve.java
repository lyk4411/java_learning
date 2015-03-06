package ex05.pyrmont.valves;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletException;
import org.apache.catalina.Request;
import org.apache.catalina.Response;
import org.apache.catalina.Valve;
import org.apache.catalina.ValveContext;
import org.apache.catalina.Contained;
import org.apache.catalina.Container;


public class ClientIPLoggerValve implements Valve, Contained {

  protected Container container;

  public void invoke(Request request, Response response, ValveContext valveContext)
    throws IOException, ServletException {

    // Pass this request on to the next valve in our pipeline
    valveContext.invokeNext(request, response);
    System.out.println("Client IP Logger Valve");
    ServletRequest sreq = request.getRequest();
    System.out.println(sreq.getRemoteAddr());
    System.out.println("------------------------------------");
  }

  public String getInfo() {
    return null;
  }

  public Container getContainer() {
    return container;
  }

  public void setContainer(Container container) {
    this.container = container;
  }

@Override
public void backgroundProcess() {
	// TODO Auto-generated method stub
	
}

@Override
public Valve getNext() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void invoke(org.apache.catalina.connector.Request arg0,
		org.apache.catalina.connector.Response arg1) throws IOException,
		ServletException {
	// TODO Auto-generated method stub
	
}

@Override
public void setNext(Valve arg0) {
	// TODO Auto-generated method stub
	
}
}