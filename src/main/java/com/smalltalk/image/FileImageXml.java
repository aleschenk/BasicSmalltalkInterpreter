package com.smalltalk.image;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.smalltalk.SmallInterpreter;
import com.smalltalk.objects.SmallByteArray;
import com.smalltalk.objects.SmallInt;
import com.smalltalk.objects.SmallObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class FileImageXml {

  public static SmallInterpreter read(String filename) throws Exception {
    return (SmallInterpreter) getXStream().fromXML(uncompress(new File(filename)));
    // return (SmallInterpreter) getXStream().fromXML(new FileInputStream(filename));
  }

  public static void writex(String file, SmallInterpreter smallInterpreter) throws Exception {
    // String x = compress(file);
    getXStream().toXML(smallInterpreter, new GZIPOutputStream(new FileOutputStream(new File("image.xml.gz"))));
    // getXStream().toXML(smallInterpreter, new FileOutputStream(file));
  }

  private static XStream getXStream() {
    XStream xstream = new XStream(new DomDriver());
    xstream.alias("SmallInterpreter", SmallInterpreter.class);
    xstream.alias("SmallObject", SmallObject.class);
    xstream.alias("SmallByteArray", SmallByteArray.class);
    xstream.alias("SmallInt", SmallInt.class);
    return xstream;
  }

  public static void compress(File file) {
    GZIPOutputStream gout = null;
    BufferedInputStream bis = null;

    try {
      gout = new GZIPOutputStream(new FileOutputStream(new File("service.txt.gz")));

      bis = new BufferedInputStream(new FileInputStream(file));

      int r;
      while ((r = bis.read()) != -1) {
        gout.write(r);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (gout != null)
        try {
          gout.flush();
          gout.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      if (bis != null)
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

  }

  public static String uncompress(File file) throws Exception {
    GZIPInputStream gin = new GZIPInputStream(new FileInputStream(file));

    byte[] b = new byte[1024];
    int n = 0;
    StringBuilder image = new StringBuilder();
    while (n != -1) {
      n = gin.read();
      if (n > 0)
        image.append((char) n);
    }

    gin.close();

    return image.toString();
  }

}
