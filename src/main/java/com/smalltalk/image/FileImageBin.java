package com.smalltalk.image;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.smalltalk.SmallInterpreter;
import com.smalltalk.objects.SmallInt;
import com.smalltalk.objects.SmallObject;

public class FileImageBin {
	public static SmallInterpreter read(String file) throws Exception {
		SmallInterpreter theInterpreter = new SmallInterpreter();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

		theInterpreter = new SmallInterpreter();
		theInterpreter.nilObject = (SmallObject) ois.readObject();
		theInterpreter.trueObject = (SmallObject) ois.readObject();
		theInterpreter.falseObject = (SmallObject) ois.readObject();
		theInterpreter.smallInts = (SmallInt[]) ois.readObject();
		theInterpreter.ArrayClass = (SmallObject) ois.readObject();
		theInterpreter.BlockClass = (SmallObject) ois.readObject();
		theInterpreter.ContextClass = (SmallObject) ois.readObject();
		theInterpreter.IntegerClass = (SmallObject) ois.readObject();

		ois.close();

		return theInterpreter;
	}

	public static void write(String file, SmallInterpreter smallInterpreter) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(smallInterpreter.nilObject);
		oos.writeObject(smallInterpreter.trueObject);
		oos.writeObject(smallInterpreter.falseObject);
		oos.writeObject(smallInterpreter.smallInts);
		oos.writeObject(smallInterpreter.ArrayClass);
		oos.writeObject(smallInterpreter.BlockClass);
		oos.writeObject(smallInterpreter.ContextClass);
		oos.writeObject(smallInterpreter.IntegerClass);
		oos.close();
	}
}
