package com.datangedu.cn.model.sysUser;

public class StbWithBLOBs extends Stb {
    private String name;

    private String gender;

    private String email;

    private String location;

    private String channel;

    private String program;

    private String starttime;

    private String endtime;

    private String startviewing;

    private String endviewing;

    private String pay;

    private String pro;

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program == null ? null : program.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getStartviewing() {
        return startviewing;
    }

    public void setStartviewing(String startviewing) {
        this.startviewing = startviewing == null ? null : startviewing.trim();
    }

    public String getEndviewing() {
        return endviewing;
    }

    public void setEndviewing(String endviewing) {
        this.endviewing = endviewing == null ? null : endviewing.trim();
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay == null ? null : pay.trim();
    }
}