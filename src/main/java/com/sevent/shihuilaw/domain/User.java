package com.sevent.shihuilaw.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by xtb on 17/3/28.
 * 用户
 */
@Entity
@Table(name = "user", schema = "shihuilaw")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String officeId;//办公室
    private String officeName;//办公室
    private String departmentId;
    private String departmentName;
    private Date lastTimeChangePassword;
    private String userType;
    private String accountPermissions;
    private String realName;
    private Double fee;
    private String logId;
    private boolean usable = true;

    private String category;//类别
    private String status;//人员状态
    private String clazz;//年级
    private String sex;//性别
    private String birthday;//生日
    private String idCardNo;//身份证
    private String ethnicity;//种族
    private String birthplace;//籍贯
    private String marriage;//婚否
    private String politicalStatus;//政治面貌
    private String highestEducation;//最高学历
    private String profession;//专业
    private String school;//毕业院校
    private String phone;//手机
    private String address;//地址
    private String email;//邮箱
    private String emergencyContact;//紧急联系人
    private String relationship;//关系
    private String emergencyPhone;//紧急联系人电话
    private String domicile;//户籍所在地
    private String lawShipStoragePlace;//律师关系存放地
    private String lawShipCreateDate;//存放日期
    private String personnelFilesStoragePlace;//人事档案存放地
    private String fileNumber;//存档号
    private String fileCreateDate;//存放日期
    private String preLawOffice;//原律师事务所
    private String occupationNo;//职业证号
    private String source ;
    private String annualNum;//年假天数
    private String entryList;//入职清单
    private String departureList;//离职清单
    private String moneyType;//币种
    private String  roleId;



    public User() {
    }
    public User(Admin admin){
        this.setId(admin.getId());
        this.logId = admin.getLogId();
        this.username = admin.getUsername();
        this.phone = admin.getPhone();
        this.password = admin.getPassword();
        this.realName = admin.getRealName();
        this.source = admin.getSource();
        this.lastTimeChangePassword = admin.getLastTimeLogin();
    }

    public User(String username, String phone, String email,
                String password, String userType, String accountPermissions,
                String realName) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.accountPermissions = accountPermissions;
        this.realName = realName;
    }

    public User(String username, String phone, String email, String password,
                String departmentId, Date lastTimeChangePassword, String userType,
                String accountPermissions, String realName, Double fee, String departmentName) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.lastTimeChangePassword = lastTimeChangePassword;
        this.userType = userType;
        this.accountPermissions = accountPermissions;
        this.realName = realName;
        this.fee = fee;
    }
    @Basic
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "money_type")
    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }
    @Basic
    @Column(name = "entry_list")
    public String getEntryList() {
        return entryList;
    }

    public void setEntryList(String entryList) {
        this.entryList = entryList;
    }
    @Basic
    @Column(name = "departure_list")
    public String getDepartureList() {
        return departureList;
    }

    public void setDepartureList(String departureList) {
        this.departureList = departureList;
    }

    @Basic
    @Column(name = "log_id")
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "annual_num")
    public String getAnnualNum() {
        return annualNum;
    }

    public void setAnnualNum(String annualNum) {
        this.annualNum = annualNum;
    }

    @Basic
    @Column(name = "usable")
    @org.hibernate.annotations.Type(type="yes_no")
    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "office_id")
    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }
    @Basic
    @Column(name = "office_name")
    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Basic
    @Column(name = "clazz")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    @Basic
    @Column(name = "id_card_no")
    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }



    @Basic
    @Column(name = "ethnicity")
    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }
    @Basic
    @Column(name = "birthplace")
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    @Basic
    @Column(name = "marriage")
    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }
    @Basic
    @Column(name = "political_status")
    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }
    @Basic
    @Column(name = "highest_education")
    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }
    @Basic
    @Column(name = "profession")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    @Basic
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "emergency_contact")
    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    @Basic
    @Column(name = "relationship")
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    @Basic
    @Column(name = "emergency_phone")
    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }
    @Basic
    @Column(name = "domicile")
    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }
    @Basic
    @Column(name = "law_ship_storage_place")
    public String getLawShipStoragePlace() {
        return lawShipStoragePlace;
    }

    public void setLawShipStoragePlace(String lawShipStoragePlace) {
        this.lawShipStoragePlace = lawShipStoragePlace;
    }
    @Basic
    @Column(name = "law_ship_create_date")
    public String getLawShipCreateDate() {
        return lawShipCreateDate;
    }

    public void setLawShipCreateDate(String lawShipCreateDate) {
        this.lawShipCreateDate = lawShipCreateDate;
    }
    @Basic
    @Column(name = "personnel_files_storage_place")
    public String getPersonnelFilesStoragePlace() {
        return personnelFilesStoragePlace;
    }

    public void setPersonnelFilesStoragePlace(String personnelFilesStoragePlace) {
        this.personnelFilesStoragePlace = personnelFilesStoragePlace;
    }
    @Basic
    @Column(name = "file_number")
    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }
    @Basic
    @Column(name = "file_create_date")
    public String getFileCreateDate() {
        return fileCreateDate;
    }

    public void setFileCreateDate(String fileCreateDate) {
        this.fileCreateDate = fileCreateDate;
    }
    @Basic
    @Column(name = "pre_law_office")
    public String getPreLawOffice() {
        return preLawOffice;
    }

    public void setPreLawOffice(String preLawOffice) {
        this.preLawOffice = preLawOffice;
    }
    @Basic
    @Column(name = "occupation_no")
    public String getOccupationNo() {
        return occupationNo;
    }

    public void setOccupationNo(String occupationNo) {
        this.occupationNo = occupationNo;
    }


    @Basic
    @Column(name = "department_name")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "department_id")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column(name = "last_time_change_password")
    public Date getLastTimeChangePassword() {
        return lastTimeChangePassword;
    }

    public void setLastTimeChangePassword(Date lastTimeChangePassword) {
        this.lastTimeChangePassword = lastTimeChangePassword;
    }
    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    @Lob
    @Basic
    @Column(name = "account_permissions" , columnDefinition = "TEXT")
    public String getAccountPermissions() {
        return accountPermissions;
    }

    public void setAccountPermissions(String accountPermissions) {
        this.accountPermissions = accountPermissions;
    }
    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    @Basic
    @Column(name = "fee")
    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }


    @Override
    public String toString() {
        return super.toString()+"User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", officeId='" + officeId + '\'' +
                ", officeName='" + officeName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", lastTimeChangePassword=" + lastTimeChangePassword +
                ", userType='" + userType + '\'' +
                ", accountPermissions='" + accountPermissions + '\'' +
                ", realName='" + realName + '\'' +
                ", fee=" + fee +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", clazz='" + clazz + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", marriage='" + marriage + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", highestEducation='" + highestEducation + '\'' +
                ", profession='" + profession + '\'' +
                ", school='" + school + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", relationship='" + relationship + '\'' +
                ", emergencyPhone='" + emergencyPhone + '\'' +
                ", domicile='" + domicile + '\'' +
                ", lawShipStoragePlace='" + lawShipStoragePlace + '\'' +
                ", lawShipCreateDate='" + lawShipCreateDate + '\'' +
                ", personnelFilesStoragePlace='" + personnelFilesStoragePlace + '\'' +
                ", fileNumber='" + fileNumber + '\'' +
                ", fileCreateDate='" + fileCreateDate + '\'' +
                ", preLawOffice='" + preLawOffice + '\'' +
                ", occupationNo='" + occupationNo + '\'' +
                '}';
    }
}
