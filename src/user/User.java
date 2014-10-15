package user;

import java.util.*;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;

import mailer.RegAuthenticator;


public class User {
	
	public String primaryemail;
	private MailAccount currentAccount;
	private ArrayList<MailAccount> accounts = new ArrayList<MailAccount>();
	
	
	public User(String primaryEmail, MailAccount firstMailAccount) {
		this.primaryemail = primaryEmail;
		this.currentAccount = firstMailAccount;
		addAccount(firstMailAccount);
	}
	
	public MailAccount getCurrentMailAccount() {
		return this.currentAccount;
	}
	
	public void addAccount(MailAccount account) {
		accounts.add(account);
	}
	
	public ArrayList<MailAccount> getAccounts() {
		return accounts;
	}
	
	
	public Session getSession() {
	    javax.mail.Authenticator authenticator = new RegAuthenticator(this);
	    return Session.getDefaultInstance(currentAccount.getProperties(),authenticator);
	}

	public void setCurrentMailAccount(MailAccount account) {
		this.currentAccount = account;
		
	}
	
	
	

}
