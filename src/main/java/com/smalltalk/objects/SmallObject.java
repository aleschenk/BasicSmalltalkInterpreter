package com.smalltalk.objects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SmallObject implements Serializable {
	public SmallObject objClass;
	public SmallObject[] data;

	public SmallObject() {
		objClass = null;
		data = null;
	}

	public SmallObject(SmallObject cl, int size) {
		objClass = cl;
		data = new SmallObject[size];
	}

	public SmallObject copy(SmallObject cl) {
		return this;
	}
}
