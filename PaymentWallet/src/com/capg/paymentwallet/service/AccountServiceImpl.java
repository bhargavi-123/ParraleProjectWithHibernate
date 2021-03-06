package com.capg.paymentwallet.service;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.dao.AccountDAOImpl;
import com.capg.paymentwallet.dao.IAccountDao;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.exception.CustomerExceptionMessage;

public class AccountServiceImpl implements IAccountService{
	 IAccountDao dao=new AccountDAOImpl();
	@Override
	public boolean createAccount(AccountBean accountBean)
			throws  CustomerException {
		
		 
		return  dao.createAccount(accountBean);
		
	}

	

	@Override
	public boolean deposit(AccountBean accountBean, double depositAmount)
			throws Exception {
	
		return dao.deposit(accountBean, depositAmount);
	}

	@Override
	public boolean withdraw(AccountBean accountBean, double withdrawAmount)
			throws Exception {
		
		return dao.withdraw(accountBean, withdrawAmount);
	}

	@Override
	public boolean fundTransfer(AccountBean transferingAccountBean,
		AccountBean beneficiaryAccountBean, double transferAmount) throws Exception {
		
		return dao.fundTransfer(transferingAccountBean, beneficiaryAccountBean, transferAmount);
	}

	



	@Override
	public AccountBean findAccount(int  accountId) throws Exception {
		
	
		return dao.findAccount( accountId);
	}
	@Override
	public boolean validateCustomer(AccountBean accountBean) throws CustomerException {
		boolean isValid=true;
		
	if(!(accountBean.getCustomerBean().getFirstName().matches("[a-zA-Z]{3,}")))
	{
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR1);
	}
	if(!(  accountBean.getCustomerBean().getLastName().matches("[a-zA-Z]{3,}")))
	{
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR2);
	}
	if((accountBean.getCustomerBean().getEmailId()== null || !(accountBean.getCustomerBean().getEmailId().matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+")))){

		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR3);
	}

	if((accountBean.getCustomerBean().getPanNum()==null) || (!(accountBean.getCustomerBean().getPanNum().matches("^[A-Z][A-Z0-9]{9}")))){
		
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR4);
	}
	if(!( accountBean.getCustomerBean().getPhoneNo().toString().matches("^[6-9][0-9]{9}"))){
		
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR5);
	}
	if(accountBean.getBalance()==0||!(accountBean.getBalance()>0)){
	isValid=false;
	throw new CustomerException(CustomerExceptionMessage.ERROR6);

   }
    if((accountBean.getCustomerBean().getAddress()==null)||(!(accountBean.getCustomerBean().getAddress().matches("[A-Za-z]{5,50}"))))
	{
		isValid=false;
		throw new CustomerException(CustomerExceptionMessage.ERROR7);
	}
	return isValid;
		
    }
}
