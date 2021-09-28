package Influencer.Influencerspring.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "hashtag")
@Entity
public class Hashtag {
    @Id
    private String inf_pk;
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "related_rank")
    private String related_rank;
    @Column(name = "related_hash")
    private String related_hash;
    @Column(name = "avg_liked")
    private String avg_liked;
    @Column(name = "related_username")
    private String related_username;

    public String getInf_pk() {
        return inf_pk;
    }

    public void setInf_pk(String inf_pk) {
        this.inf_pk = inf_pk;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRelated_rank() {
        return related_rank;
    }

    public void setRelated_rank(String related_rank) {
        this.related_rank = related_rank;
    }

    public String getRelated_hash() {
        return related_hash;
    }

    public void setRelated_hash(String related_hash) {
        this.related_hash = related_hash;
    }

    public String getAvg_liked() {
        return avg_liked;
    }

    public void setAvg_liked(String avg_liked) {
        this.avg_liked = avg_liked;
    }

    public String getRelated_username() {
        return related_username;
    }

    public void setRelated_username(String related_username) {
        this.related_username = related_username;
    }
}
