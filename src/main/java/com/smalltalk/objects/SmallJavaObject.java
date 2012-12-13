package com.smalltalk.objects;

@SuppressWarnings("serial")
public class SmallJavaObject extends SmallObject {
	public SmallJavaObject(SmallObject cls, Object v) {
		super(cls, 0);
		value = v;
	}

	public Object value;
}