package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.Battle;

public class BattleService {
    public void startBattle(Battle battle) {
        battle.startBattle();
        /* TODO.
         *  while 반복문으로 포켓몬 객체들 중 하나라도 hp가 0이하로 내려갈 때까지 전투 진행
         *  전투 종료시 endBattle(battle, {이긴포켓몬 객체}.이름);
         *
         */
    }



    public void endBattle(Battle battle) {  // 매개변수에 String 포켓몬이름 추가
        battle.endBattle();
        /* TODO.
        *   if문으로 적이나 내 포켓몬 객체의 hp가 0이 되었을 경우나, 도망가기를 선택했을 경우 배틀을 종료.
        *   "{포켓몬이름} 포켓몬이 승리하였습니다."
        * */
    }

}
