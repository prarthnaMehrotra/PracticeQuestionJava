package com.crimsonlogic.practicequestion;

//loose coupling
public interface Account {
	
	float money = 6000f;
	float getBalance(String accId);
	float deposit(float depositAmt);
	float withdraw(float withdrawAmt);

}