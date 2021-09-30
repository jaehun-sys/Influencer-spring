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

    /* 입력(조건) 변수 */
    private String inputCat;
    private String inputInfAge;
    private String inputInfSex;
    private String inputAudSex;
    private String inputAudAge;

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