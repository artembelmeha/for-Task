import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return connection.createStatement();
    }
    public void closeStatement() throws SQLException {
        statement.close();
    }
    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        String sql = "CREATE SCHEMA IF NOT EXISTS "+schemaName+";";
        statement.executeUpdate(sql);
    }
    public void dropSchema() throws SQLException {
        String sql = "DROP SCHEMA IF EXISTS "+schemaName;
        statement.executeUpdate(sql);
    }
    public void useSchema() throws SQLException {
        String sql ="SET SCHEMA "+schemaName+";";
     //   String sql ="ONLY USE "+schemaName+";";
        statement.executeUpdate(sql);
    }
    public void createTableRoles() throws SQLException {
        String sql = "CREATE TABLE if not exists Roles (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "roleName VARCHAR (50) UNIQUE NOT NULL, " +
                "primary key (id));";
        statement.execute(sql);
    }
    public void createTableDirections() throws SQLException {
        String sql = "CREATE TABLE if not exists Directions (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "directionName VARCHAR (50) UNIQUE NOT NULL, " +
                "PRIMARY KEY (id));";
        statement.executeUpdate(sql);
    }
    public void createTableProjects() throws SQLException {
        String sql = "CREATE TABLE if NOT EXISTS Projects (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "projectName VARCHAR (50) UNIQUE NOT NULL, " +
                "directionId INTEGER, " +
                "primary key (id), " +
                "FOREIGN KEY (directionId) REFERENCES Directions(id));";
        statement.executeUpdate(sql);
    }
    public void createTableEmployee() throws SQLException {
        String sql = "CREATE TABLE if NOT EXISTS Employee (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "firstName VARCHAR (50)  NOT NULL, " +
                "roleId INTEGER, " +
                "projectId INTEGER, " +
                "primary key (id), " +
                "FOREIGN KEY (roleId) REFERENCES Roles(id), "+
                "FOREIGN KEY (projectId) REFERENCES Projects(id));";
        statement.executeUpdate(sql);
    }
    public void dropTable(String tableName) throws SQLException {
        String sql = "DROP TABLE  "+tableName;
        statement.executeUpdate(sql);
    }
    public void insertTableRoles(String roleName) throws SQLException {
        String sql = "INSERT INTO Roles (roleName) "+
        "VALUES ('"+roleName+"');";
        statement.executeUpdate(sql);
    }
    public void insertTableDirections(String directionName) throws SQLException {
        String sql = "INSERT INTO Directions (directionName) "+
                "VALUES ('"+directionName+"');";
        statement.executeUpdate(sql);
    }
    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        String sql = "INSERT INTO Projects (projectName, directionId) " +
                "VALUES ('"+projectName+
                "', '"+ getDirectionId(directionName)+"');";
        statement.executeUpdate(sql);
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        String sql = "INSERT INTO Employee (firstName, roleID, projectID) " +
                "VALUES ('"+firstName+ "', '" +
                getRoleId(roleName)+"', '" +
                getProjectId(projectName)+"');";
        statement.executeUpdate(sql);
    }
    public int getRoleId(String roleName) throws SQLException {
        ResultSet rs =statement.executeQuery("SELECT id FROM Roles WHERE roleName = '" + roleName+ "';");
        return rs.next() ? rs.getInt("id") : 0;
    }
    public int getDirectionId(String directionName) throws SQLException {
        ResultSet rs =statement.executeQuery("SELECT id FROM Directions WHERE directionName = '" + directionName+ "';");
        return rs.next() ? rs.getInt("id") : 0;
    }
    public int getProjectId(String projectName) throws SQLException {
        ResultSet rs =statement.executeQuery("SELECT id FROM Projects WHERE projectName = '" + projectName+ "';");
        return rs.next() ? rs.getInt("id") : 0;
    }
    public int getEmployeeId(String firstName) throws SQLException {
        ResultSet rs =statement.executeQuery("SELECT id FROM Employee WHERE firstName = '" + firstName+ "';");
        return rs.next() ? rs.getInt("id") : 0;
    }
    public List<String> getAllRoles() throws SQLException {
        ArrayList<String> list =new ArrayList<>();
        ResultSet rs =statement.executeQuery("SELECT roleName FROM Roles ;");
        while (rs.next()) {
            list.add(rs.getString("roleName"));
        }
        return list;
    }
    public List<String> getAllDirestion() throws SQLException {
        ArrayList<String> list =new ArrayList<>();
        ResultSet rs =statement.executeQuery("SELECT directionName FROM Directions ;");
        while (rs.next()) {
            list.add(rs.getString("directionName"));
        }
        return list;
    }
    public List<String> getAllProjects() throws SQLException {
        ArrayList<String> list =new ArrayList<>();
        ResultSet rs =statement.executeQuery("SELECT projectName FROM Projects ;");
        while (rs.next()) {
            list.add(rs.getString("projectName"));
        }
        return list;
    }
    public List<String> getAllEmployee() throws SQLException {
        ArrayList<String> list =new ArrayList<>();
        ResultSet rs =statement.executeQuery("SELECT firstName FROM Employee ;");
        while (rs.next()) {
            list.add(rs.getString("firstName"));
        }
        return list;
    }
    public List<String> getAllDevelopers() throws SQLException {
        ArrayList<String> list =new ArrayList<>();
        ResultSet rs =statement.executeQuery("SELECT firstName FROM Employee WHERE roleId='" +
                getRoleId("Developer")+"' ;");
        while (rs.next()) {
            list.add(rs.getString("firstName"));
        }
        return list;
    }
    public List<String> getAllJavaProjects() throws SQLException {
        ArrayList<String> list =new ArrayList<>();
        ResultSet rs =statement.executeQuery("SELECT projectName FROM Projects WHERE directionId='" +
                getDirectionId("Java")+"' ;");
        while (rs.next()) {
            list.add(rs.getString("projectName"));
        }
        return list;
    }
    public List<String> getAllJavaDevelopers() throws SQLException {
        ArrayList<String> list =new ArrayList<>();
        ResultSet resSet = statement.executeQuery("SELECT id FROM Projects WHERE directionId='" +
                getDirectionId("Java")+"'");
        List<Integer> projectIdJava = new ArrayList<>();
        while (resSet.next()) {
            projectIdJava.add(resSet.getInt("id"));
        }
        for (int iProject:projectIdJava) {
            resSet = statement.executeQuery("SELECT firstName FROM Employee WHERE ( roleId='" +
                    getRoleId("Developer") + "'AND projectId='" + iProject + "');");

            while (resSet.next()) {
                list.add(resSet.getString("firstName"));
            }
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        MyUtils myUtils = new MyUtils();
        myUtils.createConnection();
        myUtils.createStatement();
        myUtils.createSchema("Try");
        myUtils.useSchema();
        myUtils.createTableRoles();
        myUtils.createTableDirections();
        myUtils.createTableProjects();
        myUtils.createTableEmployee();
        System.out.println(myUtils.getAllJavaDevelopers());
    }

}

