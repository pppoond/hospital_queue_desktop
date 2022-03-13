package hospital;

public class OpdDepQueueModel {
	private String opd_dep_queue_id;
	private String vn;
	private String depcode;
	private String queue_datetime;
	private String accept_datetime = null;
	private String finish_datetime = null;
	private String tx_status;
	private String from_depcode;
	private String check_in;
	private String day_queue_no;
	private String item_no = null;
	private String hos_guid;
	private String hn;
	private String an = null;
	private String vstdate;
	private String vsttime;
	private String doctor;
	private String hospmain;
	private String hospsub;
	private String oqueue;
	private String ovstist;
	private String ovstost;
	private String pttype;
	private String pttypeno;
	private String rfrics = null;
	private String rfrilct = null;
	private String rfrocs = null;
	private String rfrolct = null;
	private String spclty;
	private String rcpt_disease = null;
	private String hcode = null;
	private String cur_dep;
	private String cur_dep_busy;
	private String last_dep = null;
	private String cur_dep_time;
	private String rx_queue = null;
	private String diag_text = null;
	private String pt_subtype;
	private String main_dep;
	private String main_dep_queue;
	private String finance_summary_date = null;
	private String visit_type;
	private String node_id = null;
	private String contract_id = null;
	private String waiting = null;
	private String rfri_icd10 = null;
	private String o_refer_number = null;
	private String has_insurance = null;
	private String i_refer_number = null;
	private String refer_type = null;
	private String o_refer_dep = null;
	private String staff;
	private String command_doctor = null;
	private String send_person = null;
	private String pt_priority;
	private String finance_lock = null;
	private String oldcode = null;
	private String sign_doctor;
	private String anonymous_visit;
	private String anonymous_vn = null;
	private String pt_capability_type_id = null;
	private String pcu_code = null;
	private String pcu_vn = null;
	private String at_hospital;
	private String ovst_key;
	private String ptname;

	// Getter Methods

	public String getOpd_dep_queue_id() {
		return opd_dep_queue_id;
	}

	public String getVn() {
		return vn;
	}

	public String getDepcode() {
		return depcode;
	}

	public String getQueue_datetime() {
		return queue_datetime;
	}

	public String getAccept_datetime() {
		return accept_datetime;
	}

	public String getFinish_datetime() {
		return finish_datetime;
	}

	public String getTx_status() {
		return tx_status;
	}

	public String getFrom_depcode() {
		return from_depcode;
	}

	public String getCheck_in() {
		return check_in;
	}

	public String getDay_queue_no() {
		return day_queue_no;
	}

	public String getItem_no() {
		return item_no;
	}

	public String getHos_guid() {
		return hos_guid;
	}

	public String getHn() {
		return hn;
	}

	public String getAn() {
		return an;
	}

	public String getVstdate() {
		return vstdate;
	}

	public String getVsttime() {
		return vsttime;
	}

	public String getDoctor() {
		return doctor;
	}

	public String getHospmain() {
		return hospmain;
	}

	public String getHospsub() {
		return hospsub;
	}

	public String getOqueue() {
		return oqueue;
	}

	public String getOvstist() {
		return ovstist;
	}

	public String getOvstost() {
		return ovstost;
	}

	public String getPttype() {
		return pttype;
	}

	public String getPttypeno() {
		return pttypeno;
	}

	public String getRfrics() {
		return rfrics;
	}

	public String getRfrilct() {
		return rfrilct;
	}

	public String getRfrocs() {
		return rfrocs;
	}

	public String getRfrolct() {
		return rfrolct;
	}

	public String getSpclty() {
		return spclty;
	}

	public String getRcpt_disease() {
		return rcpt_disease;
	}

	public String getHcode() {
		return hcode;
	}

	public String getCur_dep() {
		return cur_dep;
	}

	public String getCur_dep_busy() {
		return cur_dep_busy;
	}

	public String getLast_dep() {
		return last_dep;
	}

	public String getCur_dep_time() {
		return cur_dep_time;
	}

	public String getRx_queue() {
		return rx_queue;
	}

	public String getDiag_text() {
		return diag_text;
	}

	public String getPt_subtype() {
		return pt_subtype;
	}

	public String getMain_dep() {
		return main_dep;
	}

	public String getMain_dep_queue() {
		return main_dep_queue;
	}

	public String getFinance_summary_date() {
		return finance_summary_date;
	}

	public String getVisit_type() {
		return visit_type;
	}

	public String getNode_id() {
		return node_id;
	}

	public String getContract_id() {
		return contract_id;
	}

	public String getWaiting() {
		return waiting;
	}

	public String getRfri_icd10() {
		return rfri_icd10;
	}

	public String getO_refer_number() {
		return o_refer_number;
	}

	public String getHas_insurance() {
		return has_insurance;
	}

	public String getI_refer_number() {
		return i_refer_number;
	}

	public String getRefer_type() {
		return refer_type;
	}

	public String getO_refer_dep() {
		return o_refer_dep;
	}

	public String getStaff() {
		return staff;
	}

	public String getCommand_doctor() {
		return command_doctor;
	}

	public String getSend_person() {
		return send_person;
	}

	public String getPt_priority() {
		return pt_priority;
	}

	public String getFinance_lock() {
		return finance_lock;
	}

	public String getOldcode() {
		return oldcode;
	}

	public String getSign_doctor() {
		return sign_doctor;
	}

	public String getAnonymous_visit() {
		return anonymous_visit;
	}

	public String getAnonymous_vn() {
		return anonymous_vn;
	}

	public String getPt_capability_type_id() {
		return pt_capability_type_id;
	}

	public String getPcu_code() {
		return pcu_code;
	}

