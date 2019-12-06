package mercury.models;

public class Patient {

	   private String ohipNumber;
	   private String ohipVersion;
	   private String fName;
	   private String lName;
	   private String login;
	   private String dateOfBirth;
	   private String gender;

	   public Patient() {
	      super();
	   }

	   public Patient(String ohipNumber, String ohipVersion, String fName, String lName, String login,
	         String gender, String dateOfBirth) {
	      this.ohipNumber = ohipNumber;
	      this.ohipVersion = ohipVersion;
	      this.fName = fName;
	      this.lName = lName;
	      this.login = login;
	      this.gender = gender;
	      this.dateOfBirth = dateOfBirth;
	   }
	   
	   public Patient(String login, String ohipNumber, String fName, String lName, String gender, String ohipVersion) {
	      this.login = login;
		  this.ohipNumber = ohipNumber;
	      this.ohipVersion = ohipVersion;
	      this.fName = fName;
	      this.lName = lName;
	      this.gender = gender;
	   }

	   public String getOhipNumber() {
	      return ohipNumber;
	   }

	   public void setOhipNumber(String ohipNumber) {
	      this.ohipNumber = ohipNumber;
	   }

	   public String getOhipVersion() {
	      return ohipVersion;
	   }

	   public void setOhipVersion(String ohipVersion) {
	      this.ohipVersion = ohipVersion;
	   }

	   public String getfName() {
	      return fName;
	   }

	   public void setfName(String fName) {
	      this.fName = fName;
	   }

	   public String getlName() {
	      return lName;
	   }

	   public void setlName(String lName) {
	      this.lName = lName;
	   }

	   public String getLogin() {
	      return login;
	   }

	   public void setLogin(String login) {
	      this.login = login;
	   }

	   public String getDateOfBirth() {
	      return dateOfBirth;
	   }

	   public void setDateOfBirth(String dateOfBirth) {
	      this.dateOfBirth = dateOfBirth;
	   }
	   
	   public String getGender() {
		      return gender;
	   }

	   public void setGender(String gender) {
	      this.gender = gender;
	   }

}
