//package com.mysite.sbb;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//import java.util.Optional;
//
//import com.mysite.sbb.question.Question;
//import com.mysite.sbb.question.QuestionRespository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//class SbbApplicationTests {
//
//	@Autowired
//	private QuestionRespository questionRepository;
//
//
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//	}
//}