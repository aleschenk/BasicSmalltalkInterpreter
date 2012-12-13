package com.smalltalk.objects;

@SuppressWarnings("serial")
public class SmallInt extends SmallObject {
	public int value;

	public SmallInt(SmallObject IntegerClass, int v) {
		super(IntegerClass, 0);
		value = v;
	}

	public String toString() {
		return "SmallInt: " + value;
	}
}
