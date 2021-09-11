package Influencer.Influencerspring.domain;

public class Member {
    private String inf_pk;
    private float rate_sex_f;
    private float rate_sex_m;
    private float rate_susp;
    private float rate_real;
    private float rate_mass;
    private float rate_inf;
    private float real_fol_count;
    private float real_fol_rate;

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

    public float getRate_sex_m() {
        return rate_sex_m;
    }

    public void setRate_sex_m(float rate_sex_m) {
        this.rate_sex_m = rate_sex_m;
    }

    public float getRate_susp() {
        return rate_susp;
    }

    public void setRate_susp(float rate_susp) {
        this.rate_susp = rate_susp;
    }

    public float getRate_real() {
        return rate_real;
    }

    public void setRate_real(float rate_real) {
        this.rate_real = rate_real;
    }

    public float getRate_mass() {
        return rate_mass;
    }

    public void setRate_mass(float rate_mass) {
        this.rate_mass = rate_mass;
    }

    public float getRate_inf() {
        return rate_inf;
    }

    public void setRate_inf(float rate_inf) {
        this.rate_inf = rate_inf;
    }

    public float getReal_fol_count() {
        return real_fol_count;
    }

    public void setReal_fol_count(float real_fol_count) {
        this.real_fol_count = real_fol_count;
    }

    public float getReal_fol_rate() {
        return real_fol_rate;
    }

    public void setReal_fol_rate(float real_fol_rate) {
        this.real_fol_rate = real_fol_rate;
    }
}
