class pgs250135 {

	double h_d;
	double m_d;
	double s_d;

	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int answer = 0;

		int start = 3600 * h1 + 60 * m1 + s1;
		int end = 3600 * h2 + 60 * m2 + s2;
		calculateDegree(h1, m1, s1);
		if(Double.compare(h_d, m_d) == 0 || Double.compare(m_d,s_d) == 0) answer++;

		while (start < end) {
			start++;
			answer += getAlarmCount();
		}

		calculateDegree(h2,m2,s2);
		if(Double.compare(h_d, m_d) == 0 || Double.compare(m_d,s_d) == 0) answer++;


		return answer;
	}

	public void calculateDegree(int h1, int m1, int s1) {
		h_d = (h1 % 12) * 30 + m1 * 0.5 + s1 * (0.5 / 60.0);
		m_d = m1 * 6 + s1 * 0.1;
		s_d = s1 * 6;
	}

	public int getAlarmCount() {
		int answer = 0;

		double prev_h_d = h_d;
		double prev_m_d = m_d;
		double prev_s_d = s_d;

		h_d += 30.0 / 3600.0;
		m_d += 6.0 / 60.0;
		s_d += 6;


		if (Double.compare(prev_h_d, prev_s_d) > 0 &&  Double.compare(h_d, s_d) <= 0) {
			answer++;
		}
		if (Double.compare(prev_m_d, prev_s_d) > 0 && Double.compare(m_d, s_d) <= 0) {
			answer++;
		}

		if (Double.compare(prev_h_d , prev_m_d) > 0 && Double.compare(prev_h_d , prev_s_d) > 0 &&
				Double.compare(h_d , m_d) <= 0 && Double.compare(h_d , s_d) <= 0){
			answer--;
		}

		h_d %= 360.0;
		m_d %= 360.0;
		s_d %= 360.0;

		return answer;

	}
}