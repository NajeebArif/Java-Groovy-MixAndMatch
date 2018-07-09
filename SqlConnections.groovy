import groovy.sql.Sql;

def url = "jdbc:oracle:thin:@localhost:1521:orcl"
def userName = "c##dev"
def password = "c##dev"
def driver = "oracle.jdbc.driver.OracleDriver"

def sql = Sql.newInstance(url,userName,password,driver)

sql.query("select * from EMPLOYEES"){ rs ->
	if(rs.next()) {
		println rs.getString("FIRST_NAME")
	}
	
}

sql