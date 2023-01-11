package com.soap.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;
import com.soap.services.StudentRepository;

@Endpoint
public class StudentEndpoint {

	private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";

	private StudentRepository StudentRepository;

	@Autowired
	public StudentEndpoint(StudentRepository StudentRepository) {
		this.StudentRepository = StudentRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")

	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
		System.err.println(request.getName());
		StudentDetailsResponse response = new StudentDetailsResponse();

		response.setStudent(StudentRepository.findStudent(request.getName()));
		System.err.println(request.getName());

		return response;
	}

}