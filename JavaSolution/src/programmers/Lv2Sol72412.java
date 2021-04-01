package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Lv2Sol72412 {
    /** O(N) + O(NlogN) + O(NlogN)  */
    public static void main(String[] args) throws IOException {
        String[] info = {"java backend junior pizza 150"};//, "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));

    }

    static public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        /**
         * java(0), python(1), cpp(2), -(3)
         * backend(0), frontend(1), -(2)
         * junior(0), senior(1), -(2)
         * chicken(0), pizza(1), -(2)
         * score
         * */

        /** input : O(N) */
        LANGUAGE language = new LANGUAGE();
        for (int i = 0; i < info.length; i++) {
            String[] user = info[i].split(" ");
            int lan     = user[0].equals("java")    ? 0 : user[0].equals("python") ? 1 : 2;
            int branch  = user[1].equals("backend") ? 0 : 1;
            int career  = user[2].equals("junior")  ? 0 : 1;
            int food    = user[3].equals("chicken") ? 0 : 1;
            language.addBranch(lan,branch,career,food,Integer.parseInt(user[4]));
        }

        /** input2 : O(4*3*3*3*NlogN) */
        for (int i=0; i<4;i++) {
            for (int j=0;j<3;j++) {
                for (int k=0; k<3; k++) {
                    for (int p=0; p<3;p++) {
                        language.getBranch(i).getCareer(j).getFood(k).getSCORE(p).scores.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                if(o1 > o2) {
                                    return 1;
                                } else if(o1 < o2) {
                                    return -1;
                                } else {
                                    return 0;
                                }
                            }
                        });
                    }
                }
            }
        }

        int i=0;
        /** output : O(NlogN) */
        //쿼리
        /** O(N) */
        for (String q : query) {
            String[] qu = q.split(" ");
            int lan     = qu[0].equals("java")      ? 0 : qu[0].equals("python")    ? 1 : qu[0].equals("cpp") ? 2 : 3;
            int branch  = qu[2].equals("backend")   ? 0 : qu[2].equals("frontend")  ? 1 : 2;
            int career  = qu[4].equals("junior")    ? 0 : qu[4].equals("senior")    ? 1 : 2;
            int food    = qu[6].equals("chicken")   ? 0 : qu[6].equals("pizza")     ? 1 : 2;
            /** O(logN) */
            answer[i] = language.getBranch(lan).getCareer(branch).getFood(career).getSCORE(food).getCount(Integer.parseInt(qu[7]));
            i++;
        }
        return answer;
    }

    //언어
    static class LANGUAGE {
        /**
         * java(0), python(1), cpp(2), -(3)
         * backend(0), frontend(1), -(2)
         * junior(0), senior(1), -(2)
         * chicken(0), pizza(1), -(2)
         * score
         * */
        //Java
        BRANCH java = new BRANCH();
        //Python
        BRANCH python = new BRANCH();
        //Cpp
        BRANCH cpp = new BRANCH();
        //All
        BRANCH all = new BRANCH();
        public void addBranch(int language,int branch, int career, int food , int score) {
            switch (language) {
                case 0:
                    java.addCareer(branch, career, food, score);
                    all.addCareer(branch, career, food, score);
                    break;
                case 1:
                    python.addCareer(branch, career, food, score);
                    all.addCareer(branch, career, food, score);
                    break;
                case 2:
                    cpp.addCareer(branch, career, food, score);
                    all.addCareer(branch, career, food, score);
                    break;
            }
        }
        public BRANCH getBranch(int language) {
            switch (language) {
                case 0:
                    return java;
                case 1:
                    return python;
                case 2:
                    return cpp;
                default:
                    return all;
            }
        }
    }
    //분야
    static class BRANCH {
        /**
         * java(0), python(1), cpp(2), -(3)
         * backend(0), frontend(1), -(2)
         * junior(0), senior(1), -(2)
         * chicken(0), pizza(1), -(2)
         * score
         * */
        //Backend
        CAREER backEnd = new CAREER();
        //FrontEnd
        CAREER frontEnd = new CAREER();
        //All
        CAREER all = new CAREER();
        public void addCareer(int branch, int career, int food , int score) {
            switch (branch) {
                case 0:
                    backEnd.addFood(career,food,score);
                    all.addFood(career,food,score);
                    break;
                case 1:
                    frontEnd.addFood(career,food,score);
                    all.addFood(career,food,score);
                    break;
            }
        }
        public CAREER getCareer(int branch) {
            switch (branch) {
                case 0:
                    return backEnd;
                case 1:
                    return frontEnd;
                default:
                    return all;
            }
        }
    }
    //경력
    static class CAREER {
        /**
         * java(0), python(1), cpp(2), -(3)
         * backend(0), frontend(1), -(2)
         * junior(0), senior(1), -(2)
         * chicken(0), pizza(1), -(2)
         * score
         * */
        //junior
        FOOD junior = new FOOD();
        //Senior
        FOOD senior = new FOOD();
        //All
        FOOD all = new FOOD();

        public void addFood(int career, int food, int score) {
            switch (career) {
                case 0:
                    junior.addScore(food, score);
                    all.addScore(food,score);
                    break;
                case 1:
                    senior.addScore(food, score);
                    all.addScore(food,score);
                    break;
            }
        }

        public FOOD getFood(int career) {
            switch (career) {
                case 0:
                    return junior;
                case 1:
                    return senior;
                default:
                    return all;
            }
        }
    }
    //음식
    static class FOOD {
        /**
         * java(0), python(1), cpp(2), -(3)
         * backend(0), frontend(1), -(2)
         * junior(0), senior(1), -(2)
         * chicken(0), pizza(1), -(2)
         * score
         * */
        //chicken SCORE
        SCORE chicken = new SCORE();
        //pizza SCORE
        SCORE pizza = new SCORE();
        //all SCORE
        SCORE all = new SCORE();
        public void addScore(int food, int score) {
            System.out.println("ADD 호출됨");
            switch (food) {
                case 0:
                    chicken.getScores().add(score);
                    all.getScores().add(score);
                    break;
                case 1:
                    pizza.getScores().add(score);
                    all.getScores().add(score);
                    break;
            }
        }
        public SCORE getSCORE(int food) {
            switch (food) {
                case 0:
                    return chicken;
                case 1:
                    return pizza;
                default:
                    return all;
            }
        }
    }
    static class SCORE {
        //점수
        ArrayList<Integer> scores = new ArrayList<>();

        public ArrayList<Integer> getScores() {
            return scores;
        }

        /** O(logN) */
        public int getCount(int min) {
            return scores.size() - LowerBound(scores,min);
        }
    }

    /** O(logN) */
    public static int LowerBound(ArrayList<Integer> array, int target) {
        int low = 0;
        int high = array.size();
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (target <= array.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}