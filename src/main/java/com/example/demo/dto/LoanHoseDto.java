package com.example.demo.dto;

/**
 * Created by gavin on 2017/9/18.
 */
public class LoanHoseDto {
    //房产证第一页
    private String permitP1;
    //房产证第二页
    private String permitP2;
    //房产证第三页
    private String permitP3;
    //房产证第四页
    private String permitP4;
    //是否在押
    private String mortgaged;

    public String getPermitP1() {
        return permitP1;
    }

    public void setPermitP1(String permitP1) {
        this.permitP1 = permitP1;
    }

    public String getPermitP2() {
        return permitP2;
    }

    public void setPermitP2(String permitP2) {
        this.permitP2 = permitP2;
    }

    public String getPermitP3() {
        return permitP3;
    }

    public void setPermitP3(String permitP3) {
        this.permitP3 = permitP3;
    }

    public String getPermitP4() {
        return permitP4;
    }

    public void setPermitP4(String permitP4) {
        this.permitP4 = permitP4;
    }

    public String getMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(String mortgaged) {
        this.mortgaged = mortgaged;
    }
}
