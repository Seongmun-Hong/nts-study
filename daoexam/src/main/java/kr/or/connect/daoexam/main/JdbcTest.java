package kr.or.connect.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JdbcTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = applicationContext.getBean(RoleDao.class);

		Role role = new Role();
		role.setRoleId(501);
		role.setDescription("CEO");

		int insertCount = roleDao.insert(role);

		if (insertCount == 1) {
			System.out.println("추가 성공!!");
		} else {
			System.out.println("추가 실패 !!");
		}

		List<Role> list = roleDao.selectAll();

		for (Role tempRole : list) {
			System.out.println(tempRole.toString());
		}

		role.setDescription("SUPER CEO");

		int updateCount = roleDao.update(role);

		if (updateCount == 1) {
			System.out.println("업데이트 성공!!");
		} else {
			System.out.println("업데이트 실패 !!");
		}

		list = roleDao.selectAll();

		for (Role tempRole : list) {
			System.out.println(tempRole.toString());
		}

		Role selectedRole = roleDao.selectById(501);
		System.out.println("찾은 Role은 ? " + selectedRole.toString());

		int deleteCount = roleDao.deleteById(501);
		if (deleteCount == 1) {
			System.out.println("삭제 성공!!");
		} else {
			System.out.println("삭제  실패!!");
		}

		list = roleDao.selectAll();

		for (Role tempRole : list) {
			System.out.println(tempRole.toString());
		}
	}
}
