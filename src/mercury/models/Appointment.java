package mercury.models;

public class Appointment {
   private String appNumber;
   private String patient;
   private String reasonForVisit;
   private String date;
   private String time;
   private int isPatientCheckedIn;

   public Appointment() {
      super();
   }

   public Appointment(String appNumber, String patient, String reasonForVisit, String date, String time,
         int isPatientCheckedIn) {
      super();
      this.appNumber = appNumber;
      this.patient = patient;
      this.reasonForVisit = reasonForVisit;
      this.date = date;
      this.time = time;
      this.isPatientCheckedIn = isPatientCheckedIn;
   }

   public String getAppNumber() {
      return appNumber;
   }

   public void setAppNumber(String appNumber) {
      this.appNumber = appNumber;
   }

   public String getPatient() {
      return patient;
   }

   public void setPatient(String patient) {
      this.patient = patient;
   }

   public String getReasonForVisit() {
      return reasonForVisit;
   }

   public void setReasonForVisit(String reasonForVisit) {
      this.reasonForVisit = reasonForVisit;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public int getIsPatientCheckedIn() {
      return isPatientCheckedIn;
   }

   public void setIsPatientCheckedIn(int isPatientCheckedIn) {
      this.isPatientCheckedIn = isPatientCheckedIn;
   }

}