package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.Skill;
import com.ohgiraffers.toyproject.repository.SkillRepository;

import java.util.List;

public class SkillService {

    private final SkillRepository sr = new SkillRepository();

    public SkillService() {
    }

    /* 설명. 포켓몬 전체 스킬을 선택한다.  */
    public void selectAllSkills() {
        List<Skill> selectedSkills = sr.selectAllSkills();

        for(Skill s : selectedSkills) {
            System.out.println(s);
        }
    }

    /* 설명. 포켓몬 스킬을 선택한다. */
    public int selectSkill(String name) {
        Skill selectedSkill = sr.selectSkill(name);

        /* 설명. 포켓몬 스킬을 선택하면 스킬의 데미지 리턴한다 */
        if(selectedSkill != null) {
            int calcDamage = calculateSkillDamage(selectedSkill);

            return calcDamage;
        }

        /* 설명. 존재하지 않은 스킬을 선택했을 때 출력된다. */
        System.out.println("존재하지 않는 스킬 이름 입니다");

        return 0;
    }

    /* 설명. 포켓몬의 스킬 데미지 계산한다. */
    public int calculateSkillDamage(Skill skill) {

        /* 설명. -5 ~ 5 사이에 랜덤 데미지 발생한다. */
        int randDamage = (int)(Math.random() * 10 + 1 - 5);

        return skill.getDamage() + randDamage;
    }
}
