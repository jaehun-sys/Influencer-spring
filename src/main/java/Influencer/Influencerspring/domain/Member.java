package Influencer.Influencerspring.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberno;    //시스템 상의 id. 사용자가 정하는 id 말고

    @Column(name = "name")
    private String name;
    private String memberid;
    private String nickname;
    private String password;
    private String email;
    private String birthday;
    private String mem_sex;
    private String phoneno;


    public Long getMemberno() {
        return memberno;
    }

    public void setMemberno(Long memberno) {
        this.memberno = memberno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMem_sex() {
        return mem_sex;
    }

    public void setMem_sex(String mem_sex) {
        this.mem_sex = mem_sex;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
