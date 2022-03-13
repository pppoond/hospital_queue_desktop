package hospital;
public class RequestQModel {
  private String rq_id;
  private String spclty;
  private String oqueue;
  private String ptname;
  private String sign_datetime;
  private String curdep_code;
  private String curdep_name;
  private String time_reg;
  private String status;


 // Getter Methods 

  public String getRq_id() {
    return rq_id;
  }

  public String getSpclty() {
    return spclty;
  }

  public String getOqueue() {
    return oqueue;
  }

  public String getPtname() {
    return ptname;
  }

  public String getSign_datetime() {
    return sign_datetime;
  }

  public String getCurdep_code() {
    return curdep_code;
  }

  public String getCurdep_name() {
    return curdep_name;
  }

  public String getTime_reg() {
    return time_reg;
  }

  public String getStatus() {
    return status;
  }

 // Setter Methods 

  public void setRq_id( String rq_id ) {
    this.rq_id = rq_id;
  }

  public void setSpclty( String spclty ) {
    this.spclty = spclty;
  }

  public void setOqueue( String oqueue ) {
    this.oqueue = oqueue;
  }

  public void setPtname( String ptname ) {
    this.ptname = ptname;
  }

  public void setSign_datetime( String sign_datetime ) {
    this.sign_datetime = sign_datetime;
  }

  public void setCurdep_code( String curdep_code ) {
    this.curdep_code = curdep_code;
  }

  public void setCurdep_name( String curdep_name ) {
    this.curdep_name = curdep_name;
  }

  public void setTime_reg( String time_reg ) {
    this.time_reg = time_reg;
  }

  public void setStatus( String status ) {
    this.status = status;
  }
}