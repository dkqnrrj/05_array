package edu.kh.array2.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Example {

	/*
	 * 2차원 배열
	 * 
	 * - 자료형이 같은 1차원 배열을 묶음으로 다루는 것 행, 열 개념 추가
	 * 
	 */

	public void ex1() {

		// 2차원 배열 선언

		int arr[][]; // int 2차원 배열을 참조하는 참조 변수 선언을 했다.
						// 참조형 == 참조 변수 == 레퍼런스 변수 == 레퍼런스

		// 2차원 배열 할당
		// new 자료형 [행 크기] [열 크기]

		arr = new int[2][3];

		// heap 영역에 int 2차원 배열 2행 3열 공간을 할당

		// 2차원 배열 초기화
		// 1) 행, 열 인덱스를 이용해서 직접 초기화
		/*
		 * arr[0][0] = 10; arr[0][1] = 20; arr[0][2] = 30;
		 * 
		 * arr[1][0] = 40; arr[1][1] = 50; arr[1][2] = 60;
		 */

		// 2) 2중 for문을 이용한 초기화

		int num = 10; // 배열 요소 초기화에 사용할 변수 선언

		// 배열 길이
		// 배열명.length 는 변수가 직접 참조하고 있는 배열의 길이를 반환함

		System.out.println(arr.length); // 2(행길이)
		// arr이 참조하고 있는 2차원 배열의 행의 길이

		System.out.println(arr[0].length); // 3(열길이)
		// arr[0] 행이 참조하고 있는 1차원 배열의 (열) 길이

		System.out.println(arr[1].length); // 3(열길이)
		// arr[1] 행이 참조하고 있는 1차원 배열의 (열) 길이

		for (int row = 0; row < arr.length; row++) { // 행 반복(0,1)

			for (int col = 0; col < arr[row].length; col++) {

				arr[row][col] = num;
				num += 10;

			}

		}

		System.out.println("toString() : " + Arrays.toString(arr));
		// Arrays.toString(배열명) = 참조하고 있는 1차원 배열 값을 문자열로 반환

		// Arrays.deepToString(배열명) = 참조하고 있는 배열의 데이터가 나오는 부분까지 침투하여 모든 값을 문자열로 변환

		System.out.println("deepToString : " + Arrays.deepToString(arr));

	}

	public void ex2() {

		// 2차원 배열 선언과 동시에 초기화
		// 3행 3열 짜리 정수형 2차원 배열 선언과 동시에
		// 1 ~ 9 까지 초기화

		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// 행 별로 합 출력

		for (int row = 0; row < arr.length; row++) { // 행 반복

			int sum = 0;

			for (int col = 0; col < arr[row].length; col++) { // 열 반복

				sum += arr[row][col];

			}

			System.out.printf("%d행의 합 : %d\n", row, sum);

		}

		System.out.println("-------------------------------------");

		// 열 별로 합 출력
		// 0열의 합 : 12
		// 1열의 합 : 15
		// 2열의 합 : 18

		for (int col = 0; col < arr[0].length; col++) { // 열 반복

			int sum = 0;

			for (int row = 0; row < arr.length; row++) { // 행 반복

				sum += arr[row][col];

			}

			System.out.printf("%d열의 합 : %d\n", col, sum);

		}
		// 전체 합 출력
		// 전체 합 : 45

		int sum = 0;

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {

				sum += arr[row][col];

			}
		}
		System.out.println("전체합 : " + sum);
	}

	public void ex3() {

		// 가변 배열
		// 2차원 배열 생성 시 마지막 배열 차수(열) 를 지정하지 않고
		// 나중에 서로 크기가 다른 1차원 배열을 생성하여 참조하는 배열

		char[][] arr = new char[4][];

		// char 2차원 배열 생성 시 행부분만 생성 한 것.

		arr[0] = new char[3]; // 0행에 3열짜리 1차원 배열을 생성하여 주소값 저장한 것.
		arr[1] = new char[4]; // 1행에 4열짜리 1차원 배열을 생성하여 주소값 저장한 것.
		arr[2] = new char[5];
		arr[3] = new char[2];

		char ch = 'a';

		for (int row = 0; row < arr.length; row++) { // 행 4개 짜리

			for (int col = 0; col < arr[row].length; col++) {

				arr[row][col] = ch++;

			}

		}

		System.out.println(Arrays.deepToString(arr));

	}

	public void ex4() { // 빙고 만들기

		// 1. 5x5 짜리 2차원 배열을 만든다
		// 2. 1~25 까지의 난수를 생성해서 만든 배열 안에 넣는다.
		// 3. 숫자 입력 기능을 만든다.
		// 4. 입력 받은 숫자를 배열 안의 숫자들에 대입해서 맞으면 0으로 바꾸게 한다.
		// 5. 수정 된 배열을 출력 시키고 다시 숫자를 입력 하는 기능을 띄운다.

		Scanner sc = new Scanner(System.in);

		int arr[][];

		arr = new int[5][5]; // 1. 완료

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {

				int random = (int) Math.round(Math.random() * 25 + 1);

				arr[row][col] = random;

				for (int x = 0; x < arr.length; x++) {

					for (int y = 0; y < arr.length; y++) {

						if (random == arr[x][y]) {

							random--;

							break; // 2. 완료
						}
					}
				}
				
				System.out.print(arr[row][col] + " ");
				
			}
			System.out.println();
		}

		

		for (int test = 0; test <= 9999; test++) {

			System.out.print("1 ~ 25 의 숫자를 입력하세요.  (종료: 0) > ");

			int input = sc.nextInt(); // 3. 완료

			for (int row = 0; row < arr.length; row++) {

				for (int col = 0; col < arr[row].length; col++) {
					
					
					System.out.print(arr[row][col] + " ");
				}
				System.out.println();
			}
			
	

			boolean flag = false;

			for (int row = 0; row < arr[0].length; row++) {
				for (int col = 0; col < arr[0].length; col++) {
					
				
				if (arr[row][col] == input) {

					arr[row][col] = 0;

					flag = true; // 4. 5. 완료

				}
				}

			}

		}
	}
}
