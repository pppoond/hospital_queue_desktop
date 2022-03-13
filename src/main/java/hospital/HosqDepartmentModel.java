package hospital;
public class HosqDepartmentModel {
  private String hqd_id;
  private String depcode;
  private String department;
  private String spclty;
  private String time_reg;
  private String hsd_id;


 // Getter Methods 

  public String getHqd_id() {
    return hqd_id;
  }

  public String getDepcode() {
    return depcode;
  }

  public String getDepartment() {
    return department;
  }

  public String getSpclty() {
    return spclty;
  }

  public String getTime_reg() {
    return time_reg;
  }

  public String getHsd_id() {
    return hsd_id;
  }

 // Setter Methods 

  public void setHqd_id( String hqd_id ) {
    this.hqd_id = hqd_id;
  }

  public void setDepcode( String depcode ) {
    this.depcode = depcode;
  }

  public void setDepartment( String department ) {
    this.department = department;
  }

  public void setSpclty( String spclty ) {
    this.spclty = spclty;
  }

  public void setTime_reg( String time_reg ) {
    this.time_reg = time_reg;
  }

  public void setHsd_id( String hsd_id ) {
    this.hsd_id = hsd_id;
  }
}