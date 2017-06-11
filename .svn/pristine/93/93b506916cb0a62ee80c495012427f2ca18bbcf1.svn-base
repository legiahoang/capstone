package vn.co.cex.utils;

import java.io.Console;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class NganLuongController {
	private String _Merchant_site_code = "";
	private String _Environment = "sandbox";
	private String _EmailRecieve = "";
	private String _Cancel_Url = "";
	private String _Return_Url = "";
	private String _Language = "vn";
	private String _Site_Pass = "";

	private NganLuongApi api;

	public NganLuongController(String merchant_site_code, String enviroment, String email, String cancel_url,
			String return_url, String site_pass) {
		this._Merchant_site_code = merchant_site_code;
		this._Environment = enviroment;
		this._EmailRecieve = email;
		this._Cancel_Url = cancel_url;
		this._Return_Url = return_url;
		this._Site_Pass = site_pass;

		api = new NganLuongApi();
	}

	public Hashtable SetExpressCheckoutDeposit(String order_code) throws Exception {
		String params = GetParameters(order_code);
		String strCheckSum = this._EmailRecieve + order_code + this._Return_Url + this._Cancel_Url + this._Language
				+ this._Site_Pass;
		String checkSum = MD5(strCheckSum);
		String rs = api.SetExpressCheckoutDeposit(this._Merchant_site_code, checkSum, params, this._Environment);
		Hashtable ha = StrToArrayDeposit(rs);
		return ha;
	}

	public Hashtable GetExpressCheckout(String token) throws Exception {
		String param = "<params><token>" + token + "</token></params>";
		String Checksum = MD5(token + _Site_Pass);
		String rs = api.GetExpressCheckout(_Merchant_site_code, Checksum, param, _Environment);
		
		Hashtable ha = StrToArray(rs);
		return ha;
	}

	private Hashtable StrToArrayDeposit(String str) throws Exception {
		Hashtable has = new Hashtable();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(new java.io.ByteArrayInputStream(str.getBytes("UTF-8")));
		NodeList node = dom.getElementsByTagName("result_code");
		String rs = node.item(0).getTextContent();

		NodeList des = dom.getElementsByTagName("result_description");
		String dess = des.item(0).getTextContent();

		has.put("result_description", dess);
		// result_description

		has.put("result_code", rs);
		if ("00".equals(rs)) {
			NodeList token = dom.getElementsByTagName("token");
			String tk = token.item(0).getTextContent();
			has.put("token", tk);

			NodeList cout = dom.getElementsByTagName("link_checkout");
			String lcout = cout.item(0).getTextContent();
			has.put("link_checkout", lcout);

			NodeList limit = dom.getElementsByTagName("time_limit");
			String lm = cout.item(0).getTextContent();
			has.put("time_limit", lm);
		}
		return has;
	}

	private Hashtable StrToArray(String str) throws Exception {
		Hashtable has = new Hashtable();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(new java.io.ByteArrayInputStream(str.getBytes("UTF-8")));
		NodeList node = dom.getElementsByTagName("result_code");
		String rs = node.item(0).getTextContent();

		NodeList des = dom.getElementsByTagName("card_amount");
		String dess = des.item(0).getTextContent();

		has.put("card_amount", dess);
		// result_description

		has.put("result_code", rs);

		NodeList result_description = dom.getElementsByTagName("result_description");
		String rd = result_description.item(0).getTextContent();
		has.put("result_description", rd);

		NodeList time_limit = dom.getElementsByTagName("time_limit");
		String tl = time_limit.item(0).getTextContent();
		has.put("time_limit", tl);

		NodeList merchant_site_code = dom.getElementsByTagName("merchant_site_code");
		String msc = merchant_site_code.item(0).getTextContent();
		has.put("merchant_site_code", msc);

		NodeList transaction_id = dom.getElementsByTagName("transaction_id");
		String ti = transaction_id.item(0).getTextContent();
		has.put("transaction_id", ti);

		NodeList amount = dom.getElementsByTagName("amount");
		String a = amount.item(0).getTextContent();
		has.put("amount", a);

		NodeList currency_code = dom.getElementsByTagName("currency_code");
		String cc = currency_code.item(0).getTextContent();
		has.put("currency_code", cc);

		NodeList transaction_type = dom.getElementsByTagName("transaction_type");
		String tt = transaction_type.item(0).getTextContent();
		has.put("transaction_type", tt);

		NodeList transaction_status = dom.getElementsByTagName("transaction_status");
		String ts = transaction_status.item(0).getTextContent();
		has.put("transaction_status", ts);

		NodeList payer_name = dom.getElementsByTagName("payer_name");
		String pn = payer_name.item(0).getTextContent();
		has.put("payer_name", pn);

		NodeList payer_email = dom.getElementsByTagName("payer_email");
		String pe = payer_email.item(0).getTextContent();
		has.put("payer_email", pe);

		NodeList payer_mobile = dom.getElementsByTagName("payer_mobile");
		String pm = payer_mobile.item(0).getTextContent();
		has.put("payer_mobile", pm);

		NodeList receiver_name = dom.getElementsByTagName("receiver_name");
		String rn = receiver_name.item(0).getTextContent();
		has.put("receiver_name", rn);

		NodeList receiver_address = dom.getElementsByTagName("receiver_address");
		String ra = receiver_address.item(0).getTextContent();
		has.put("receiver_address", ra);

		NodeList receiver_mobile = dom.getElementsByTagName("receiver_mobile");
		String rm = receiver_mobile.item(0).getTextContent();
		has.put("receiver_mobile", rm);

		NodeList method_payment_name = dom.getElementsByTagName("method_payment_name");
		String mpn = method_payment_name.item(0).getTextContent();
		has.put("method_payment_name", mpn);

		NodeList card_type = dom.getElementsByTagName("card_type");
		String ct = card_type.item(0).getTextContent();
		has.put("card_type", ct);

		return has;
	}

	private String GetParameters(String orderid) {
		String param = "<params>";
		param += "<receiver>" + this._EmailRecieve + "</receiver>";
		param += "<order_code>" + orderid + "</order_code>";
		param += "<return_url>" + this._Return_Url + "</return_url>";
		param += "<cancel_url>" + this._Cancel_Url + "</cancel_url>";
		param += "<language>" + this._Language + "</language>";
		param += "</params>";

		return param;
	}

	private String MD5(String strMd5) {
		try {
			String password = strMd5;

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			// convert the byte to hex format method 2
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception ex) {
			return ex.toString();
		}
	}

}
