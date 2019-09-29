package mybatis-generator.entity;

import java.util.Date;

public class view_product_productinfo {
    private String id;

    private String uniqueid;

    private Boolean isdisable;

    private String name;

    private String investorid;

    private String investorname;

    private Short leasedirection;

    private Short repaymentmode;

    private String vehiclekindid;

    private String vehiclekindname;

    private Date effectivedate;

    private Date invaliddate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid == null ? null : uniqueid.trim();
    }

    public Boolean getIsdisable() {
        return isdisable;
    }

    public void setIsdisable(Boolean isdisable) {
        this.isdisable = isdisable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInvestorid() {
        return investorid;
    }

    public void setInvestorid(String investorid) {
        this.investorid = investorid == null ? null : investorid.trim();
    }

    public String getInvestorname() {
        return investorname;
    }

    public void setInvestorname(String investorname) {
        this.investorname = investorname == null ? null : investorname.trim();
    }

    public Short getLeasedirection() {
        return leasedirection;
    }

    public void setLeasedirection(Short leasedirection) {
        this.leasedirection = leasedirection;
    }

    public Short getRepaymentmode() {
        return repaymentmode;
    }

    public void setRepaymentmode(Short repaymentmode) {
        this.repaymentmode = repaymentmode;
    }

    public String getVehiclekindid() {
        return vehiclekindid;
    }

    public void setVehiclekindid(String vehiclekindid) {
        this.vehiclekindid = vehiclekindid == null ? null : vehiclekindid.trim();
    }

    public String getVehiclekindname() {
        return vehiclekindname;
    }

    public void setVehiclekindname(String vehiclekindname) {
        this.vehiclekindname = vehiclekindname == null ? null : vehiclekindname.trim();
    }

    public Date getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public Date getInvaliddate() {
        return invaliddate;
    }

    public void setInvaliddate(Date invaliddate) {
        this.invaliddate = invaliddate;
    }
}