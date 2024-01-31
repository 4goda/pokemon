package com.ohgiraffers.toyproject.exception;

/*설명. 사용자가 회복약을 모두 소진하고서 회복약을 다시 사용하려는 경우에 발생하는 예외 처리*/
public class NotEnoughHealItem extends Exception{
    public NotEnoughHealItem(String message) {
        super(message);
    }
}
