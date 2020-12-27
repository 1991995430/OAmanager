package com.offcn.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializable {
	
	//对象装字节数组
	public static byte[] objectSerializable(Object obj) throws Exception{
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(obj);
		return byteArrayOutputStream.toByteArray();
		
	}
	
	//字节数组转对象
	public static Object deobjectSerializable(byte[] obj) throws Exception{
		if(obj==null || obj.length==0) {
			return null;
		}
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(obj);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		return objectInputStream.readObject();
	}

}
