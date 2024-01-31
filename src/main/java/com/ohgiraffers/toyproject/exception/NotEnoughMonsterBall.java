package com.ohgiraffers.toyproject.exception;

/* 설명. 사용자가 몬스터볼을 모두 소진하고서 몬스터볼을 다시 사용하려는 경우에 발생하는 예외를 처리한다. */
public class NotEnoughMonsterBall extends Exception{
    public NotEnoughMonsterBall(String message) {
        super(message);
    }
}
