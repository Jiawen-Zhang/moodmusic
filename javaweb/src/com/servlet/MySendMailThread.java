package com.servlet;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
import com.entity.User1;
public class MySendMailThread extends Thread {

	private User1 user = null;

	public MySendMailThread(User1 user) {
		this.user = user;
	}

	@Override
	public void run() {

		// ��smtp����������һ������
		Properties p = new Properties();
		// �����ʼ�������������
		p.setProperty("mail.host", "smtp.qq.com");// ָ���ʼ���������Ĭ�϶˿� 25
		// ���ͷ�������Ҫ�����֤
		p.setProperty("mail.smtp.auth", "true");// Ҫ����ָ���û�������ķ�ʽȥ��֤
		// �����ʼ�Э������
		p.setProperty("mail.transport.protocol", "smtp");

		// ����SSL���ܣ������ʧ��
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.socketFactory", sf);

		// ����debug���ԣ��Ա��ڿ���̨�鿴
		// session.setDebug(true);Ҳ������������
		// p.setProperty("mail.debug", "true");

		// ����session
		Session session = Session.getDefaultInstance(p, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// �û���������QQ�˺�Ҳ����������ı���
				PasswordAuthentication pa = new PasswordAuthentication(
						"578357134", "xsxrqyawfarjbcjd");
				// ������ַ�����Ȩ�룬��qq���벻�У���
				return pa;
			}
		});

		session.setDebug(true);// ���ô򿪵���״̬

		try {
			// ����һ��Message����(����һ���ʼ�),��session�д���
			MimeMessage msg = new MimeMessage(session);
			// �ʼ���Ϣ��װ
			// 1������
			msg.setFrom(new InternetAddress("578357134@qq.com"));
			// 2�ռ���
			msg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
			// 3�ʼ�����:���⡢����
			msg.setSubject(user.getName() + ",��ӭע��***�˺�,�������Ӽ����˺�");
             System.out.println(1);
			// StringBuilder���̲߳���ȫ��,�����ٶȿ죬������Ϊֻ��������߳������ʣ����Կ��������
			StringBuilder sbd = new StringBuilder();

			sbd.append("������������:<br/>");
			sbd.append("http://localhost/ActiveServlet?acode="
					+ user.getAcode() + "<br/>");
			sbd.append("<a href='http://localhost/"+user.getAcode()+"'>���ص�¼ҳ</a><br/>");
			sbd.append("����һ���Զ����͵��ʼ����������δҪ���յ�����ż���������Ҫ�����κβ�����");

		System.out.println(sbd);
			msg.setContent(sbd.toString(), "text/html;charset=utf-8");// ��html��ʽ���ı�
			
			// ���Ͷ���
			Transport.send(msg);
			
			System.out.println("��" + user.getEmail() + "�����ʼ��ɹ���");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}


	}
}
