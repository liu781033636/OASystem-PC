package com.common.bean;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

/**
 * @author Chen_Luqiang
 *
 */
public class FileUpload {
	
	/**
	 * 
	 *
	 * 
	 *1. 在jsp页面的上传图片的form里加上 enctype="multipart/form-data" 
	 * 
	 * 例如：<form action="security/user/user_add" method="post"   enctype="multipart/form-data" >
	 *   	<input type="file" name="uploadFile" size="50">
	 *   	</form>
	 *2.  若上传文件的<input> 的name是"uploadFile"
	 *   
	 *   在action中定义	private File uploadFile;
						private String uploadFileFileName;
						private String uploadFileContentType;
		并加上get和set方法
		
		将这三个参数传入该方法，若文件上传成功 则返回的是这个文件上传后的路径。若没有文件上传，则返回值是null;
	 *   
	 * 3.  使用此方法前请先判断好有选定文件，并用try catch包围该方法
	 * 例如：
	 * try
	 * {
	 * path=FileUpload.upload(uploadFile,uploadFileFileName,uploadFileContentType)
	 * }
	 * catch(Exception e)
	 * {
	 * 	return "upload error";
	 * }
	 *   
	 * @param uploadFile
	 * @param uploadFileFileName
	 * @param uploadFileContentType
	 * @return 文件存储路径
	 */
	public static String upload(File uploadFile,String uploadFileFileName,String uploadFileContentType) throws Exception
	{
		System.out.println("fileType"+uploadFileContentType);
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy/MM/dd");

		String logopath = "upload/" + simpledateformat.format(new Date());
		String path = ServletActionContext.getServletContext().getRealPath(
				logopath);
		File file = new File(path + "/" + uploadFileFileName);
		System.out.println(file);
		BufferedInputStream bis = null;//获取一个上传文件的输入流 
		BufferedOutputStream bos = null;//获取一个上传文件的输出流
		try {

			
			file.getParentFile().mkdirs();
		if(uploadFileContentType.equals("text/plain")){

			
		//bis = new BufferedInputStream(new FileInputStream(uploadFile));
		//bos = new BufferedOutputStream(new FileOutputStream(file));
		InputStreamReader isr = new InputStreamReader(new FileInputStream(uploadFile));
		BufferedReader reader = new BufferedReader (isr);
		
		OutputStreamWriter osr =new OutputStreamWriter(new FileOutputStream(file),"UTF-8" );
		BufferedWriter writer=new BufferedWriter(osr);

//		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(bos,"UTF-8"));
//		byte buf[] = new byte[(int) uploadFile.length()];
		int length = 0;
//		while ((length = bis.read(buf)) != -1) {
//			bos.write(buf, 0, length);
//			
//		}
		
		char chr[] =new char[(int) uploadFile.length()];
		while ((length = reader.read(chr)) != -1) {
			writer.write(chr, 0, length);
			
		}
		writer.flush();
		writer.close();
		}
		else{
			byte buf[] = new byte[(int) uploadFile.length()];

			bis = new BufferedInputStream(new FileInputStream(uploadFile));
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			int length = 0;
			while ((length = bis.read(buf)) != -1) {
			bos.write(buf, 0, length);
			
		}
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (bis != null) {
				bis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (bos != null) {
				bos.flush();
				bos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	if(uploadFile!=null)
	{
	return logopath + "/" + uploadFileFileName;
	}
	else
	{
		return null;
	}
	
	}

	
    /**
     * 读取文本文件 . 
     * @throws UnsupportedEncodingException 
     * 
     */ 

    
    public static String readTxtFile(String path) throws UnsupportedEncodingException{ 
        String read; 
        FileReader fileread; 
        
    	BufferedReader bufread; 
    	
        //String path = "D:/suncity.txt"; 
        File filename = new File(path); 
        String readStr =""; 
        
        try { 
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), "UTF-8");
            fileread = new FileReader(filename); 
            bufread = new BufferedReader(isr); 
            try { 
                while ((read = bufread.readLine()) != null) { 
                    readStr = readStr + read+ "\r\n"; 
                } 
            } catch (IOException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
            } 
        } catch (FileNotFoundException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 

        //System.out.println("文件内容是 :"+ "\r\n" + readStr); 
        return readStr; 
    } 

    
    public static void writeTxtFile(String readStr,String path) throws IOException{ 
        //先读取原有文件内容，然后进行写入操作 
//        String filein = readStr; 
//        RandomAccessFile mm = null; 
//        File filename = new File(path); 
//        try { 
//            mm = new RandomAccessFile(filename, "rw"); 
//            //rf = new RandomAccessFile(fileName, "rw");
//            mm.seek(mm.length());
////            mm.write(filein.getBytes());
//            mm.write(new String("我哈哈哈").getBytes());
//            //mm.writeBytes(new String(filein.getBytes("UTF-8"))); 
//        } catch (IOException e1) { 
//            // TODO 自动生成  catch  块 
//            e1.printStackTrace(); 
//        } finally { 
//            if (mm != null) { 
//                try { 
//                    mm.close(); 
//                } catch (IOException e2) { 
//                    // TODO 自动生成  catch  块 
//                    e2.printStackTrace(); 
//                } 
//            } 
//        } 

        //通过上面的分析，我建议如果使用RandomAccessFile来写入中文的话，最好用 RandomAccessFile.write(String.getBytes())的方式，如果为了保险起见，还可以进一步指定运行平台的默认 nativecode编码方式，例如使用：RandomAccessFile.write(String.getBytes("gb2312"))


        FileWriter fw = new FileWriter(path); 
        //String s = "hello world"; 
        fw.write(readStr,0,readStr.length()); 
        fw.flush(); 

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path),"UTF-8"); 
        osw.write(readStr,0,readStr.length()); 
        osw.flush(); 

//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:/Test2.txt")),true); 
//        pw.println(s); 

        fw.close(); 
        osw.close(); 
//        pw.close(); 

        
//        File file = new File(path);
//        if(file.exists())file.delete();
//        file.createNewFile();
//       BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
//		char cont[] =new char[(int) uploadFile.length()]; 
//       br.write(cont[i]);
//        br.newLine();
//        br.flush();
//        br.close();
    } 
    
}
