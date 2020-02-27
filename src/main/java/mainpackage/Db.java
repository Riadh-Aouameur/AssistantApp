package mainpackage;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riadh
 */
public class Db {
    private Connection con ;
    private Statement st ;
    private ResultSet rs ;
    public Db (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/rndv","root","1234");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Errer : " + ex);

        }




    }
    public void getData(){
        try {

            System.out.println("records from database");
            String query = "SELECT * FROM Patient";
            rs = st.executeQuery(query);

            while(rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String rndvDay = rs.getString("RndvDay");
                int id =rs.getInt("Id_Patient");
                Rpatients.rPateint.add(new Rpatient(firstName,lastName,rndvDay,id));
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(rndvDay);


            }
        }catch(Exception ex){
            System.out.println(ex);
        }




    }


    public void Show(){
        try {


            String query = "show tables from medical";
            System.out.println("records from databases");

            if (st.execute(query)) {
                rs = st.getResultSet();
            }
            while(rs.next()){
                String database =rs.getString("Tables_in_medical");
                System.out.println(database);




            }

        }catch(Exception ex){
            System.out.println(ex);
        }




    }

    public void setData(String Name ,String lastName,String date,int id){
        try {
            String query ="INSERT INTO Patient(Id_Patient,firstName,LastName,RndvDay) VALUES ("+id+",'"+Name+"'"+","+"'"+lastName+"'"+","+"'"+date+"'"+")";
            st.addBatch(query);
            st.executeBatch();

            System.out.println("Insert");

        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void update(){
        System.out.println("test");
        String sql = "UPDATE Patient SET firstName = ' samir' , lastName = 'benhamie' WHERE Id_Patient = 1";
        try {
            st.executeUpdate(sql);
        }catch(SQLException e) {
            System.out.println("Error");

        }



    }
}


