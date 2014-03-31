package com.mmt.handler;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.ErrorHandler;

public class CustomErrorHandler extends ErrorHandler {
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException{
		super.handle(target, baseRequest, request, response);
	}
	@Override
	public void handleErrorPage(HttpServletRequest request, Writer writer, int code, String message) throws IOException{
		writeErrorPage(request, writer, code, message, false);
	}
	@Override
	public void writeErrorPage(HttpServletRequest request, Writer writer, int code, String message, boolean showStacks) throws IOException{
		 if (message == null)
	            message=HttpStatus.getMessage(code);

	        writer.write("<html>\n<head>\n");
	        writeErrorPageHead(request,writer,code,message);
	        writer.write("</head>\n<body>");
	        writeErrorPageBody(request,writer,code,message,showStacks);
	        writer.write("\n</body>\n</html>\n");
	}
	@Override
	public void writeErrorPageHead(HttpServletRequest request, Writer writer, int code, String message) throws IOException{
		 writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
	        writer.write("<title>Error ");
	        writer.write(Integer.toString(code));
	        writer.write(' ');
	        write(writer,message);
	        writer.write("</title>\n");   
	}
	@Override
	public void writeErrorPageBody(HttpServletRequest request, Writer writer, int code, String message, boolean showStacks) throws IOException{
        String uri= request.getRequestURI();
        
        writeErrorPageMessage(request,writer,code,message,uri);
    
        
	}
	@Override
	public void writeErrorPageMessage(HttpServletRequest request, Writer writer, int code, String message, String uri) throws IOException{
        writer.write("<h2>HTTP ERROR ");
        writer.write(Integer.toString(code));

	}
	@Override
	public void writeErrorPageStacks(HttpServletRequest request, Writer writer) throws IOException{
		
	}
}
