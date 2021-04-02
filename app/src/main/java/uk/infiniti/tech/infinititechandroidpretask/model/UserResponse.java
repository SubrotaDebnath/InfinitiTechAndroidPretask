package uk.infiniti.tech.infinititechandroidpretask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("issuccess")
    @Expose
    private Boolean issuccess;
    @SerializedName("payload")
    @Expose
    private Payload payload;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(Boolean issuccess) {
        this.issuccess = issuccess;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Payload {

        @SerializedName("user_info")
        @Expose
        private UserInfo userInfo;
        @SerializedName("token")
        @Expose
        private String token;

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

    }

    public class UserInfo {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("idx")
        @Expose
        private String idx;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("businessname")
        @Expose
        private String businessname;
        @SerializedName("ownername")
        @Expose
        private String ownername;
        @SerializedName("companyregno")
        @Expose
        private String companyregno;
        @SerializedName("vatno")
        @Expose
        private String vatno;
        @SerializedName("businessaddress")
        @Expose
        private String businessaddress;
        @SerializedName("postcode")
        @Expose
        private String postcode;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("landline")
        @Expose
        private String landline;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("businesstype")
        @Expose
        private String businesstype;
        @SerializedName("accstatus")
        @Expose
        private Integer accstatus;
        @SerializedName("registrtiondate")
        @Expose
        private String registrtiondate;
        @SerializedName("approvedate")
        @Expose
        private Object approvedate;
        @SerializedName("approveby")
        @Expose
        private String approveby;
        @SerializedName("companyregdoc")
        @Expose
        private String companyregdoc;
        @SerializedName("vatdoc")
        @Expose
        private String vatdoc;
        @SerializedName("EOID")
        @Expose
        private String eoid;
        @SerializedName("FID")
        @Expose
        private String fid;
        @SerializedName("IOU")
        @Expose
        private Object iou;
        @SerializedName("IOULIMIT")
        @Expose
        private Object ioulimit;
        @SerializedName("promotioncode")
        @Expose
        private Object promotioncode;
        @SerializedName("isdirectdebitset")
        @Expose
        private Boolean isdirectdebitset;
        @SerializedName("action")
        @Expose
        private Object action;
        @SerializedName("need_approval")
        @Expose
        private Boolean needApproval;
        @SerializedName("createddate")
        @Expose
        private String createddate;
        @SerializedName("createdby")
        @Expose
        private Object createdby;
        @SerializedName("login_datetime")
        @Expose
        private String loginDatetime;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getIdx() {
            return idx;
        }

        public void setIdx(String idx) {
            this.idx = idx;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getBusinessname() {
            return businessname;
        }

        public void setBusinessname(String businessname) {
            this.businessname = businessname;
        }

        public String getOwnername() {
            return ownername;
        }

        public void setOwnername(String ownername) {
            this.ownername = ownername;
        }

        public String getCompanyregno() {
            return companyregno;
        }

        public void setCompanyregno(String companyregno) {
            this.companyregno = companyregno;
        }

        public String getVatno() {
            return vatno;
        }

        public void setVatno(String vatno) {
            this.vatno = vatno;
        }

        public String getBusinessaddress() {
            return businessaddress;
        }

        public void setBusinessaddress(String businessaddress) {
            this.businessaddress = businessaddress;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLandline() {
            return landline;
        }

        public void setLandline(String landline) {
            this.landline = landline;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBusinesstype() {
            return businesstype;
        }

        public void setBusinesstype(String businesstype) {
            this.businesstype = businesstype;
        }

        public Integer getAccstatus() {
            return accstatus;
        }

        public void setAccstatus(Integer accstatus) {
            this.accstatus = accstatus;
        }

        public String getRegistrtiondate() {
            return registrtiondate;
        }

        public void setRegistrtiondate(String registrtiondate) {
            this.registrtiondate = registrtiondate;
        }

        public Object getApprovedate() {
            return approvedate;
        }

        public void setApprovedate(Object approvedate) {
            this.approvedate = approvedate;
        }

        public String getApproveby() {
            return approveby;
        }

        public void setApproveby(String approveby) {
            this.approveby = approveby;
        }

        public String getCompanyregdoc() {
            return companyregdoc;
        }

        public void setCompanyregdoc(String companyregdoc) {
            this.companyregdoc = companyregdoc;
        }

        public String getVatdoc() {
            return vatdoc;
        }

        public void setVatdoc(String vatdoc) {
            this.vatdoc = vatdoc;
        }

        public String getEoid() {
            return eoid;
        }

        public void setEoid(String eoid) {
            this.eoid = eoid;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public Object getIou() {
            return iou;
        }

        public void setIou(Object iou) {
            this.iou = iou;
        }

        public Object getIoulimit() {
            return ioulimit;
        }

        public void setIoulimit(Object ioulimit) {
            this.ioulimit = ioulimit;
        }

        public Object getPromotioncode() {
            return promotioncode;
        }

        public void setPromotioncode(Object promotioncode) {
            this.promotioncode = promotioncode;
        }

        public Boolean getIsdirectdebitset() {
            return isdirectdebitset;
        }

        public void setIsdirectdebitset(Boolean isdirectdebitset) {
            this.isdirectdebitset = isdirectdebitset;
        }

        public Object getAction() {
            return action;
        }

        public void setAction(Object action) {
            this.action = action;
        }

        public Boolean getNeedApproval() {
            return needApproval;
        }

        public void setNeedApproval(Boolean needApproval) {
            this.needApproval = needApproval;
        }

        public String getCreateddate() {
            return createddate;
        }

        public void setCreateddate(String createddate) {
            this.createddate = createddate;
        }

        public Object getCreatedby() {
            return createdby;
        }

        public void setCreatedby(Object createdby) {
            this.createdby = createdby;
        }

        public String getLoginDatetime() {
            return loginDatetime;
        }

        public void setLoginDatetime(String loginDatetime) {
            this.loginDatetime = loginDatetime;
        }

    }
}
