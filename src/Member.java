
public class Member {
	private String name, address, mobileNumber;

	public Member(String name, String address,String mobileNumber){
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;		
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}	
	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public void printMember() {
		
		System.out.print("    ");
		System.out.print("Borrower Name: " + getName());
		System.out.print(",       Borrower Address: " + getAddress());
		System.out.println(",       Mobile Number: " + getMobileNumber());
		
		
	}
	public String getStandardData(){
		return getName()+","+getAddress()+","+getMobileNumber()+String.format("%n");
}
}



