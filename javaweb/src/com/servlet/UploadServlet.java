package com.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	 
	private static final long serialVersionUID = -5036264969905378310L;
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
 
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
 
		// ���ý��յı����ʽ
		request.setCharacterEncoding("UTF-8");
	/*	Date date = new Date();// ��ȡ��ǰʱ��
		SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfFolderName = new SimpleDateFormat("yyyyMMdd");
		
		String newfileName = sdfFileName.format(date);// ����ļ�����
		String newFolderName = sdfFolderName.format(date);  //����ļ�����
*/		
		String fileRealPath = "";// �ļ������ʵ��ַ
		String fileRealResistPath = "";// �ļ������ʵ���·��
		HttpSession session = request.getSession(); 
		String name = (String)session.getAttribute("username"); 
		// ����������ϴ��ļ������ڵ�����·��
		String savePath = this.getServletConfig().getServletContext().getRealPath("/")  + "uploads/" +name+"/";
		System.out.println("�ϴ��ļ����·��" + savePath + "; ");
		File file = new File(savePath);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
 
		try {
			// ���� ������� ���� ��request ����һ��..��������
			String firstFileName = "";
			
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setHeaderEncoding("UTF-8");
			// ��ȡ����ϴ��ļ�
			List fileList = upload.parseRequest(request);
			// �����ϴ��ļ�д�����
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				Object obit = it.next();
				if (obit instanceof DiskFileItem) {
					DiskFileItem item = (DiskFileItem) obit;
 
					// ���item���ļ��ϴ�����
					// ����ļ�����·��
					String fileName = item.getName();
					System.out.println(fileName);
					if (fileName != null) {
						firstFileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);  //�ϴ���Դ�ļ���
						String formatName = firstFileName.substring(firstFileName.lastIndexOf("."));// ��ȡ�ļ���׺��
						fileRealPath = savePath + fileName;// �ļ������ʵ��ַ
 
						BufferedInputStream in = new BufferedInputStream(item.getInputStream());// ����ļ�������
						BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(new File(fileRealPath)));// ����ļ������
						Streams.copy(in, outStream, true);// ��ʼ���ļ�д����ָ�����ϴ��ļ���
						// �ϴ��ɹ�����������ݿ�
						if (new File(fileRealPath).exists()) {
							// ���·����ֵ
							fileRealResistPath = fileRealPath.substring(fileRealPath.lastIndexOf("\\") + 1);
							
							// ���浽���ݿ�
							System.out.println("������ļ���:" + fileName);
							System.out.println("��ŵ����·��:" + fileRealResistPath);
						}
 
					}
				}
			}
		} catch (org.apache.commons.fileupload.FileUploadException ex) {
			ex.printStackTrace();
			System.out.println("û���ϴ��ļ�");
			return;
		}
		response.getWriter().write("1");
 
	}
 
}
