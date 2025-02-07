package basic.Ch02_array;

public class Array1 {
    public static void main(String[] args) {
        //#1. 주어진 배열의 원소들 중 제시된 규칙과 다른 항목이 몇 건인지
        //맨 앞부터 3개씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 WrongCnt 증가
        //3,2,6 : 3x2=6 통과
        //3,4,4 : 3x4=12 != 4 wrongCnt
        {
            int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
            int wrongCnt = 0;
            for (int i = 0; i < intArray.length-2; i += 3) {
                if(intArray[i] * intArray[i+1] != intArray[i+2]) {
                    wrongCnt++;
                }
            }
            System.out.println(wrongCnt);
        }

        //#2. 양 끝에서 출발해서 안쪽으로 이동하면서 각 대칭 항목이 다른건 몇 건
        {
            char[] charArray = "XYZEBFFGQOVVPWGFFCEAYX".toCharArray();
            int wrongCnt = 0;
            for (int i = 0; i < charArray.length/2; i ++) {
                if(charArray[i] != charArray[charArray.length-1-i]) {
                    wrongCnt++;
                }
            }
            System.out.println(wrongCnt);
        }

        {
            char[] charArray = "XYZEBFFGQOVVPWGFFCEAYX".toCharArray();
            int wrongCnt = 0;
            for (int i = 0, j = charArray.length-1; i < charArray.length/2; i ++, j--) {
                if(charArray[i] != charArray[j]) {
                    wrongCnt++;
                }
            }
            System.out.println(wrongCnt);
        }

        //#3. 문자열에 포함된 알파벳의 빈도수 출력, 0인 항목도 출력
        {
            String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
            //모든 알파벳 소문자가 몇 번 반복되었는지 출력
            for (int i = (int)'a'; i < (int)'z'; i++) {
                int count = 0;
                for (int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == (char)i) {
                        count++;
                    }
                }
                System.out.println((char)i+" : "+count);
            }

        }
    }
}
