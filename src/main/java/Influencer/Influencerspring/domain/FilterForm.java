package Influencer.Influencerspring.domain;

public class FilterForm {

//    private int inf_age_start ;
//    private int inf_age_end  ;
    private String inputCat;
    private String inputInfAge;
    private String inputInfSex;
    private String inputAudSex;
    private String inputAudAge;


    public String getInputCat() {
        return inputCat;
    }

    public void setInputCat(String inputCat) {
        this.inputCat = inputCat;
    }

    public String getInputInfAge() {
        return inputInfAge;
    }

    public void setInputInfAge(String inputInfAge) {
        this.inputInfAge = inputInfAge;
    }

    public String getInputInfSex() {
        return inputInfSex;
    }

    public void setInputInfSex(String inputInfSex) {
        this.inputInfSex = inputInfSex;
    }

    public String getInputAudSex() {
        return inputAudSex;
    }

    public void setInputAudSex(String inputAudSex) {
        this.inputAudSex = inputAudSex;
    }

    public String getInputAudAge() {
        return inputAudAge;
    }

    public void setInputAudAge(String inputAudAge) {
        this.inputAudAge = inputAudAge;
    }
}
