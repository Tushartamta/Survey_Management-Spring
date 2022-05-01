package com.example.surveycartel.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.surveycartel.Model.UserSurveyResponse;
import com.example.surveycartel.Service.UserSurveyResponseService;



@RestController
@RequestMapping("/api/userSurveyResponse")
public class UserSurveyResponseController {
	@Autowired
	private UserSurveyResponseService userSurveyResponseService;

	@PostMapping
	public ResponseEntity<UserSurveyResponse> saveLogin(@RequestBody UserSurveyResponse userSurveyResponse) {
		return new ResponseEntity<UserSurveyResponse>(
				userSurveyResponseService.saveUserSurveyResponse(userSurveyResponse), HttpStatus.CREATED);
	}

	@GetMapping("{surveyId}")
	public List<UserSurveyResponse> getAllLogins(@PathVariable("surveyId") Long surveyId) {
		return userSurveyResponseService.getAllUserSurveyResponse(surveyId);
	}

	@GetMapping("/userSurveyResponseid/{userSurveyResponseId}")
	public ResponseEntity<UserSurveyResponse> getLoginByLoginId(
			@PathVariable("userSurveyResponseId") Long userSurveyResponseId) {
		return new ResponseEntity<UserSurveyResponse>(
				userSurveyResponseService.getUserSurveyResponseById(userSurveyResponseId), HttpStatus.OK);
	}

	@PutMapping("{userSurveyResponseId}")
	public ResponseEntity<Integer> updateLogin(@PathVariable("userSurveyResponseId") Long userSurveyResponseId,
			@RequestBody UserSurveyResponse userSurveyResponse) {
		return new ResponseEntity<Integer>(
				userSurveyResponseService.updateUserSurveyResponse(userSurveyResponse, userSurveyResponseId),
				HttpStatus.OK);
	}
	
	@DeleteMapping("{userSurveyResponseId}")
	public ResponseEntity<Boolean> deleteLogin(@PathVariable("userSurveyResponseId") Long userSurveyResponseId){
		return new ResponseEntity<Boolean>(userSurveyResponseService.deleteUserSurveyResponse(userSurveyResponseId),HttpStatus.OK);
		
	}

}
