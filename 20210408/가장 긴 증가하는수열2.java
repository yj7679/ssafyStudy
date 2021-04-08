package com.ssafy.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IncreaseSq2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//수열 크기
		int[] arr = new int[N];	//수열 배열
		ArrayList<Integer> result = new ArrayList();	//가장 긴 수열
		
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++)	//입력
		{
			arr[i] = Integer.parseInt(s[i]);
		}
		
		for(int i=0;i<N;i++)	//수열 크기만큼
		{
			if(i==0)	//첫번쨰 수열은 리스트 안에 삽입
			{
				result.add(arr[i]);
			}
			else if(arr[i]> result.get(result.size()-1))	//숫자가 리스트의 마지막 값보다 크면 삽입
			{
				result.add(arr[i]);
			}
			else {			//숫자가 리스트의 마지막값보다 작으면
				for(int j=0;j<result.size();j++)	//리스트 앞에서부터 해당 숫자보다 큰값을 검색해서 교체 
				{
					if(arr[i]<=result.get(j))
					{
						result.set(j, arr[i]);
						break;
					}
				}
			}
		}
		System.out.println(result.size());
	}

}
