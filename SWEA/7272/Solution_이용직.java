import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("inputs/input.txt"));
 
        /*
           ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
         */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        /*
           ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
        */
 
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            int len1 = str1.length();
            int len2 = str2.length();
             
            //���� �ٸ��� �ٸ� ���ڿ��̴�.
             
            System.out.print("#"+ test_case +" ");
            if (len1!= len2) {
                System.out.println("DIFF");
                continue;
            }
            //���ڿ� �ΰ��� �ϳ��� ���ϴµ� �߰��� �ٸ��� ������ flag�ִ´�.
            boolean flag = true;
            for(int i=0; i<len1;i++) {
                //�ٸ���
                if(!(check(str1.charAt(i),str2.charAt(i)))) {
                    flag = false;
                    break; // �������ʿ����
                }
                 
            }
            //�񱳳�: �ٶȰ����� flag ==true �ƴϸ� false
            if(flag ==true) {
                System.out.println("SAME");
            }
            else {
                System.out.println("DIFF");
            }
             
             
        }
    }
     
    public static boolean check(char a, char b) {
        char[] noO = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
        char[] oneO = {'A','D','O','P','Q','R'};
        char[] twoO = {'B'};
        //���̺�� ���ļ� ���� FOR���� ���� �� �ְԲ�
        char[][] table = new char[3][];
        table[0] = noO;
        table[1] = oneO;
        table[2] = twoO;
         
        // ���� a�� ���� b�� ������ ����� ����
        int numa=0;
        int numb=0;
         
        for(int i=0; i<table.length;i++) {
            for(int j=0; j<table[i].length; j++) {
                if(a==table[i][j]) {
                    //table�� 0��° �࿡�� ����0���ξֵ��̴ϱ� �׳� i����. �������� ��������
                    numa = i;
                }
                if(b == table[i][j]) {
                    numb= i;
                }
            }
        }
         
        //������ ������ true ����
        if(numa == numb) return true;
        else return false;
         
         
         
    }
 
     
}