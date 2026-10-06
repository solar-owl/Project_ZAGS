package api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApplicationRequestDto {

    private String mode;

    // заявитель
    private String personalLastName;
    private String personalFirstName;
    private String personalMiddleName;
    private String personalPhoneNumber;
    private String personalNumberOfPassport;
    private String personalAddress;

    // гражданин
    private String citizenLastName;
    private String citizenFirstName;
    private String citizenMiddleName;
    private String citizenBirthDate;
    private String citizenNumberOfPassport;
    private String citizenGender;
    private String citizenAddress;

    // свадьба
    private String dateOfMarriage;
    private String newLastName;
    private String anotherPersonLastName;
    private String anotherPersonFirstName;
    private String anotherPersonMiddleName;
    private String anotherPersonPassport;

    @JsonProperty("birth_of_anotoherPerson") // опечатка API
    private String birthOfAnotherPerson;

    // рождение
    private String birth_place;
    private String birth_mother;
    private String birth_father;
    private String birth_grandpa;
    private String birth_grandma;

    // смерть
    private String death_dateOfDeath;
    private String death_placeOfDeath;

    public ApplicationRequestDto() {}

    //mode
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

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

    public String getPersonalAddress() { return personalAddress; }
    public void setPersonalAddress(String v) { this.personalAddress = v; }

    public String getCitizenLastName() { return citizenLastName; }
    public void setCitizenLastName(String v) { this.citizenLastName = v; }

    public String getCitizenFirstName() { return citizenFirstName; }
    public void setCitizenFirstName(String v) { this.citizenFirstName = v; }

    public String getCitizenMiddleName() { return citizenMiddleName; }
    public void setCitizenMiddleName(String v) { this.citizenMiddleName = v; }

    public String getCitizenBirthDate() { return citizenBirthDate; }
    public void setCitizenBirthDate(String v) { this.citizenBirthDate = v; }

    public String getCitizenNumberOfPassport() { return citizenNumberOfPassport; }
    public void setCitizenNumberOfPassport(String v) { this.citizenNumberOfPassport = v; }

    public String getCitizenGender() { return citizenGender; }
    public void setCitizenGender(String v) { this.citizenGender = v; }

    public String getCitizenAddress() { return citizenAddress; }
    public void setCitizenAddress(String v) { this.citizenAddress = v; }

    public String getDateOfMarriage() { return dateOfMarriage; }
    public void setDateOfMarriage(String v) { this.dateOfMarriage = v; }

    public String getNewLastName() { return newLastName; }
    public void setNewLastName(String v) { this.newLastName = v; }

    public String getAnotherPersonLastName() { return anotherPersonLastName; }
    public void setAnotherPersonLastName(String v) { this.anotherPersonLastName = v; }

    public String getAnotherPersonFirstName() { return anotherPersonFirstName; }
    public void setAnotherPersonFirstName(String v) { this.anotherPersonFirstName = v; }

    public String getAnotherPersonMiddleName() { return anotherPersonMiddleName; }
    public void setAnotherPersonMiddleName(String v) { this.anotherPersonMiddleName = v; }

    public String getAnotherPersonPassport() { return anotherPersonPassport; }
    public void setAnotherPersonPassport(String v) { this.anotherPersonPassport = v; }

    public String getBirthOfAnotherPerson() { return birthOfAnotherPerson; }
    public void setBirthOfAnotherPerson(String v) { this.birthOfAnotherPerson = v; }

    public String getBirth_place() { return birth_place; }
    public void setBirth_place(String v) { this.birth_place = v; }

    public String getBirth_mother() { return birth_mother; }
    public void setBirth_mother(String v) { this.birth_mother = v; }

    public String getBirth_father() { return birth_father; }
    public void setBirth_father(String v) { this.birth_father = v; }

    public String getBirth_grandpa() { return birth_grandpa; }
    public void setBirthGrandpa(String v) { this.birth_grandpa = v; }

    public String getBirth_grandma() { return birth_grandma; }
    public void setBirthGrandma(String v) { this.birth_grandma = v; }

    public String getDeath_dateOfDeath() { return death_dateOfDeath; }
    public void setDeathDateOfDeath(String v) { this.death_dateOfDeath = v; }

    public String getDeath_placeOfDeath() { return death_placeOfDeath; }
    public void setDeathPlaceOfDeath(String v) { this.death_placeOfDeath = v; }
}