package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question {
	private static Map<String, String> questionMap = new LinkedHashMap<>(); //������ ���� ������ Map
	private  List<String> questionList = new ArrayList<>(); //���� Image�� �̸��� ����� List

	public Question() { //��������鿡 ������ ���õ� ������ ����
		
		Question.questionMap.put("Q1.png", "150");
		questionList.add("Q1.png");
		
		Question.questionMap.put("Q2.png", "0");
		questionList.add("Q2.png");
		
		Question.questionMap.put("Q3.png", "1");
		questionList.add("Q3.png");
		
		Question.questionMap.put("Q4.png", "0");
		questionList.add("Q4.png");
		
		Question.questionMap.put("Q5.png", "2");
		questionList.add("Q5.png");
		
		Question.questionMap.put("Q6.png", "0");
		questionList.add("Q6.png");
		
		Question.questionMap.put("Q7.png", "1");
		questionList.add("Q7.png");
		
		Question.questionMap.put("Q8.png", "0");		
		questionList.add("Q8.png");
		
		Question.questionMap.put("Q9.png", "3");
		questionList.add("Q9.png");
		
		Question.questionMap.put("Q10.png", "0");
		questionList.add("Q10.png");
		
		Question.questionMap.put("Q11.png", "1");
		questionList.add("Q11.png");
		
		Question.questionMap.put("Q12.png", "0");
		questionList.add("Q12.png");
		
		Question.questionMap.put("Q13.png", "4");
		questionList.add("Q13.png");
		
		Question.questionMap.put("Q14.png", "0");
		questionList.add("Q14.png");
		
		Question.questionMap.put("Q15.png", "3");
		questionList.add("Q15.png");
		
		Question.questionMap.put("Q16.png", "0");
		questionList.add("Q16.png");
		
		Question.questionMap.put("Q17.png", "2");
		questionList.add("Q17.png");
		
		Question.questionMap.put("Q18.png", "0");		
		questionList.add("Q18.png");
		
		Question.questionMap.put("Q19.png", "2");
		questionList.add("Q19.png");
		
		Question.questionMap.put("Q20.png", "0");
		questionList.add("Q20.png");
		
		Question.questionMap.put("Q21.png", "3");
		questionList.add("Q21.png");
		
		Question.questionMap.put("Q22.png", "0");
		questionList.add("Q22.png");
		
		Question.questionMap.put("Q23.png", "1");
		questionList.add("Q23.png");
		
		Question.questionMap.put("Q24.png", "0");
		questionList.add("Q24.png");
		
		Question.questionMap.put("Q25.png", "4");
		questionList.add("Q25.png");
		
		Question.questionMap.put("Q26.png", "0");
		questionList.add("Q26.png");
		
		Question.questionMap.put("Q27.png", "2");
		questionList.add("Q27.png");
		
		Question.questionMap.put("Q28.png", "0");		
		questionList.add("Q28.png");
		
		Question.questionMap.put("Q29.png", "3");
		questionList.add("Q29.png");
		
		Question.questionMap.put("Q30.png", "0");
		questionList.add("Q30.png");
		
		Question.questionMap.put("Q31.png", "3");
		questionList.add("Q31.png");
		
		Question.questionMap.put("Q32.png", "0");
		questionList.add("Q32.png");
		
		Question.questionMap.put("Q33.png", "3");
		questionList.add("Q33.png");
		
		Question.questionMap.put("Q34.png", "0");
		questionList.add("Q34.png");
		
		Question.questionMap.put("Q35.png", "3");
		questionList.add("Q35.png");
		
		Question.questionMap.put("Q36.png", "0");
		questionList.add("Q36.png");
		
		Question.questionMap.put("Q37.png", "2");
		questionList.add("Q37.png");
		
		Question.questionMap.put("Q38.png", "0");		
		questionList.add("Q38.png");
		
		Question.questionMap.put("Q39.png", "4");
		questionList.add("Q39.png");
		
		Question.questionMap.put("Q40.png", "0");
		questionList.add("Q40.png");
		
		System.out.println(questionMap.toString());
		System.out.println(questionList.toString());
	}
	//��������� getter
	public List<String> getQuestionList() {
		return questionList;
	}
	public static Map<String, String> getQuestionMap() {
		return Question.questionMap;
	}
	
	//���濡�� ���� ����� �Ѱ� �ٶ� "/"�� ��ϵ��� �����ϱ� ����  toString�� ������ �Ͽ���.
	@Override
	public String toString() {
		Set<String> set = questionMap.keySet();
		Iterator<String> iter = set.iterator();
		StringBuffer BufferList = new StringBuffer(); //ThreadSafe�� StringBuffer�� ����Ͽ���.
		while(iter.hasNext()) {
			String key = ((String)iter.next());
			String value = questionMap.get(key);
		
		for(int i=0; i<questionList.size(); i++) {
			
			BufferList.append(questionList.get(i)); //���� �ϳ��� �߰�  //
			System.out.println(questionList.get(i).toString());
			System.out.println();
			if(questionList.size()-1 != i) //i�� �������� �ƴ϶��
				BufferList.append("/"); // "/"�� �߰��Ѵ�.
		}
		
	}
		return BufferList.toString(); 
	}
}




