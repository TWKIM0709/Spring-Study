package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	//함수 (추상)
	Connection makeConnection() throws ClassNotFoundException , SQLException;
}
