package com.ohgiraffers.toyproject.repository;

import com.ohgiraffers.toyproject.aggregate.Skill;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {

    private List<Skill> skillList = new ArrayList<>();      // 불러오기용 List

    public SkillRepository() {
    }
    void Skills() {

        // 저장용 List
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("몸통박치기", 20, "노멀"));
        skills.add(new Skill("100만볼트", 30, "전기"));
        skills.add(new Skill("불꽃세례", 30, "불"));
        skills.add(new Skill("물대포", 30, "물"));
        skills.add(new Skill("지진", 30, "땅"));
        skills.add(new Skill("잎날가르기", 30, "풀"));

        saveSkills(skills);
        // 여기까지. loadSkills(); : 스킬 파일 불러오기 만들기

    }
        //몸통박치기 , 할퀴기, 물대포, 백만볼트, 불꽃세례, 깨물기, 지진

    public void  saveSkills(List<Skill> skills) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/com/ohgiraffers/toyproject/db/skill.dat")));

            for(Skill s : skills) {
                oos.writeObject(s);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



}
