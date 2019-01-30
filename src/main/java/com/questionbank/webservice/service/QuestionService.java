package com.questionbank.webservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.questionbank.webservice.domain.question.Question;
import com.questionbank.webservice.domain.question.QuestionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    /**
     *  문제목록 조회
     */
    public Question getRandomQuestion(String questionId) {
        List<Question> questions = questionRepository.getQuestionsFromFile(questionId);

        return questions.get(0);
    }
}
