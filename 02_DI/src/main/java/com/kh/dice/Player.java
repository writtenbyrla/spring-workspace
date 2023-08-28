package com.kh.dice;

import com.kh.dice.Player;

import lombok.Data;

@Data
public class Player {
	
	private Dice dice;
	private int totalValue;
	
	public Player() {}
	
	// @Data로 기본생성자까지만 만들어짐
	public Player(Dice dice) {
		this.dice = dice;
	}
	
	// count 만큼 주사위를 굴려서 합을 매기는 메서드
	public void playDice(int count) {
		System.out.println("==>" + getClass().getName() + ".playDice() start!");
		
		for(int i = 0; i<count; i++) {
			dice.selectedNumber(); // 랜덤값 돌려서 값 1개 받아오기
			
			System.out.println("[" + dice.getClass().getName() + "]의 선택된 수 : " + dice.getValue());
			
			// 총 합
			totalValue += dice.getValue();
		}
		
		System.out.println("==>" + getClass().getName() + ".playDice() end!");
	}
	
	
	
}