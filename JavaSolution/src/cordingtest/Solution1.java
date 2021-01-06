package cordingtest;

import java.util.*;

public class Solution1 {
    public String[] solution(String[] record) {
        //key , record[] HashMap
        HashMap<String, String[]> map = new HashMap<>();

        //완주자 인원
        int[] endCount = new int[5];

        //레코드 재생성 및 map 에 put
        for (String s : record) {
            String[] split = s.split(":");
            String name = split[0];
            String temp = split[1];
            String score[] = temp.split(",");

            String[] records = new String[12];

            //이름
            records[0] = name;

            //default value (null 방지)
            records[6] = "0"; //완주 개수
            records[7] = "0"; //가장 높은 완주 난이도
            records[8] = "0"; //금 개수
            records[9] = "0"; //은 개수
            records[10] = "0"; //동 개수
            records[11] = "0"; //전체코스 완주시간 합

            for (int cos = 0; cos<5; cos++) {
                //각 코스의 기록
                records[cos+1] = score[cos];

                //기록이 있는 경우
                if (!score[cos].equals("0")) {
                    records[6] = Integer.parseInt(records[6]) + 1 + ""; //완주 개수 ++
                    records[7] = (cos+1)+"";  //완주 난이도 Update
                    records[11] = Integer.parseInt(records[11]) + Integer.parseInt(score[cos]) + "";  //완주 시간 ++
                    endCount[cos]++;
                }
            }

            //재생성한 record[] 를 맵에 put
            map.put(name,records);
        }

        //만들어진 map 을 이용하여 금,은,동 메달 부여
        for (int cos = 1; cos < 6; cos ++) {
            //코스별 메달 개수 ( 완주자인원 * 할당비율 )
            Map<String, String[]> RankMap = sortMapByCosRank(map,cos);
            int gold_rank = (int)Math.ceil(endCount[cos-1] * (0.0833333));
            int silver_rank = (int)Math.ceil(endCount[cos-1] * (0.25));
            int bronze_rank = (int)Math.ceil(endCount[cos-1] * (0.5));

            int rank = 0;
            for (int index = 0; index < record.length; index++) {
                Object name = (String) RankMap.keySet().toArray()[index];
                if (Integer.parseInt(RankMap.get(name)[cos]) != 0 && rank < gold_rank) {
                    RankMap.get(name)[8] = Integer.parseInt(RankMap.get(name)[8]) + 1 + "";
                    rank++;
                } else if (Integer.parseInt(RankMap.get(name)[cos]) != 0 && rank < silver_rank) {
                    RankMap.get(name)[9] = Integer.parseInt(RankMap.get(name)[9]) + 1 + "";
                    rank++;
                } else if (Integer.parseInt(RankMap.get(name)[cos]) != 0 && rank < bronze_rank) {
                    RankMap.get(name)[10] = Integer.parseInt(RankMap.get(name)[10]) + 1 + "";
                    rank++;
                }
            }
        }

        //메달 부여가 완료된 맵을 이용하여 정렬
        Map<String, String[]> sortedMap = sortMapByValueCondition(map);

        //정렬이 종료된 맵을 이용하여 result[] 부여
        String[] result = new String[record.length];
        for (int rank = 0; rank < record.length; rank++) {
            Object key = (String) sortedMap.keySet().toArray()[rank];
            result[rank] = sortedMap.get(key)[0];
        }


        //Print Test
        Print(sortedMap);

        return result;
    }

    /**
     * 출력 테스트
     * */
    public void Print(Map<String, String[]> map) {
        System.out.printf("%6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s %6s","선수명","1코스기록","2코스기록","3코스기록","4코스기록","5코스기록","완주개수","완주난이도", "금개수","은개수","동개수","완주시간합");
        System.out.println(" ");

        map.forEach((name, value) -> {
            for (String s : value) {
                System.out.printf("%8s",s);
            }
            System.out.println(" ");
        });
    }


    /**
     * 금,은,동을 부여하기 위하여 입력받은 cos 의 기록순 정렬
     * */
    public LinkedHashMap<String, String[]> sortMapByCosRank(Map<String, String[]> map, int cos) {
        List<Map.Entry<String, String[]>> entries = new LinkedList<>(map.entrySet());
        //기록순 정렬
        entries.sort(new Comparator<Map.Entry<String, String[]>>() {
            @Override
            public int compare(Map.Entry<String, String[]> o1, Map.Entry<String, String[]> o2) {
                //완주 개수 정렬
                int comparison = (Integer.parseInt(o1.getValue()[cos]) - Integer.parseInt(o2.getValue()[cos]));
                return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
            }
        });

        LinkedHashMap<String, String[]> result = new LinkedHashMap<>();
        for (Map.Entry<String, String[]> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * 요구조건에 맞도록 다중 조건 정렬
     * */
    public LinkedHashMap<String, String[]> sortMapByValueCondition(Map<String, String[]> map) {
        List<Map.Entry<String, String[]>> entries = new LinkedList<>(map.entrySet());

        //정렬 조건
        entries.sort(new Comparator<Map.Entry<String, String[]>>() {
            @Override
            public int compare(Map.Entry<String, String[]> o1, Map.Entry<String, String[]> o2) {

                //완주 개수 정렬
                int comparision = (Integer.parseInt(o1.getValue()[6]) - Integer.parseInt(o2.getValue()[6])) * -1;

                //완주 난이도 정렬
                if ((Integer.parseInt(o1.getValue()[6]) == Integer.parseInt(o2.getValue()[6]))) {
                    comparision = (Integer.parseInt(o1.getValue()[7]) - Integer.parseInt(o2.getValue()[7])) * -1;

                    //금메달 개수순
                    if ((Integer.parseInt(o1.getValue()[7]) == Integer.parseInt(o2.getValue()[7]))) {
                        comparision = (Integer.parseInt(o1.getValue()[8]) - Integer.parseInt(o2.getValue()[8])) * -1;

                        //은메달 개수순
                        if ((Integer.parseInt(o1.getValue()[8]) == Integer.parseInt(o2.getValue()[8]))) {
                            comparision = (Integer.parseInt(o1.getValue()[9]) - Integer.parseInt(o2.getValue()[9])) * -1;

                            //동메달 개수순
                            if ((Integer.parseInt(o1.getValue()[9]) == Integer.parseInt(o2.getValue()[9]))) {
                                comparision = (Integer.parseInt(o1.getValue()[10]) - Integer.parseInt(o2.getValue()[10])) * -1;

                                //완주 시간 합
                                if ((Integer.parseInt(o1.getValue()[10]) == Integer.parseInt(o2.getValue()[10]))) {
                                    comparision = (Integer.parseInt(o1.getValue()[11]) - Integer.parseInt(o2.getValue()[11]));

                                    //이름 사전순
                                    if ((Integer.parseInt(o1.getValue()[11]) == Integer.parseInt(o2.getValue()[11]))) {
                                        int compare = o1.getValue()[0].compareTo(o1.getValue()[1]);
                                        if (compare < 0){
                                            comparision = 1;
                                        }
                                        else if (compare > 0) {
                                            comparision = 0;
                                        }
                                        else {
                                            comparision = -1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        LinkedHashMap<String, String[]> result = new LinkedHashMap<>();
        for (Map.Entry<String, String[]> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
