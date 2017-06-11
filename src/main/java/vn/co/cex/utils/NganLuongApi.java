package vn.co.cex.utils;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class NganLuongApi {
	public String SetExpressCheckoutDeposit(String merchant_site_code, String checksum, String param, String enviroment)
			throws Exception {
		String soapurl = "https://www.nganluong.vn/micro_checkout_api.php?wsdl";
		if ("sandbox".equals(enviroment)) {
			soapurl = "http://sandbox.nganluong.vn:8088/nl30/micro_checkout_api.php?wsdl";
		}

		// instantiate new Service object
		Service service = new Service();

		// instantiate new Call object
		Call call = (Call) service.createCall();

		// set appropriate end point address
		call.setTargetEndpointAddress(new java.net.URL(soapurl));
		call.setOperationName(new QName("urn:CMSSOAP/SetExpressCheckoutDeposit", "SetExpressCheckoutDeposit"));

		// set in parameter of SOAP function
		call.addParameter("merchant_site_code", XMLType.SOAP_STRING, ParameterMode.IN);
		call.addParameter("checksum", XMLType.SOAP_STRING, ParameterMode.IN);
		call.addParameter("params", XMLType.SOAP_STRING, ParameterMode.IN);

		Object[] params = new Object[] { merchant_site_code.toString(), checksum.toString(), param.toString() };

		// set out parameter of SOAP function
		call.setReturnType(XMLType.SOAP_STRING);
		String rs = call.invoke(params).toString();
		return rs;
	}
	

    public String GetExpressCheckout(String merchant_site_code, String checksum, String param, String enviroment) throws Exception {
        String soapurl = "https://www.nganluong.vn/micro_checkout_api.php?wsdl";
        if ("sandbox".equals(enviroment)) {
            soapurl = "http://sandbox.nganluong.vn:8088/nl30/micro_checkout_api.php?wsdl";
        }
        //instantiate new Service Object
        Service service = new Service();

        //instantiate new Call object
        Call call = (Call) service.createCall();

        // set appropriate end point address
        call.setTargetEndpointAddress(new java.net.URL(soapurl));
        call.setOperationName(new QName("urn:CMSSOAP/GetExpressCheckout", "GetExpressCheckout"));
        
        // set in parameter of SOAP function
        call.addParameter("merchant_site_code", XMLType.SOAP_STRING, ParameterMode.IN);
        call.addParameter("checksum", XMLType.SOAP_STRING, ParameterMode.IN);
        call.addParameter("params", XMLType.SOAP_STRING, ParameterMode.IN);

        Object[] params = new Object[]{merchant_site_code.toString(), checksum.toString(), param.toString()};

        // set out parameter of SOAP function
        call.setReturnType(XMLType.SOAP_STRING);
        String rs = call.invoke(params).toString();
        return rs;
    }

}
