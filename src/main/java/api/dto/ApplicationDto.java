package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}