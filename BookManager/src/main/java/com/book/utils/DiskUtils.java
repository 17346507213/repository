
package com.book.utils;

/** 

* @author 作者: lilei 

* @version 创建时间：2019年3月25日 下午6:36:26 

* 类说明 

*/

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiskUtils {
	private DiskUtils() {
	}

	/**
	 * 获取硬盘编号
	 * 
	 * @param drive
	 * @return
	 */
	public static String getSerialNumber(String drive) {
		String result = "";
		try {
			String a = "";
			File file = File.createTempFile("damn", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);
			String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
					+ "Set colDrives = objFSO.Drives\n" + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
					+ "Wscript.Echo objDrive.SerialNumber"; // see note
			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;

			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.trim();
	}
}
