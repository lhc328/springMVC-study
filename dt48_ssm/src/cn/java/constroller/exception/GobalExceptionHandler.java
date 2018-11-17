package cn.java.constroller.exception;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice	
public class GobalExceptionHandler {
	private static Logger logger = Logger.getLogger(GobalExceptionHandler.class); 
	
	@ExceptionHandler(Exception.class)
	public String handException(Exception ex) {
		ex.printStackTrace();
//		String errorMessage = ex.getMessage();
//		logger.debug(errorMessage);
//		try {
//			FileOutputStream fos = new FileOutputStream("D://48dt.log",true);
//			PrintStream ps = new PrintStream(fos);
//			Date date = new Date();
//			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String time = sdt.format(date);
//			ps.write(time.getBytes("utf-8"));
//			ps.write("\r\n".getBytes("utf-8"));
//			ex.printStackTrace(ps);
//			//关闭流
//			ps.close();
//			fos.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "error/error.jsp";
	}
}
