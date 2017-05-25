package app;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import config.DataAccessConfig;
import domain.User;

public class JdbcDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(DataAccessConfig.class);
		
		JdbcTemplate db = ctx.getBean(JdbcTemplate.class);
		
		String sql = "delete from users";
		db.update(sql);
		
		String sqlInsert =" Insert into users (first_name, last_name, age) values (?,?,?)";
		db.update(sqlInsert, "Miguel", "Perello", 38);
		db.update(sqlInsert, "Marina", "Rubert", 35);
		db.update(sqlInsert, "Joan", "Fons", 36);
		db.update(sqlInsert, "Joana", "Maria", 31);
		
		String sqlSelect1 = "Select age from users where age = ?";
		String user = db.queryForObject(sqlSelect1, String.class, 38);
		System.out.println(user.toString());
		
		String sqlRow = "select * from users where first_name=?";
		Map<String, Object> map = db.queryForMap(sqlRow, "Miguel");
		System.out.println(map.toString());
		
		String sqlList = "select * from users";
		List<Map<String, Object>> list = db.queryForList(sqlList);
		System.out.println(list.toString());
		
		String sqlRowList = "select * from users";
		List<User> users = db.query(sqlRowList, (rs, num) -> {
				return new User(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age")
				);
		});
		System.out.println(users.toString());

	}
}
