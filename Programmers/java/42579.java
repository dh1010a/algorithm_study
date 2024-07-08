import java.util.*;
class Solution {

    class SongDetail implements Comparable<SongDetail> {
        // 노래 인덱스
        public int i;
        // 노래 재생횟수
        public int plays;
        
        public SongDetail(int i, int plays) {
            this.i = i;
            this.plays = plays;
        }
        
        // 비교연산자
        @Override
        public int compareTo(SongDetail other) {
            if (other.plays == this.plays) {
                return Integer.compare(this.plays, other.plays);
            }
            return Integer.compare(other.plays, this.plays);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 순위를 계산할 Map
        Map<String, Integer> rank = new HashMap<>();
        // 장르별 노래 정보를 담아놓을 Map
        Map<String, List<SongDetail>> song = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            // 장르별 누적 재생횟수 계산
            rank.put(genres[i], rank.getOrDefault(genres[i], 0) + plays[i]);

            // 장르별 songDetail객체 추가
            List<SongDetail> tmp = song.getOrDefault(genres[i], new ArrayList<>());
            tmp.add(new SongDetail(i, plays[i]));
            song.put(genres[i], tmp);
        }
        
        //장르별 순위를 계산
        List<String> keySet = new ArrayList<>(rank.keySet());
        keySet.sort((o1, o2) -> rank.get(o2).compareTo(rank.get(o1)));
        

        List<Integer> answer = new ArrayList<>();
        // 장르별 곡 정보 객체를 정렬하고, answer에 추가
        for (String x: keySet) {
            List<SongDetail> tmp = song.get(x);
            Collections.sort(tmp);
            answer.add(tmp.get(0).i);
            if (tmp.size() >= 2) {
                answer.add(tmp.get(1).i);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }

}