package model;
import dao.*;



public class Transaction extends DbCon {
	
    protected int day, month, year, ssn, branchCode, count, value, zipcode, state, transaction;
    protected String cardNo, type;
    
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
 
    
	public int getMonth() {
	        return month;
	}

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public int getCount() {
        return count;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public void setDay(int day) {
	    this.day = day;
	}

	public int getDay(){
	    return day;
	}

	public void setCount(int count) {
	    this.count = count;
	    
	    //////// ALLOW TO MODIFY ACCOUNTS
	    
	}

	
	
	public void setZipcode(int zipcode) {
	    this.zipcode = zipcode;
	}

	public int getZipcode(){
	    return zipcode;
	}
	
	public void setState(int state) {
	    this.state = state;
	}

	public int getState(){
	    return state;
	}
	
	public void setTransaction(int transaction) {
	    this.transaction = transaction;
	}

	public int getTransaction(){
	    return transaction;
	}

	
	
}
