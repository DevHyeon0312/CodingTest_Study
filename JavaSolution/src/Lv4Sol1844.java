import java.util.ArrayList;
/** Created By DevHyeon on 2020.11.23
 *  Question Title : 게임 맵 최단거리
 *  Algorithm Type : BFS
 *  Level : 4
 *  Link : https://programmers.co.kr/learn/courses/30/lessons/1844
 * */
public class Lv4Sol1844 {
    /** 실제 동작 solution Code */
    public int solution(int[][] maps)  {
        int answer=0;
        ArrayList<Point> OPEN_LIST = new ArrayList<>();
        //ArrayList<Point> CLOSE_LIST = new ArrayList<>(); //탐색 종료

        if(maps[0][0] == 0) {
            return -1;
        }
        if(maps[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        }

        //시작지점
        OPEN_LIST.add(new Point(0,0,0));
        while(true) {
            Point mPoint = OPEN_LIST.get(0);
            OPEN_LIST.remove(0);
            maps[mPoint.mX][mPoint.mY] = 0;
            addOpen(maps, mPoint,OPEN_LIST);
            //System.out.println(mPoint.toString());
            if(mPoint.mX==maps.length-1 && mPoint.mY==maps[0].length-1) {
                answer = mPoint.mDistance+1;
                break;
            }

            if(OPEN_LIST.size()==0) {
                answer = -1;
                break;
            }
        }
        return answer;
    }



    /** point 객체 */
    class Point {
        int mX;
        int mY;
        int mDistance;
        public Point(int x, int y, int distance) {
            this.mX = x;
            this.mY = y;
            this.mDistance = distance;
        }
        public int getmX() {
            return this.mX;
        }
        public int getmY() {
            return this.mY;
        }
        public int getmDistance() {
            return this.mDistance;
        }

        @Override
        public String toString() {
            return "현재위치:["+this.mX+","+this.mY+"] 이동거리: "+this.mDistance;
        }

        @Override
        public boolean equals(Object object) {
            Point p = (Point) object;
            if(p.mX == mX && p.mY == mY) {
                return true;
            }else {
                return false;
            }
        }
    }

    /** 이동가능 구하기 */
    public boolean isTop(int[][] maps, Point nowPoint, Point nextPoint) {
        //해당 좌표가 가장 위쪽이면, 갈수 없음
        if(nowPoint.mX==0) {
            return false;
        }
        //해당 좌표 위가 벽이 아니면서, 이미 탐색된 곳이 아닌 경우
        else if(maps[nowPoint.mX-1][nowPoint.mY] == 1){
            return true;
        }
        //그 외의 경우는 모두 갈 수 없음.
        else {
            return false;
        }
    }
    public boolean isBottom(int[][] maps, Point nowPoint, Point nextPoint) {
        //해당 좌표가 가장 아래쪽이면, 갈수 없음
        if(nowPoint.mX==maps.length-1) {
            return false;
        }
        //해당 좌표 아래가 벽이 아니면서, 이미 탐색된 곳이 아닌 경우
        else if(maps[nowPoint.mX+1][nowPoint.mY] == 1){
            return true;
        }
        //그 외의 경우는 모두 갈 수 없음.
        else {
            return false;
        }
    }
    public boolean isLeft(int[][] maps, Point nowPoint, Point nextPoint) {
        //해당 좌표가 가장 왼쪽이면, 갈수 없음
        if(nowPoint.mY==0) {
            return false;
        }
        //해당 좌표 왼쪽이 벽이 아니면서, 이미 탐색된 곳이 아닌 경우
        else if(maps[nowPoint.mX][nowPoint.mY-1] == 1){
            return true;
        }
        //그 외의 경우는 모두 갈 수 없음.
        else {
            return false;
        }
    }
    public boolean isRight(int[][] maps, Point nowPoint, Point nextPoint) {
        //해당 좌표가 가장 오른쪽이면, 갈수 없음
        if(nowPoint.mY==maps[0].length-1) {
            return false;
        }
        //해당 좌표 오른쪽이 벽이 아니면서, 이미 탐색된 곳이 아닌 경우
        else if(maps[nowPoint.mX][nowPoint.mY+1] == 1){
            return true;
        }
        //그 외의 경우는 모두 갈 수 없음.
        else {
            return false;
        }
    }

    /** 이동가능리스트 추가 하기 */
    public void addOpen(int[][] maps,Point nowPoint, ArrayList<Point> OPEN_LIST){
        /** Top */
        Point topPoint = new Point(nowPoint.mX-1,nowPoint.mY,nowPoint.mDistance+1);
        if(isTop(maps,nowPoint, topPoint)==true) {
            if(!OPEN_LIST.contains(topPoint)) {
                OPEN_LIST.add(topPoint);
            }
        }
        /** Left */
        Point leftPoint = new Point(nowPoint.mX,nowPoint.mY-1,nowPoint.mDistance+1);
        if(isLeft(maps,nowPoint, leftPoint)==true) {
            if(!OPEN_LIST.contains(leftPoint)) {
                OPEN_LIST.add(leftPoint);
            }
        }
        /** Right */
        Point rightPoint = new Point(nowPoint.mX,nowPoint.mY+1,nowPoint.mDistance+1);
        if(isRight(maps,nowPoint, rightPoint)==true) {
            if(!OPEN_LIST.contains(rightPoint)) {
                OPEN_LIST.add(rightPoint);
            }
        }
        /** Bottom */
        Point bottomPoint = new Point(nowPoint.mX+1,nowPoint.mY,nowPoint.mDistance+1);
        if(isBottom(maps,nowPoint, bottomPoint)==true) {
            if(!OPEN_LIST.contains(bottomPoint)) {
                OPEN_LIST.add(bottomPoint);
            }
        }
    }
}
