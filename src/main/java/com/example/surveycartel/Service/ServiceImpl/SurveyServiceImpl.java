package com.example.surveycartel.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.surveycartel.Model.Survey;
import com.example.surveycartel.Repository.SurveyRepository;
import com.example.surveycartel.Service.SurveyService;


@Service
public class SurveyServiceImpl implements SurveyService {
	@Autowired
	SurveyRepository surveyRepository;

	@Override
	public Survey saveSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}

	@Override
	public List<Survey> getAllSurvey() {
		return surveyRepository.findAll();
	}
	// Bydate(getallsurverByDate)

	@Override
	public Survey getSurveyById(Long surveyId) {
		return surveyRepository.getById(surveyId);
	}

	// Create a update survey status method
	@Override
	public Integer updateSurvey(Survey survey, Long surveyId) {
		return surveyRepository.setSurveyInfoById(survey.getSurveyTitle(), survey.getSurveyDate(),
				survey.getSurveyDescription(), survey.getExpireStatus(), surveyId);
	}

	@Override
	public Boolean deleteSurvey(Long surveyId) {
		try {
			surveyRepository.deleteById(surveyId);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
}
