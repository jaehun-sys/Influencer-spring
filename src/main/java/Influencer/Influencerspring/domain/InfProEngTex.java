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
    private String incat;       // 웹 form으로 부터 ip.cat 담을 변수
    private String insex;       // 웹 form으로부터 ip.inf_sex 담을 변수
    private int min_age;        // 인플루언서 최소 나이
    private int max_age;        // 인플루언서 최대 나이
    private int aud_min_age;    // 오디언스 최소 나이
    private int aud_max_age;    // 오디언스 최대 나이
    private String inf_minmax;     //
    private String aud_minmax;  //

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

    public String getIncat() {
        return incat;
    }

    public void setIncat(String incat) {
        this.incat = incat;
    }

    public String getInsex() {
        return insex;
    }

    public void setInsex(String insex) {
        this.insex = insex;
    }

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
    }

    public int getMax_age() {
        return max_age;
    }

    public void setMax_age(int max_age) {
        this.max_age = max_age;
    }

    public int getAud_min_age() {
        return aud_min_age;
    }

    public void setAud_min_age(int aud_min_age) {
        this.aud_min_age = aud_min_age;
    }

    public int getAud_max_age() {
        return aud_max_age;
    }

    public void setAud_max_age(int aud_max_age) {
        this.aud_max_age = aud_max_age;
    }

    public String getInf_minmax(){
        return inf_minmax;
    }

    public void setInf_minmax(){
        this.inf_minmax = inf_minmax;
    }

    public String getAud_minmax() {
        return aud_minmax;
    }

    public void setAud_minmax(String aud_minmax) {
        this.aud_minmax = aud_minmax;
    }
}