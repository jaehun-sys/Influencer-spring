package Influencer.Influencerspring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InfFolRate {
    @Id
    private String inf_pk;
    @Column
    private float rate_sex_f;
    @Column
    private String rate_susp;
    @Column
    private String rate_real;
    @Column
    private String rate_mass;
    @Column
    private String rate_inf;
    @Column
    private String real_fol_count;
    @Column
    private String real_fol_rate;


    public String getInf_pk() {
        return inf_pk;
    }

    public void setInf_pk(String inf_pk) {
        this.inf_pk = inf_pk;
    }

    public float getRate_sex_f() {
        return rate_sex_f;
    }

    public void setRate_sex_f(float rate_sex_f) {
        this.rate_sex_f = rate_sex_f;
    }

    public String getRate_susp() {
        return rate_susp;
    }

    public void setRate_susp(String rate_susp) {
        this.rate_susp = rate_susp;
    }

    public String getRate_real() {
        return rate_real;
    }

    public void setRate_real(String rate_real) {
        this.rate_real = rate_real;
    }

    public String getRate_mass() {
        return rate_mass;
    }

    public void setRate_mass(String rate_mass) {
        this.rate_mass = rate_mass;
    }

    public String getRate_inf() {
        return rate_inf;
    }

    public void setRate_inf(String rate_inf) {
        this.rate_inf = rate_inf;
    }

    public String getReal_fol_count() {
        return real_fol_count;
    }

    public void setReal_fol_count(String real_fol_count) {
        this.real_fol_count = real_fol_count;
    }

    public String getReal_fol_rate() {
        return real_fol_rate;
    }

    public void setReal_fol_rate(String real_fol_rate) {
        this.real_fol_rate = real_fol_rate;
    }
}
