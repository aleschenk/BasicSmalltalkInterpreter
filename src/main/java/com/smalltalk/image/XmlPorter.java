package com.smalltalk.image;

import com.smalltalk.SmallInterpreter;

public class XmlPorter {

	public static void main(String[] args) throws Exception {
		SmallInterpreter smallInterpreter = new SmallInterpreter();
		
		// smallInterpreter = FileImageBin.read("image");
		
		// FileImageXml.write("image-v2.xml", smallInterpreter);
		
		smallInterpreter = FileImageXml.read("image-v2.xml");
		
		
		
		
	}

}
