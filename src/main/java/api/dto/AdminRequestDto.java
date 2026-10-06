package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class AdminRequestDto {

    private String personalLastName;
    private String personalFirstName;
    private String personalMiddleName;
    private String personalPhoneNumber;
    private String personalNumberOfPassport;

    @JsonProperty("dateofbirth")
    private String dateOfBirth;

    public AdminRequestDto() {}

    public String getPersonalLastName() { return personalLastName; }
    public void setPersonalLastName(String v) { this.personalLastName = v; }

    public String getPersonalFirstName() { return personalFirstName; }
    public void setPersonalFirstName(String v) { this.personalFirstName = v; }

    public String getPersonalMiddleName() { return personalMiddleName; }
    public void setPersonalMiddleName(String v) { this.personalMiddleName = v; }

    public String getPersonalPhoneNumber() { return personalPhoneNumber; }
    public void setPersonalPhoneNumber(String v) { this.personalPhoneNumber = v; }

    public String getPersonalNumberOfPassport() { return personalNumberOfPassport; }
    public void setPersonalNumberOfPassport(String v) { this.personalNumberOfPassport = v; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String v) { this.dateOfBirth = v; }
}