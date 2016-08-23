package com.aaa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 将file文件上传到服务器path路径的类
 */
public class UploadPhoto {
	public void upload(File file, String path) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			OutputStream outputStream = new FileOutputStream(path);
			byte buffer[] = new byte[1024];
			int count = 0;
			while ((count = inputStream.read(buffer)) > 0){
				outputStream.write(buffer, 0, count);;
			}
			outputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
