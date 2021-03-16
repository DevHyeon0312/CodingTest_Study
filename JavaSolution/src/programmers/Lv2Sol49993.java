package programmers;

public class Lv2Sol49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        System.out.println("==="+skill+"===");

        for(String user_skill : skill_trees) {
            int startSkill = 0; //유저가 사전에 배워야 하는 스킬의 위치
            boolean isUse = true;
            for (int i=0; i<user_skill.length(); i++) {
                int tempSkill = skill.indexOf(user_skill.charAt(i)); //유저가 현재 배우려는 스킬
                //필수 스킬트리가 아니면 가능
                if (tempSkill == -1) {
                    continue;
                }
                //필수 스킬트리면 사전에 배워야하는 스킬과 같거나 작은지 확인
                else {
                    if (tempSkill <= startSkill) {
                        startSkill++;
                    }
                    else {
                        isUse = false;
                        break;
                    }
                }
            }
            if (isUse) {
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
