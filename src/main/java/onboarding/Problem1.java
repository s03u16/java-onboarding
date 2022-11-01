package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수

        int p_l = pobi.get(0);
        int p_r = pobi.get(1);
        int c_l = crong.get(0);
        int c_r = crong.get(1);


        // 예외) 오른쪽 - 왼쪽 = 1 아닌 경우 & 왼쪽이 짝수인 경우 or 오른쪽이 홀수인 경우
        if (p_r-p_l !=1 || c_r-c_l != 1 || c_l%2==0 || p_l%2==0) {
            answer = -1;
        }

        else {
            // pobi

            List<Integer> p_l_list = new ArrayList<Integer>();
            List<Integer> p_r_list = new ArrayList<Integer>();
            while (p_l != 0) {
                p_l_list.add(p_l % 10);
                p_l /= 10;
            }
            while (p_r != 0) {
                p_r_list.add(p_r % 10);
                p_r /= 10;
            }
            int p_l_sum = 0;
            for (int p : p_l_list) {
                p_l_sum = p_l_sum + p;
            }
            int p_l_mul = 1;
            for (int p : p_l_list) {
                p_l_mul = p_l_mul * p;
            }
            int p_r_sum = 0;
            for (int p : p_l_list) {
                p_r_sum = p_r_sum + p;
            }
            int p_r_mul = 1;
            for (int p : p_l_list) {
                p_r_mul = p_r_mul * p;
            }

            int max_p_l = Math.max(p_l_sum, p_l_mul);
            int max_p_r = Math.max(p_r_sum, p_r_mul);
            int max_p = Math.max(max_p_l, max_p_r);


            // crong

            List<Integer> c_l_list = new ArrayList<Integer>();
            List<Integer> c_r_list = new ArrayList<Integer>();
            while (c_l != 0) {
                c_l_list.add(c_l % 10);
                c_l /= 10;
            }
            while (c_r != 0) {
                c_r_list.add(c_r % 10);
                c_r /= 10;
            }
            int c_l_sum = 0;
            for (int c : c_l_list) {
                c_l_sum = c_l_sum + c;
            }
            int c_l_mul = 1;
            for (int c : c_l_list) {
                c_l_mul = c_l_mul * c;
            }
            int c_r_sum = 0;
            for (int c : c_l_list) {
                c_r_sum = c_r_sum + c;
            }
            int c_r_mul = 1;
            for (int c : c_l_list) {
                c_r_mul = c_r_mul * c;
            }


            int max_c_l = Math.max(c_l_sum, c_l_mul);
            int max_c_r = Math.max(c_r_sum, c_r_mul);
            int max_c = Math.max(max_c_l, max_c_r);

            if (max_p > max_c) {
                answer = 1;
            }
            else if (max_p < max_c) {
                answer = 2;
            }
            else {
                answer = 0;
            }


        }
        return answer;
    }
}