	public String getPcu_vn() {
		return pcu_vn;
	}

	public String getAt_hospital() {
		return at_hospital;
	}

	public String getOvst_key() {
		return ovst_key;
	}

	public String getPtname() {
		return ptname;
	}

	// Setter Methods

	public void setOpd_dep_queue_id(String opd_dep_queue_id) {
		this.opd_dep_queue_id = opd_dep_queue_id;
	}

	public void setVn(String vn) {
		this.vn = vn;
	}

	public void setDepcode(String depcode) {
		this.depcode = depcode;
	}

	public void setQueue_datetime(String queue_datetime) {
		this.queue_datetime = queue_datetime;
	}

	public void setAccept_datetime(String accept_datetime) {
		this.accept_datetime = accept_datetime;
	}

	public void setFinish_datetime(String finish_datetime) {
		this.finish_datetime = finish_datetime;
	}

	public void setTx_status(String tx_status) {
		this.tx_status = tx_status;
	}

	public void setFrom_depcode(String from_depcode) {
		this.from_depcode = from_depcode;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public void setDay_queue_no(String day_queue_no) {
		this.day_queue_no = day_queue_no;
	}

	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}

	public void setHos_guid(String hos_guid) {
		this.hos_guid = hos_guid;
	}

	public void setHn(String hn) {
		this.hn = hn;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public void setVstdate(String vstdate) {
		this.vstdate = vstdate;
	}

	public void setVsttime(String vsttime) {
		this.vsttime = vsttime;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public void setHospmain(String hospmain) {
		this.hospmain = hospmain;
	}

	public void setHospsub(String hospsub) {
		this.hospsub = hospsub;
	}

	public void setOqueue(String oqueue) {
		this.oqueue = oqueue;
	}

	public void setOvstist(String ovstist) {
		this.ovstist = ovstist;
	}

	public void setOvstost(String ovstost) {
		this.ovstost = ovstost;
	}

	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	public void setPttypeno(String pttypeno) {
		this.pttypeno = pttypeno;
	}

	public void setRfrics(String rfrics) {
		this.rfrics = rfrics;
	}

	public void setRfrilct(String rfrilct) {
		this.rfrilct = rfrilct;
	}

	public void setRfrocs(String rfrocs) {
		this.rfrocs = rfrocs;
	}

	public void setRfrolct(String rfrolct) {
		this.rfrolct = rfrolct;
	}

	public void setSpclty(String spclty) {
		this.spclty = spclty;
	}

	public void setRcpt_disease(String rcpt_disease) {
		this.rcpt_disease = rcpt_disease;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	public void setCur_dep(String cur_dep) {
		this.cur_dep = cur_dep;
	}

	public void setCur_dep_busy(String cur_dep_busy) {
		this.cur_dep_busy = cur_dep_busy;
	}

	public void setLast_dep(String last_dep) {
		this.last_dep = last_dep;
	}

	public void setCur_dep_time(String cur_dep_time) {
		this.cur_dep_time = cur_dep_time;
	}

	public void setRx_queue(String rx_queue) {
		this.rx_queue = rx_queue;
	}

	public void setDiag_text(String diag_text) {
		this.diag_text = diag_text;
	}

	public void setPt_subtype(String pt_subtype) {
		this.pt_subtype = pt_subtype;
	}

	public void setMain_dep(String main_dep) {
		this.main_dep = main_dep;
	}

	public void setMain_dep_queue(String main_dep_queue) {
		this.main_dep_queue = main_dep_queue;
	}

	public void setFinance_summary_date(String finance_summary_date) {
		this.finance_summary_date = finance_summary_date;
	}

	public void setVisit_type(String visit_type) {
		this.visit_type = visit_type;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public void setWaiting(String waiting) {
		this.waiting = waiting;
	}

	public void setRfri_icd10(String rfri_icd10) {
		this.rfri_icd10 = rfri_icd10;
	}

	public void setO_refer_number(String o_refer_number) {
		this.o_refer_number = o_refer_number;
	}

	public void setHas_insurance(String has_insurance) {
		this.has_insurance = has_insurance;
	}

	public void setI_refer_number(String i_refer_number) {
		this.i_refer_number = i_refer_number;
	}

	public void setRefer_type(String refer_type) {
		this.refer_type = refer_type;
	}

	public void setO_refer_dep(String o_refer_dep) {
		this.o_refer_dep = o_refer_dep;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public void setCommand_doctor(String command_doctor) {
		this.command_doctor = command_doctor;
	}

	public void setSend_person(String send_person) {
		this.send_person = send_person;
	}

	public void setPt_priority(String pt_priority) {
		this.pt_priority = pt_priority;
	}

	public void setFinance_lock(String finance_lock) {
		this.finance_lock = finance_lock;
	}

	public void setOldcode(String oldcode) {
		this.oldcode = oldcode;
	}

	public void setSign_doctor(String sign_doctor) {
		this.sign_doctor = sign_doctor;
	}

	public void setAnonymous_visit(String anonymous_visit) {
		this.anonymous_visit = anonymous_visit;
	}

	public void setAnonymous_vn(String anonymous_vn) {
		this.anonymous_vn = anonymous_vn;
	}

	public void setPt_capability_type_id(String pt_capability_type_id) {
		this.pt_capability_type_id = pt_capability_type_id;
	}

	public void setPcu_code(String pcu_code) {
		this.pcu_code = pcu_code;
	}

	public void setPcu_vn(String pcu_vn) {
		this.pcu_vn = pcu_vn;
	}

	public void setAt_hospital(String at_hospital) {
		this.at_hospital = at_hospital;
	}

	public void setOvst_key(String ovst_key) {
		this.ovst_key = ovst_key;
	}

	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

}
