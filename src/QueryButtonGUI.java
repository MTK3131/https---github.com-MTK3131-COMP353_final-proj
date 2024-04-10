import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Timer;
import javax.mail.*;

public class QueryButtonGUI extends JFrame implements ActionListener {
    private static final String DATABASE_NAME = "dkc353_4";
    private static final String CONNECTION_STRING = "jdbc:mysql://dkc353.encs.concordia.ca:3306/" + DATABASE_NAME;
    private static final String USERNAME = "dkc353_4";
    private static final String PASSWORD = "NEYMiKqdFPkFb69";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection connection = null;

    public QueryButtonGUI() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            System.out.println("Database connected");
        } catch (Exception e) {
            throw new IllegalStateException("Cannot connect the database. " + e.getCause(), e);
        }

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
        Statement st = null;
        try {
            st = connection.createStatement();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        ResultSet rs;
        String query;
        String input;
        String msg = "1";

        switch (queryNumber) {
            case 1:
                JFrame editFrame = new JFrame("Edit Options");

                editFrame.setLayout(new FlowLayout());

                JButton createButton = new JButton("Create");
                // query = "INSERT INTO Facilities(fName, fType, capacity, tNumber, address,
                // city, province, postalCode, webAddress, managerSSN) VALUES("+newFname+",
                // 'hospital', 5000, 555-555-5555, '123 Added Facility Street', 'AddedCity',
                // 'AddedProvince', 'AddedPostalCode', 'www.added.com', '123456789')";

                createButton.addActionListener((new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame editFrame = new JFrame("User Inputs");
                        // rs = st.executeQuery(query);
                    }
                }));

                JButton deleteButton = new JButton("Delete");
                query = "";

                deleteButton.addActionListener((new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // rs = st.executeQuery(query);
                    }
                }));

                JButton editButton = new JButton("Edit");
                query = "";

                deleteButton.addActionListener((new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // rs = st.executeQuery(query);
                    }
                }));

                JButton displayButton = new JButton("Display");
                query = "";

                displayButton.addActionListener((new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Statement st = connection.createStatement();
                            ResultSet rs = st.executeQuery("SELECT * FROM Facilities");
                            ArrayList<String[]> data = new ArrayList<String[]>();
                            while (rs.next()) {
                                ArrayList<String> row = new ArrayList<String>();
                                row.add(rs.getString("fName"));
                                row.add(rs.getString("fType"));
                                row.add(rs.getString("capacity"));
                                row.add(rs.getString("tNumber"));
                                row.add(rs.getString("address"));
                                row.add(rs.getString("city"));
                                row.add(rs.getString("province"));
                                row.add(rs.getString("postalCode"));
                                row.add(rs.getString("webAddress"));
                                row.add(rs.getString("managerSSN"));

                                data.add(row.toArray(new String[row.size()]));
                            }
                            String[] attributes = new String[] { "fName", "fType", "capacity", "tNumber", "address",
                                    "city", "province", "postalCode", "webAddress", "managerSSN" };
                            QueryResult qr = new QueryResult(attributes, data.toArray(new String[data.size()][]));
                            qr.show();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }));

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

    public static void sendEmails() {
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    Class.forName(DRIVER);
                    Connection conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
                    System.out.println("Database connected");

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM EmailQueue");
                    while (rs.next()) {
                        String to = rs.getString("receiver");
                        String subject = rs.getString("subject");
                        String body = rs.getString("body");

                        try {
                            EmailUtility.sendEmail(to, subject, body);
                             
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        // stmt.executeUpdate("DELETE FROM EmailQueue WHERE id = " + rs.getInt("id"));
                        
                    }

                } catch (Exception e) {
                    throw new IllegalStateException("Cannot connect the database. " + e.getCause(), e);
                }
            }
        };

        long delay = 1000L;
        long period = 5000L * 60L;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, delay, period);
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QueryButtonGUI gui = new QueryButtonGUI();
            gui.setVisible(true);
        });
        sendEmails();
    }
}
