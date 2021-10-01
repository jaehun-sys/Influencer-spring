package Influencer.Influencerspring.domain;

public class InfProEngTex {
    /* 출력 변수 */
    private int rankno;
    private String pic;
    private String username;
    private String bio;
    private String cat;
    private String reaction;
    private String activity;
    private String followers;

    /* 연산할 변수 */
    private String realInf;

    /* 입력(조건) 변수 */
    private String inputCat;
    private String inputInfAge;
    private String inputInfSex;
    private String inputAudSex;
    private String inputAudAge;
    private double rf_weight;
    private double re_weight;
    private double ac_weight;

    public double getRf_weight() {
        return rf_weight;
    }

    public void setRf_weight(double rf_weight) {
        this.rf_weight = rf_weight;
    }

    public double getRe_weight() {
        return re_weight;
    }

    public void setRe_weight(double re_weight) {
        this.re_weight = re_weight;
    }

    public double getAc_weight() {
        return ac_weight;
    }

    public void setAc_weight(double ac_weight) {
        this.ac_weight = ac_weight;
    }

    public String getRealInf() {
        return realInf;
    }

    public void setRealInf(String realInf) {
        this.realInf = realInf;
    }

    public int getRankno() {
        return rankno;
    }

    public void setRankno(int rankno) {
        this.rankno = rankno;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

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