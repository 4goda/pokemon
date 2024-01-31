package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pokemon;

public class BattleService {

    /* 설명. 계산 된 스킬데미지를 포켓몬의 체력을 감소시키고 사망 여부를 확인한다 */
    public void calcHp(int calcDamage, Pokemon pokemon) {
        if(calcDamage <= 0) {
            System.out.println("잘못된 계산입니다");
            return;
        }
        pokemon.receiveDamage(calcDamage);
        if(!pokemon.getIsAlive()) {
            System.out.println(pokemon.getName() + "이(가) 쓰러졌습니다");
        }
    }

    /* 설명. 전투 종료 시 승리한 포켓몬을 승리문구와 함께 출력한다 */
    public void endBattle(String trainerName, Pokemon selectedPokemon, Pokemon enemeyPokemon) {
        String winnerPokemon = "";
        if(selectedPokemon.isAlive()){
            winnerPokemon = selectedPokemon.getName();
            System.out.println(trainerName + "님의 " + winnerPokemon + " 이(가) " + enemeyPokemon.getName() + " 상대로 승리하였습니다^^");
        }else{
            winnerPokemon = enemeyPokemon.getName();
            System.out.println(trainerName + "님의 " + selectedPokemon.getName() + " 이(가) " + winnerPokemon + " 상대로 패배하였습니다ㅠㅠ");
        }
    }

}
