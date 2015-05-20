package mr.daoImp;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {

	private static MysqlDataSource dataSource;

	public static void setDataSource(MysqlDataSource dataSource) {
		DataSourceProvider.dataSource = dataSource;
	}

	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("127.10.252.130");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("sitecatho");
			dataSource.setUser("adminpje2alr");
			dataSource.setPassword("3NpPi-LqSjgB");
		}
		return dataSource;
	}
}
