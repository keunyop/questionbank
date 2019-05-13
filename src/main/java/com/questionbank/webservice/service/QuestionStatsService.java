package com.questionbank.webservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionbank.webservice.domain.question.QuestionStats;
import com.questionbank.webservice.domain.question.QuestionStatsRepository;
import com.questionbank.webservice.dto.question.QuestionStatsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuestionStatsService {
    private QuestionStatsRepository questionStatsRepository;

    @Transactional
    public void updateQuestionStats(QuestionStatsSaveRequestDto dto) {
        int correct = 0;
        int inCorrect = 0;

        // 문제 통계 조회
        QuestionStats questionStats = questionStatsRepository.findOne(dto.getQuestId());

        if (questionStats != null) {
            correct = questionStats.getCorrect();
            inCorrect = questionStats.getInCorrect();
        }

        if (dto.isCorrect()) {
            correct++;
        } else {
            inCorrect++;
        }

        questionStatsRepository.save(dto.toEntity(correct, inCorrect));
    }
}