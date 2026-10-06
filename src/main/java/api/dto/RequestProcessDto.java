package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class RequestProcessDto {

    private Long applId;
    private Long staffid;
    private String action;

    public RequestProcessDto() {}

    public RequestProcessDto(Long applId, Long staffid, String action) {
        this.applId = applId;
        this.staffid = staffid;
        this.action = action;
    }

    public Long getApplId() { return applId; }
    public void setApplId(Long applId) { this.applId = applId; }

    public Long getStaffid() { return staffid; }
    public void setStaffid(Long staffid) { this.staffid = staffid; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
}