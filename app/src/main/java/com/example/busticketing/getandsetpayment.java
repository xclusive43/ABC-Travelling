package com.example.busticketing;

public class getandsetpayment {

    String cardnumber1,cardtype,name1,seatsname,tickekid,age,mobile,gender,address,busname,from,to,date,time,busfare;

    public getandsetpayment() {
    }

    public getandsetpayment(String cardnumber1, String cardtype, String name1, String seatsname,
                            String tickekid, String age, String mobile, String gender, String address,
                            String busname, String from, String to, String date, String time, String busfare) {
        this.cardnumber1 = cardnumber1;
        this.cardtype = cardtype;
        this.name1 = name1;
        this.seatsname = seatsname;
        this.tickekid = tickekid;
        this.age = age;
        this.mobile = mobile;
        this.gender = gender;
        this.address = address;
        this.busname = busname;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.busfare = busfare;
    }

    public String getCardnumber1() {
        return cardnumber1;
    }

    public void setCardnumber1(String cardnumber1) {
        this.cardnumber1 = cardnumber1;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getSeatsname() {
        return seatsname;
    }

    public void setSeatsname(String seatsname) {
        this.seatsname = seatsname;
    }

    public String getTickekid() {
        return tickekid;
    }

    public void setTickekid(String tickekid) {
        this.tickekid = tickekid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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

    public String getBusfare() {
        return busfare;
    }

    public void setBusfare(String busfare) {
        this.busfare = busfare;
    }
}
