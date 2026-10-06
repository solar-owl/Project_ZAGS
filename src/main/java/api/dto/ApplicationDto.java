package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDto {

    private Long applicationid;
    private Long citizenid;
    private Long applicantid;
    private Long staffid;
    private String dateofapplication;
    private String kindofapplication;
    private String statusofapplication;
    private String channel;
    private String image;

    public ApplicationDto() {}

    public Long getApplicationid() { return applicationid; }
    public void setApplicationid(Long applicationid) { this.applicationid = applicationid; }

    public Long getCitizenid() { return citizenid; }
    public void setCitizenid(Long citizenid) { this.citizenid = citizenid; }

    public Long getApplicantid() { return applicantid; }
    public void setApplicantid(Long applicantid) { this.applicantid = applicantid; }

    public Long getStaffid() { return staffid; }
    public void setStaffid(Long staffid) { this.staffid = staffid; }

    public String getDateofapplication() { return dateofapplication; }
    public void setDateofapplication(String dateofapplication) { this.dateofapplication = dateofapplication; }

    public String getKindofapplication() { return kindofapplication; }
    public void setKindofapplication(String kindofapplication) { this.kindofapplication = kindofapplication; }

    public String getStatusofapplication() { return statusofapplication; }
    public void setStatusofapplication(String statusofapplication) { this.statusofapplication = statusofapplication; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}