package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pokemon;

public class BattleService {
    public void calcHp(int calcDamage, Pokemon pokemon) {
        /* TODO.
         *  포켓몬 객체들 중 하나라도 hp가 0이하로 내려갈 때까지 전투 진행
         *  전투 종료시 endBattle(battle, {이긴포켓몬 객체}.이름);
         */
        if(calcDamage <= 0) {
            System.out.println("잘못된 계산입니다");
            return;
        }
        pokemon.receiveDamage(calcDamage);
        if(!pokemon.getIsAlive()) {
            System.out.println(pokemon.getName() + "이(가) 쓰러졌습니다");
        }


    }



    public void endBattle(String trainerName, Pokemon selectedPokemon, Pokemon enemeyPokemon) {  // 매개변수에 String 포켓몬이름 추가
        /* TODO.
        *   if문으로 적이나 내 포켓몬 객체의 hp가 0이 되었을 경우나, 도망가기를 선택했을 경우 배틀을 종료.
        *   "{포켓몬이름} 포켓몬이 승리하였습니다."
        * */
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
