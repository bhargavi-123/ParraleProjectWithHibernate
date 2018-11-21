package com.capg.paymentwallet.test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.AccountServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountServiceImplTest {

		private static AccountServiceImpl service = null;

		@BeforeClass
		public static void createInstance() {
			service = new AccountServiceImpl();
		}
		

		@Test(expected = CustomerException.class)
		public void testFirstNameNull() throws Exception {
			CustomerBean customer = new CustomerBean();
			customer.setFirstName(""); 
			customer.setLastName("abhai");
            customer.setPhoneNo("8468900940");
			customer.setAddress("chennai");
			customer.setEmailId("vjjg@gmail.com");
			customer.setPanNum("HDH909HJH");
			AccountBean bean = new AccountBean();
			bean.setAccountId(102);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
		    boolean isvalid =service.validateCustomer(bean);
			boolean result1=service.createAccount(bean);
			assertFalse(result1);
			
	}


		@Test(expected = Exception.class)
		public void testFirstNameForLength() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("sa"); 
			customer.setLastName("abhai");
            customer.setPhoneNo("8468900940");
			customer.setAddress("chennai");
			customer.setEmailId("vjjg@gmail.com");
			customer.setPanNum("HDH909HJH");
			AccountBean bean = new AccountBean();
			bean.setAccountId(200);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
		    boolean isvalid =service.validateCustomer(bean);
			boolean result=service.createAccount(bean);

			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testFirstNameOnlyForAlphabets() throws Exception {
			CustomerBean customer = new CustomerBean();

			
			customer.setFirstName("123"); 
			customer.setLastName("abhai");
            customer.setPhoneNo("8468900940");
			customer.setAddress("chennai");
			customer.setEmailId("vjjg@gmail.com");
			customer.setPanNum("HDH909HJH");
			AccountBean bean = new AccountBean();
			bean.setAccountId(200);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
		    boolean isvalid =service.validateCustomer(bean);
			boolean result=service.createAccount(bean);

			assertFalse(result);
		}
		@Test
		public void testFirstNamePsositive() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("sai"); 
			customer.setLastName("abhai");
            customer.setPhoneNo("8468900940");
			customer.setAddress("chennai");
			customer.setEmailId("vjjg@gmail.com");
			customer.setPanNum("HDH909HJH5");
			AccountBean bean = new AccountBean();
			bean.setAccountId(100);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);
			boolean result=service.createAccount(bean);
		    assertTrue(result);
		}
		@Test(expected = NullPointerException.class)
		public void testlastNameForNull() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("Sai");
			customer.setLastName(null);
			customer.setPhoneNo("8465023240");
			customer.setAddress("Chennai");

			customer.setEmailId("vjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertFalse(result);
		}
		
		

		

		@Test(expected = Exception.class)
		public void testlastNameForLength() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("aj");
			customer.setPhoneNo("8465023240");
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

		
			
			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testlastNameForOnlyCharacters() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("Sai");
			customer.setLastName("456");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
		
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);


			boolean result=service.createAccount(bean);
			assertFalse(result);
		}
		

		@Test
		public void testLastNameValid() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("8465023240");
		
			AccountBean bean = new AccountBean();
			bean.setAccountId(1002);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertTrue(result);

		}

		@Test(expected = Exception.class)
		public void testPhnoForLength() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("sai");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963");
		
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testPhonenoInvalidBegining() throws Exception {
			CustomerBean customer = new CustomerBean();
			customer.setFirstName("kaushik");
			customer.setLastName("ajay");
			customer.setAddress("chennai");
			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("5287525236");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertFalse(result);
		}
				
		@Test
		public void testPhoneNumPositive() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDHFGH6784");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1003);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertTrue(result);
		}

		@Test(expected = Exception.class)
		public void testEmailIdForNull() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);


			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testEmailIdInvalid() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId(".com@fhgfhf");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
		
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);


			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test
		public void testEmailIdValid() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");		
		
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			
			boolean result=service.createAccount(bean);
			assertTrue(result);
		}

		@Test
		public void testpanNumValid() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
	
			AccountBean bean = new AccountBean();
			bean.setAccountId(1004);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertTrue(result);
		}

		@Test(expected = Exception.class)
		public void testpanNumlength() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH90");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testpanNumForNull() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			;
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);


			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testpanNumInValid() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("GHSDJ@75$");
			customer.setPhoneNo("9963144561");
		
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testpanNumForOnlyNum() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("9966332211");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertFalse(result);
		}
	
		
		  
		@Test(expected = Exception.class)
		public void testbalance() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
		
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
			

			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(-2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);


			boolean result=service.createAccount(bean);
			assertFalse(result);
		}

		@Test(expected = Exception.class)
		public void testbalanceInvalid() throws Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1001);
			bean.setBalance(0.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);


			boolean result=service.createAccount(bean);
			assertTrue(result);
		}

		@Test
		public void testBalanceValid() throws  Exception {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1005);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertTrue(result);
		}

		@Test
		public void testAddressValid() throws Exception {
			CustomerBean customer = new CustomerBean();
			customer.setFirstName("kaushik");
			customer.setLastName("ajay");
			customer.setAddress("chennai");
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo("9963144561");
			
			AccountBean bean = new AccountBean();
			bean.setAccountId(1005);
			bean.setBalance(2000.00);
			bean.setDateOfOpening(new Date());
			bean.setInitialDeposit(1000.00);
			bean.setCustomerBean(customer);
			boolean isvalid =service.validateCustomer(bean);

			boolean result=service.createAccount(bean);
			assertTrue(result);
		}
	/*@Test
			
		public void testForShowBalanceNotSame()  {
			
		
		double result=service.showBalance(1001);
		Assert.assertEquals(2000.0, result,0);

			
		}
		@Test
		
		public void testAForShowBalanceSame()  {
					
		double result=service.showBalance(342);
		Assert.assertEquals(2000.0,result,0);
	
		}*/
		/*@Test
		public void testBForFundTransfer() {
			
			double result = service.fundTransfer(1001,1002,500);
			Assert.assertNotEquals(1500.0,result,0);
		}
		@Test
		public void testCForWithdraw() {
		
			
			double result = service.withdraw(new BigInteger("8465033260"),1000.0);
			Assert.assertEquals(500.0,result,0);
		}
		@Test
		public void testDForDeposit()  {
			double result = service.deposit(new BigInteger("8465033260"), 2000.0);
			Assert.assertEquals(2500.0, result,0);
		}
		@Test
		public void testForFundTransferInvalid() {
			
			double result = service.fundTransfer(new BigInteger("8465039960"), 500.0, new BigInteger("8465033260"));
			Assert.assertNotEquals(1500.0,result,0);
		}
		@Test
		public void testForFundTransferInvalidAmount() {
			
			double result = service.fundTransfer(new BigInteger("8465039960"), 50000.0, new BigInteger("8465033260"));
			Assert.assertNotEquals(1500.0,result,0);
		}
		
		
		
		@Test
		public void testForWithdrawInvalid() {
		
			
			double result = service.withdraw(new BigInteger("8465044260"),1000.0);
			Assert.assertNotEquals(500.0,result,0);
		}
		@Test
		public void testForWithdrawInvalidAmount() {
		
			
			double result = service.withdraw(new BigInteger("8465044260"),10000.0);
			Assert.assertNotEquals(500.0,result,0);
		}
		
		@Test
		public void testForDepositInvalid()  {
			double result = service.deposit(new BigInteger("8466033260"), 2000.0);
			Assert.assertNotEquals(4500.0, result,0);
		}
		@Test
		public void testForPrintTransaction(){
			
		service.printTransaction(new BigInteger("8465033260"));
		
			
		}*/
		
		
}
		