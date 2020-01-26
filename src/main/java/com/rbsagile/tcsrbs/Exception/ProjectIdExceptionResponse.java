package com.rbsagile.tcsrbs.Exception;

public class ProjectIdExceptionResponse {


    private String DeskNo;

    public ProjectIdExceptionResponse(String deskNo) {
        DeskNo = deskNo;
    }

    public String getDeskNo() {
        return DeskNo;
    }

    public void setDeskNo(String deskNo) {
        DeskNo = deskNo;
    }
}
