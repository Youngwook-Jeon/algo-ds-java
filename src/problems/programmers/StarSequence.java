package problems.programmers;

class StarSequence {

    public int solution(int[] a) {
        int answer = -1;
        int[] count = new int[a.length + 1]; // a 수열에서 등장한 수의 횟수를 저장
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            else if (count[i] <= answer) continue;
            int localResult = 0;

            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] != i && a[j + 1] != i) continue;
                else if (a[j] == a[j + 1]) continue;
                localResult++;
                j++; //j, j+1 위치의 스타수열의 한 페어여부를 확인했기에, 두 위치를 건너간다
            }
            answer = Math.max(answer, localResult);
        }

        return answer * 2;
    }
}
