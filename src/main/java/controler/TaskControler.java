/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import util.ConnectionFactory;
import model.Task;

/**

 @author bruno
 */
public class TaskControler {

    public void save(Task task) {

       String sql = "INSERT INTO tasks (idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";

       Connection connection = null;
       PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection ();
            statement = connection.prepareStatement (sql);
            statement.setInt ( 1, task.getIdProject());
            statement.setString ( 2, task.getName());
            statement.setString ( 3, task.getDescription());
            statement.setBoolean ( 4, isIsCompleted());
            statement.setString ( 5, task.getNotes());
            statement.setDate ( 6, new Date(task.getDeadline ().getTime()) );
            statement.setDate ( 7, new Date (task.getCreatedAt().getTime()));
            statement.setDate ( 7, new Date (task.getUpdatedAt().getTime()));
            statement.execute ();
        } catch ( Exception ex ) {
            throw new RuntimeException ("Erro ao salvar tarefa" + ex.getMessage (), ex); 
        } finally {
            ConnectionFactory.closeConnection ( connection );
        }
        }

    private boolean isIsCompleted () {
        throw new UnsupportedOperationException ( "Not supported yet." ); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    
    public void update(Task task) {

         String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, notes = ?, deadline = ?, completed = ?, createdAt = ?, updatedAt = ?, WHERE id = ?";

         Connection connection = null;
         PreparedStatement statement = null;
        
         try {

             connection = ConnectionFactory.getConnection();
             statement = connection.prepareStatement (sql);
             statement.setInt(1, task.getIdProject());
             statement.setString(1, task.getName());
             statement.setString(1, task.getDescription());
             statement.setString(1, task.getNotes());
             statement.setString(1, task.getisISCompleted());
             statement.setDate (1, new Date (task.getDeadline().getTime()));
             statement.setDate (1, new Date (task.getCreatedAt().getTime()));
             statement.setDate (1, new Date (task.getUpdatedAt().getTime()));
             statement.execute();

    } catch (Exception ex) {
         throw new RuntimeException("Erro ao deletar tarefa" + ex.getMessage());
}

    public void removeById(int taskId) throws SQLException{

       String sql = "DELETE FROM tasks WHERE id = ?";

       Connection conn = null;
       PreparedStatement statement = null;

        try {
            
            conn = ConnectionFactory.getConnection ();
            statement = conn.prepareStatement(sql);
            statement.setInt (1, taskId);
            statement.execute ();

        } catch ( Exception ex ) {
            throw new RuntimeException("Erro ao Deletar Tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection ( connection, statement );
}
 

    }

    public List<Task> getAll(int idProject){

    }

    private boolean isIsCompleted () {
        throw new UnsupportedOperationException ( "Not supported yet." ); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
