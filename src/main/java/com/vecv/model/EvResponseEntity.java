package com.vecv.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class EvResponseEntity<T> extends ResponseEntity<T> {

	public EvResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(body, headers, status);
	}

	public EvResponseEntity(T body, HttpStatus status) {
		super(body, status);
	}

	public EvResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
		super(headers, status);
	}

	public EvResponseEntity(HttpStatus status) {
		super(status);
	}

}
