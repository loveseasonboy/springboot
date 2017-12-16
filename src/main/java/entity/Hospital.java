package entity;

/**
 * Created by hehd on 2017/4/21.
 *
 * @author 何海东
 */
public class Hospital {
    private String name,
            dhhm,
            dz,
            AnotherName,
            Rank,
            nature,
            Year,
            Departments,
            Leader,
            Workers,
            HBedNum,
            ServiceNum,
            Insurance,
            Fax,
            Code,
            Web,
            Line,
            city,
            district,
            updated,
            province;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getAnotherName() {
        return AnotherName;
    }

    public void setAnotherName(String anotherName) {
        AnotherName = anotherName;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getDepartments() {
        return Departments;
    }

    public void setDepartments(String departments) {
        Departments = departments;
    }

    public String getLeader() {
        return Leader;
    }

    public void setLeader(String leader) {
        Leader = leader;
    }

    public String getWorkers() {
        return Workers;
    }

    public void setWorkers(String workers) {
        Workers = workers;
    }

    public String getHBedNum() {
        return HBedNum;
    }

    public void setHBedNum(String HBedNum) {
        this.HBedNum = HBedNum;
    }

    public String getServiceNum() {
        return ServiceNum;
    }

    public void setServiceNum(String serviceNum) {
        ServiceNum = serviceNum;
    }

    public String getInsurance() {
        return Insurance;
    }

    public void setInsurance(String insurance) {
        Insurance = insurance;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getLine() {
        return Line;
    }

    public void setLine(String line) {
        Line = line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", dhhm='" + dhhm + '\'' +
                ", dz='" + dz + '\'' +
                ", AnotherName='" + AnotherName + '\'' +
                ", Rank='" + Rank + '\'' +
                ", nature='" + nature + '\'' +
                ", Year='" + Year + '\'' +
                ", Departments='" + Departments + '\'' +
                ", Leader='" + Leader + '\'' +
                ", Workers='" + Workers + '\'' +
                ", HBedNum='" + HBedNum + '\'' +
                ", ServiceNum='" + ServiceNum + '\'' +
                ", Insurance='" + Insurance + '\'' +
                ", Fax='" + Fax + '\'' +
                ", Code='" + Code + '\'' +
                ", Web='" + Web + '\'' +
                ", Line='" + Line + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", updated='" + updated + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
