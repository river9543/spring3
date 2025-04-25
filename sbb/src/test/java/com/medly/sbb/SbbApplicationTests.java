package com.medly.sbb;

import static org.hamcrest.CoreMatchers.theInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.medly.sbb.answer.Answer;
import com.medly.sbb.answer.AnswerRepository;
import com.medly.sbb.question.Question;
import com.medly.sbb.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	/**
	@Test
	void testJpa() {
		Question q1=new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		
		Question q2=new Question();
		q2.setSubject("스프링 부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
	**/
	
	/**
	@Test
	void testJpa1() {
		List<Question> all=this.questionRepository.findAll();
		assertEquals(2, all.size());
		
		Question q=all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}
	**/
	
	
	
	/**
    @Test
    void testJpa2() {
    	Optional<Question>oq=this.questionRepository.findById(5);
    	if(oq.isPresent()) {
    		Question q=oq.get();
    	    assertEquals("sbb가 무엇인가요?", q.getSubject());	
    	}
    }
    **/
	
	/**
	@Test
	void testJpa3() {
		List<Question> qList=this.questionRepository.findBySubjectLike("sbb%");
		Question q=qList.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		
	}
	**/
	
	/**
	@Test
	void testJpa4() {
		Optional<Question>oq=this.questionRepository.findById(5);
		assertTrue(oq.isPresent());
		Question q=oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}
	**/
	
	/**
	@Test
	void testJpa5() {
	    assertEquals(5, this.questionRepository.count()); // 현재 5개
	    Optional<Question> oq = this.questionRepository.findById(5);
	    assertTrue(oq.isPresent());
	    Question q = oq.get();
	    this.questionRepository.delete(q);
	    assertEquals(4, this.questionRepository.count()); // 삭제 후 4개
	}
	**/
	
	/**
	@Test
	@Transactional
	@Commit
	void testJpa6() {
		Optional<Question>oq=this.questionRepository.findById(5);
		assertTrue(oq.isPresent());
		Question q=oq.get();
		
		Answer a=new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setCreateTime(LocalDateTime.now());
		this.answerRepository.save(a);
		
	}
	 **/
	/**
	@Test
	void testJpa7() {
		Optional<Answer> oa=this.answerRepository.findById(2);
		assertTrue(oa.isPresent());
		Answer a=oa.get();
		assertEquals(5, a.getQuestion().getId());
	}
	**/
	
	@Test
	void testJpa8() {
	    Optional<Question> oq = this.questionRepository.findById(5); // ID를 2에서 5로 변경
	    assertTrue(oq.isPresent());
	    Question q = oq.get();
	    
	    List<Answer> answerList = q.getAnswerList();
	    
	    assertEquals(2, answerList.size()); // 답변 개수를 1에서 2로 변경
	    assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
	
	
	@Test
	void contextLoads() {
	}

}
