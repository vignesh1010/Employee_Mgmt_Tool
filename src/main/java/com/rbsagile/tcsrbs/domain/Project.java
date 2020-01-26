package com.rbsagile.tcsrbs.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "Employee Name Required")
    private String Name;
    @NotBlank(message = "Desk NO Required")
    private String deskNo;
    @NotBlank(message = "EmpId Required")
    @Column(updatable =false,unique = true)
    private String empId;
    @NotBlank(message = "Comments Required")
    private String Comments;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date Start_Date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date End_Date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date Created_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date Updated_At;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getDeskNo() {
		return deskNo;
	}

	public void setDeskNo(String deskNo) {
		this.deskNo = deskNo;
	}

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(Date end_Date) {
        End_Date = end_Date;
    }

    public Date getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(Date created_At) {
        Created_At = created_At;
    }

    public Date getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        Updated_At = updated_At;
    }

    public Project() {

    }



    @PrePersist
    protected void onCreate(){
        this.Created_At = new Date();
    }
    @PreUpdate
    protected  void onUpdate(){
        this.Updated_At = new Date();
    }
}
