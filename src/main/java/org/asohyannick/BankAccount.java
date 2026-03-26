package org.asohyannick;

public final class BankAccount {
   private String owner;
   private double balance;
   
   public BankAccount(String owner, double balance) {
	   this.owner = owner;
	   this.balance = balance;
   }
   
   public String getOwner() {
	   return owner;
   }
   
   public double getBalance() {
	   return balance;
   }
   
   public void setOwner(String owner) {
	   this.owner = owner;
   }
   
   public void setBalance(double balance) {
	   this.balance = balance;
   }
   
   @Override
   public String toString() {
	   return  "BankAccount{" +
					   "owner='" + owner + '\'' +
			            "balance'" + balance  + '\'' +
			           "}";
   }
   
}
