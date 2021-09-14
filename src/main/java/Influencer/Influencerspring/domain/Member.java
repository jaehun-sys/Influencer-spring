package Influencer.Influencerspring.domain;

public class Member {
    private Long id;    //시스템 상의 id. 사용자가 정하는 id 말고
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
