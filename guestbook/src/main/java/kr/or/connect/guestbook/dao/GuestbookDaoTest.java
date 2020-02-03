//package kr.or.connect.guestbook.dao;
//
//import java.time.LocalDateTime;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import kr.or.connect.guestbook.config.ApplicationConfig;
//import kr.or.connect.guestbook.dto.Log;
//
//public class GuestbookDaoTest {
//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		//		GuestbookDao guestbookDao = context.getBean(GuestbookDao.class);
//		//
//		//		Guestbook guestbook = new Guestbook();
//		//		guestbook.setName("홍성문");
//		//		guestbook.setContent("Hello");
//		//		guestbook.setRegdate(LocalDateTime.now());
//		//
//		//		long id = guestbookDao.insert(guestbook);
//		//		System.out.println("id : " + id);
//
//		LogDao logDao = context.getBean(LogDao.class);
//		Log log = new Log();
//		log.setIp("127.0.0.1");
//		log.setMethod("insert");
//		log.setRegdate(LocalDateTime.now());
//		logDao.insert(log);
//	}
//}
