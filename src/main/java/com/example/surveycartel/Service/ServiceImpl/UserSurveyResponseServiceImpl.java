package com.example.surveycartel.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.surveycartel.Model.SurveyQuestion;
import com.example.surveycartel.Model.UserSurveyResponse;
import com.example.surveycartel.Repository.UserSurveyResponseRepository;
import com.example.surveycartel.Service.SurveyQuestionService;
import com.example.surveycartel.Service.UserSurveyResponseService;

@Service
public class UserSurveyResponseServiceImpl implements UserSurveyResponseService {
	@Autowired
	UserSurveyResponseRepository userSurveyResponseRepository;
	@Autowired
	SurveyQuestionService surveyQuestionService;

	@Override
	public UserSurveyResponse saveUserSurveyResponse(UserSurveyResponse userSurveyResponse) {

		return userSurveyResponseRepository.save(userSurveyResponse);
	}

	@Override
	public List<UserSurveyResponse> getAllUserSurveyResponse(Long surveyId) {

		// getting SurveyQuestion objects ofspecific surveyId
		List<SurveyQuestion> surveyQuestionList = surveyQuestionService.getAllSurveyQuestion(surveyId);
		List<UserSurveyResponse> userSurveyResponseList = userSurveyResponseRepository.findAll();

		List<UserSurveyResponse> filteredUserSurveyResponse = new ArrayList<UserSurveyResponse>();
		// going through each element in the first list,
		for (SurveyQuestion surveyQuestion : surveyQuestionList) {

			// going through each element in the second list,
			for (UserSurveyResponse userSurveyResponse : userSurveyResponseList) {
				// and collecting the first list's element if it matches the second list's
				// element.
				if (surveyQuestion.getQuestionId().equals(userSurveyResponse.getQuestionId())) {
					filteredUserSurveyResponse.add(userSurveyResponse);
				}
			}
		}
		System.out.println(filteredUserSurveyResponse);
		return filteredUserSurveyResponse;
	}

	@Override
	public UserSurveyResponse getUserSurveyResponseById(Long userSurveyResponseId) {
		return userSurveyResponseRepository.getById(userSurveyResponseId);
	}

	@Override
	public Integer updateUserSurveyResponse(UserSurveyResponse userSurveyResponse, Long userSurveyResponseId) {
		return userSurveyResponseRepository.setUserSurveyResponseInfoById(userSurveyResponse.getSurveyResponse(),
				userSurveyResponseId);

	}

	@Override
	public Boolean deleteUserSurveyResponse(Long userSurveyResponseId) {
		try {
			userSurveyResponseRepository.deleteById(userSurveyResponseId);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}

