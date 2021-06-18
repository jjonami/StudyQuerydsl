package com.jjonami.querydsl.entity;

import lombok.*;

import javax.persistence.*;

import static com.jjonami.querydsl.common.StringValue.CL_TEAM_IDX;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"idx", "name", "age"})
public class Member {
    @Id @GeneratedValue
    private Long idx;
    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = CL_TEAM_IDX)
    private Team team;

    public Member(String name, int age, Team team){
        this.name = name;
        this.age = age;
        if(team != null){
            changeTeam(team);
        }
    }
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Member(String name){
        this.name = name;
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }
}
