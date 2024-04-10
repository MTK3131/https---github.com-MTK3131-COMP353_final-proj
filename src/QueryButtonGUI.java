import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class QueryButtonGUI extends JFrame implements ActionListener {

    public QueryButtonGUI() {
    
        String url = "jdbc:mysql://dkc353.encs.concordia.ca//dck353_4";
        String username = "dkc353_4";
        String password = "NEYMiKqdFPkFb69";
 

        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        //     Connection connection = DriverManager.getConnection(url, username, password);
        //     System.out.println("Database connected"); 
        // } catch (Exception e) {
        //     throw new IllegalStateException("Cannot connect the database", e);
        // }

        setTitle("dck353_4 GUI");   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 3));   


        for (int i = 1; i <= 21; i++) {
            JButton button = new JButton("Query " + i);
            button.setActionCommand(Integer.toString(i));
            button.addActionListener(this);
            add(button);
            if (i == 1) {
                button.setText("Facilities");
            }
            if (i == 2) {
                button.setText("Residences");
            }
            if (i == 3) {
                button.setText("Persons");
            }
            if (i == 4) {
                button.setText("Employees");
            }
            if (i == 5) {
                button.setText("Vaccines");
            }
            if (i == 6) {
                button.setText("Infections");
            }
            if (i == 7) {
                button.setText("Schedule");
            }
            if (i == 21) {
                button.setText("Send Email");
            }
        }

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int queryNumber = Integer.parseInt(command);

        //Statement st = connection.createStatement();
        ResultSet rs;
        String query;
        String input;
        String msg = "1";

        switch (queryNumber) { 
            case 1:
            JFrame editFrame = new JFrame("Edit Options");

            editFrame.setLayout(new FlowLayout());

            JButton createButton = new JButton("Create");
            //query = "INSERT INTO Facilities(fName, fType, capacity, tNumber, address, city, province, postalCode, webAddress, managerSSN) VALUES("+newFname+", 'hospital', 5000, 555-555-5555, '123 Added Facility Street', 'AddedCity', 'AddedProvince', 'AddedPostalCode', 'www.added.com', '123456789')";
            
            createButton.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    JFrame editFrame = new JFrame("User Inputs");
                    //rs = st.executeQuery(query);
                }
            }));


            JButton deleteButton = new JButton("Delete");
            query = "";
            
            deleteButton.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //rs = st.executeQuery(query);
                }}));

            JButton editButton = new JButton("Edit");
            query = "";
            
            deleteButton.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //rs = st.executeQuery(query);
                }}));

            JButton displayButton = new JButton("Display");
            query = "";
            
            displayButton.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //rs = st.executeQuery(query);
                //     while (rs.next()) {
                //         msg = rs.getString("fName")+" "+rs.getString("fType")+" "+rs.getString("capacity")+" "+rs.getString("tNumber")+" "+rs.getString("address")+" "+rs.getString("city")+" "+rs.getString("province")+" "+rs.getString("postalCode")+" "+rs.getString("webAddress")+" "+rs.getString("managerSSN") + "\n";
                //    }
                    JOptionPane.showMessageDialog(null, msg);
                }})); 

            editFrame.add(createButton);
            editFrame.add(deleteButton);
            editFrame.add(editButton);
            editFrame.add(displayButton);

            editFrame.pack();
            editFrame.setVisible(true);
            break;

            case 2:
                editFrame = new JFrame("Edit Options");

                editFrame.setLayout(new FlowLayout());

                createButton = new JButton("Create");
                deleteButton = new JButton("Delete");
                editButton = new JButton("Edit");
                displayButton = new JButton("Display");

                editFrame.add(createButton);
                editFrame.add(deleteButton);
                editFrame.add(editButton);
                editFrame.add(displayButton);

                editFrame.pack();
                editFrame.setVisible(true);
                break;

            case 3:
                editFrame = new JFrame("Edit Options");

                editFrame.setLayout(new FlowLayout());

                createButton = new JButton("Create");
                deleteButton = new JButton("Delete");
                editButton = new JButton("Edit");
                displayButton = new JButton("Display");

                editFrame.add(createButton);
                editFrame.add(deleteButton);
                editFrame.add(editButton);
                editFrame.add(displayButton);

                editFrame.pack();
                editFrame.setVisible(true);
                break;

            case 4:
                editFrame = new JFrame("Edit Options");

                editFrame.setLayout(new FlowLayout());

                createButton = new JButton("Create");
                deleteButton = new JButton("Delete");
                editButton = new JButton("Edit");
                displayButton = new JButton("Display");

                editFrame.add(createButton);
                editFrame.add(deleteButton);
                editFrame.add(editButton);
                editFrame.add(displayButton);

                editFrame.pack();
                editFrame.setVisible(true);
                break;

            case 5:
                editFrame = new JFrame("Edit Options");

                editFrame.setLayout(new FlowLayout());

                createButton = new JButton("Create");
                deleteButton = new JButton("Delete");
                editButton = new JButton("Edit");
                displayButton = new JButton("Display");

                editFrame.add(createButton);
                editFrame.add(deleteButton);
                editFrame.add(editButton);
                editFrame.add(displayButton);

                editFrame.pack();
                editFrame.setVisible(true);
                break;

            case 6:
                editFrame = new JFrame("Edit Options");

                editFrame.setLayout(new FlowLayout());

                createButton = new JButton("Create");
                deleteButton = new JButton("Delete");
                editButton = new JButton("Edit");
                displayButton = new JButton("Display");

                editFrame.add(createButton);
                editFrame.add(deleteButton);
                editFrame.add(editButton);
                editFrame.add(displayButton);

                editFrame.pack();
                editFrame.setVisible(true);
                break;

            case 7:
                editFrame = new JFrame("Edit Options");

                editFrame.setLayout(new FlowLayout());

                JButton assignButton = new JButton("Assign");
                deleteButton = new JButton("Delete");
                editButton = new JButton("Edit");

                editFrame.add(assignButton);
                editFrame.add(deleteButton);
                editFrame.add(editButton);

                editFrame.pack();
                editFrame.setVisible(true);
                break;

            case 8:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 9:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 10:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 11:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 12:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 13:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 14:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 15:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 16:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 17:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 18:
                JOptionPane.showMessageDialog(this, "Execute Query and Show Results");
                break;

            case 19:

                JOptionPane.showMessageDialog(this, "DISPLAY QUERY RESULT");
                break;

            case 20:

                JOptionPane.showMessageDialog(this, "DISPLAY QUERY RESULT");
                break;

            case 21:

                JOptionPane.showMessageDialog(this, "DISPLAY QUERY RESULT");
                break;
            default:
                System.out.println("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QueryButtonGUI gui = new QueryButtonGUI();
            gui.setVisible(true);
        });
    }
}
