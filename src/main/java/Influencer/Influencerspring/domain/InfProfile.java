package Influencer.Influencerspring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InfProfile {
    private String inf_pk;
    private String inf_username;
    private String bio;
    private String fol_count;
    private String folwing_count;
    private String feed_count;
    private String cat;
    private String bus_cat_name;
    private String cat_enum;
    private String inf_sex;
    private String inf_age;
    private String pic_url;
    private String real_fol_count;

    @Id
    public String getInf_pk() {
        return inf_pk;
    }

    public void setInf_pk(String inf_pk) {
        this.inf_pk = inf_pk;
    }

    public String getInf_username() {
        return inf_username;
    }

    public void setInf_username(String inf_username) {
        this.inf_username = inf_username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFol_count() {
        return fol_count;
    }

    public void setFol_count(String fol_count) {
        this.fol_count = fol_count;
    }

    public String getFolwing_count() {
        return folwing_count;
    }

    public void setFolwing_count(String folwing_count) {
        this.folwing_count = folwing_count;
    }

    public String getFeed_count() {
        return feed_count;
    }

    public void setFeed_count(String feed_count) {
        this.feed_count = feed_count;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getBus_cat_name() {
        return bus_cat_name;
    }

    public void setBus_cat_name(String bus_cat_name) {
        this.bus_cat_name = bus_cat_name;
    }

    public String getCat_enum() {
        return cat_enum;
    }

    public void setCat_enum(String cat_enum) {
        this.cat_enum = cat_enum;
    }

    public String getInf_sex() {
        return inf_sex;
    }

    public void setInf_sex(String inf_sex) {
        this.inf_sex = inf_sex;
    }

    public String getInf_age() {
        return inf_age;
    }

    public void setInf_age(String inf_age) {
        this.inf_age = inf_age;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getReal_fol_count() {
        return real_fol_count;
    }

    public void setReal_fol_count(String real_fol_count) {
        this.real_fol_count = real_fol_count;
    }
}
