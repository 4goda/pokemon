package com.ohgiraffers.toyproject.repository;

import com.ohgiraffers.toyproject.aggregate.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {
    private String filePath = "src/main/java/com/ohgiraffers/toyproject/db/skill.dat";

    /* 설명. 스킬 리스트를 불러온다. */
    private List<Skill> skillList = new ArrayList<>();

    public SkillRepository() {

        List<Skill> skills = new ArrayList<>();

        File file = new File(filePath);

        /* 설명. 파일이 없으면 스킬 리스트를 생성한다. */
        if(!file.exists()){
            skills.add(new Skill("몸통 박치기", 20, "노멀"));
            skills.add(new Skill("100만볼트", 30, "전기"));
            skills.add(new Skill("불꽃세례", 30, "불"));
            skills.add(new Skill("물대포", 30, "물"));
            skills.add(new Skill("지진", 30, "땅"));
            skills.add(new Skill("잎날가르기", 30, "풀"));
            skills.add(new Skill("파괴광선", 1000, "노멀"));

            saveSkills(skills);
        }

        loadSkills();
    }

    /* 설명. 스킬리스트 세이브 파일 예외를 처리한다. */
    public void  saveSkills(List<Skill> skills) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath)));

            for(Skill s : skills) {
                oos.writeObject(s);
            }

            oos.flush();
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

    /* 설명. 스킬리스트 불러올 때 발생 되는 예외를 처리한다. */
    private void loadSkills() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filePath)));

            while (true) {
                skillList.add((Skill) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("LOADING...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Skill> selectAllSkills() {
        return skillList;
    }

    public Skill selectSkill(String name) {
        for(Skill s : skillList) {
            if(s.getName().equals(name)) return s;
        }

        return null;
    }

}
