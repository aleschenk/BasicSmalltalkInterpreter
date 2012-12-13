package com.smalltalk.objects;

@SuppressWarnings("serial")
public class SmallException extends Exception {
	public SmallException(String gripe, SmallObject c) {
		super(gripe);
		context = c;
	}

	public SmallObject context;
}
