package Influencer.Influencerspring.domain;

public class Term {
    /* 입력 변수 */
    private String keyterm;
    private String username;

    /* 출력 변수 */
    private String term_rank;
    private String related_term;
    private String similarity;

    public String getKeyterm() {
        return keyterm;
    }

    public void setKeyterm(String keyterm) {
        this.keyterm = keyterm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTerm_rank() {
        return term_rank;
    }

    public void setTerm_rank(String term_rank) {
        this.term_rank = term_rank;
    }

    public String getRelated_term() {
        return related_term;
    }

    public void setRelated_term(String related_term) {
        this.related_term = related_term;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
