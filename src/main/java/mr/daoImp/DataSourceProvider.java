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
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("projet_catho");
			dataSource.setUser("root");
			dataSource.setPassword("");
		}
		return dataSource;
	}
}
