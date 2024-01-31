package com.ohgiraffers.toyproject.exception;

/*설명. 사용자가 선택지에 없는 번호를 입력했을 경우에 발생하는 예외 처리*/
public class ChoiceException extends Exception{
    public ChoiceException(String message) {
        super(message);
    }
}
