package vn.co.cex.utils;

public class ConstantUtils {

	public final static int USER_ADMIN = 1;
	public final static int USER_GOODS_OWNER = 2;
	public final static int USER_CARRIER = 3;

	public final static String ROLE_ADMIN = "Admin";
	public final static String ROLE_GOODS_OWNER = "Chủ hàng";
	public final static String ROLE_CARRIER = "Chủ xe";

	public final static int USER_STATUS_UNCONFIRM = 0;
	public final static int USER_STATUS_CONFIRM = 1;
	public final static int USER_STATUS_DEACTIVE = 2;
	public final static int USER_STATUS_INVALID = 3;

	// Constants
	public final static int CARRIER_AUCTION_NOT_OWNER = 0;
	public final static int CARRIER_AUCTION_BIDDING = 1;
	public final static int CARRIER_AUCTION_SUCCESS = 2;
	public final static int CARRIER_AUCTION_COMPLETION = 3;
	public final static int CARRIER_AUCTION_FAILURE = 4;
	public final static int CARRIER_AUCTION_GOOGSOWNER_CANCELED = 5;
	public final static int CARRIER_AUCTION_CARRIER_CANCELED = 6;
	public final static int CARRIER_AUCTION_CARRIER_CANCELED_BEFORE = 7;

	public final static int BILLOFLADING_NOT_OWNER = 0;
	public final static int BILLOFLADING_BIDDING = 1;
	public final static int BILLOFLADING_SUCCESS = 2;
	public final static int BILLOFLADING_COMPLETION = 3;
	public final static int BILLOFLADING_FAILURE = 4;
	public final static int BILLOFLADING_GOODSOWNER_CANCELED = 5;
	public final static int BILLOFLADING_CARRIER_CANCELED = 6;

	// user id
	public final static String USER_ID = "userid";
	// user name
	public final static String USER_NAME = "username";
	// user Login
	public final static String USER_LOGIN = "userLogin";
	// login
	public final static String LOGIN = "login";
	// userView
	public final static String USERVIEW = "userView";
	// home
	public final static String HOME = "home";
	// register
	public final static String REGISTER = "register";
	// RegisterMessage
	public final static String REGISTER_MESSAGE = "RegisterMessage";
	// add Company Information
	public final static String ADD_COMPANY = "addCompany";
	// Users Account Information
	public final static String USERS_ACCOUNT_INFORMATION = "usersAccountInformation";

	// Encryption
	public final static String PASSWORD_KEY = "10041993";

	public static final int OPERATIONFEE_INACTIVE = 0;
	public static final int OPERATIONFEE_ACTIVE = 1;

	public final static int PAGE_SIZE = 10;
	public final static int PAGE_INDEX = 0;

	public final static String FEE_CODE_POST_BILLOFLADING = "F001";
	public final static String FEE_CODE_BID_BILLOFLADING = "F002";
	public final static String EARNEST_MONEY_OF_GOODSOWNER = "C001";
	public final static String EARNEST_MONEY_OF_CARRIER = "C002";
	public final static boolean PAYMENT_PLUS = true;
	public final static boolean PAYMENT_MINUS = false;
	// public final static String PAYMENT_CANCEL = "Cancel BillOfLading";

	public final static int ACCOUNT_BALANCE_NOT_ENOUGH = -1;
	public final static int PROCESS_FAILURE = 0;
	public final static int PROCESS_SUCCESS = 1;

	public final static String HOST_URL = "https://carriertradingcenter.com/"; // http://ctc-vietnam.com/
}
