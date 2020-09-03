package com.ibm.rewrite.vcsr.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class Activemqcomponent {

	
	
	public static String Activemqservice(String msg)
	{
	    final String uri = "http://localhost:8087/rsoe/activemq-dev/csr-cbi";
	    String result="";
	    RestTemplate restTemplate = new RestTemplate();
try {
	

   
  result = restTemplate.postForObject(uri, msg, String.class);

}catch (ResourceAccessException ex)   {
    ex.printStackTrace();
    ex.getRootCause();
    System.out.println(ex.getMessage());
}    
/*catch (HttpClientErrorException hce) {
	System.out.println("I am here");
	HttpStatus statusCode = hce.getStatusCode();
	System.out.println("status text "+hce.getStatusText());
    String body = hce.getResponseBodyAsString();
    System.out.println("body"+body+"statusCode"+statusCode);
	 
}
*/	  

 
	return result;
	
	}

public static void main(String arg[])
{
	Activemqcomponent ac = new Activemqcomponent();
	ac.Activemqservice("hello");
}

}
