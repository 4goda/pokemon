package com.ohgiraffers.toyproject.service;


import com.ohgiraffers.toyproject.aggregate.Skill;
import com.ohgiraffers.toyproject.repository.SkillRepository;

import java.util.Arrays;
import java.util.List;

public class SkillService {

    private final SkillRepository sr = new SkillRepository();

    public SkillService() {
    }

    public void selectAllSkills() {
        List<Skill> selectedSkills = sr.selectAllSkills();

        System.out.println("===== SkillService으로 반환 됨 =====");
        for(Skill s : selectedSkills) {
            System.out.println(s);
        }
    }

    public void selectSkill(String name) {
        Skill selectedSkill = sr.selectSkill(name);

        if(selectedSkill != null) {
            System.out.println("조회한 스킬은 : " + selectedSkill);
            int calcDamage = calculateSkillDamage(selectedSkill);
            System.out.println("저장된 데미지 : " + selectedSkill.getDamage() + ", " + "계산된 데미지 : " + calcDamage);
        } else {
            System.out.println("존재하지 않는 스킬 이름 입니다");
        }


    }


    public int calculateSkillDamage(Skill skill) {
        int randDamage = (int)(Math.random() * 10 + 1 - 5); // -5 ~ 5 사이에 랜덤 데미지 발생

        return skill.getDamage() + randDamage;
    }

    // 데미지 계산
}
