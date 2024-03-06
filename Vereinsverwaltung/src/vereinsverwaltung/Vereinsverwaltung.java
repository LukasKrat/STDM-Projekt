/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vereinsverwaltung;

/**
 *
 * @author PeerKrimphoff
 */
import DatabaseConnection.SQLMitglied;
import DatabaseConnection.SQLVerwaltung;
import java.awt.Button;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;        
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import vereinsverwaltung.data.Mitglied;
import vereinsverwaltung.data.VereinsAbteilung;
import vereinsverwaltung.gui.ButtonEditor;
import vereinsverwaltung.gui.ButtonRenderer;
import vereinsverwaltung.gui.ButtonColumn;

public class Vereinsverwaltung extends JFrame {

    private JPanel contentPane;
    private JFrame vereinsBeitrittFrame;
    private JFrame verwalterAnmeldungFrame;
    private JFrame manschaftBeitretenFrame;
    private JFrame manschaftVerlassenFrame;
    private JFrame mitgliederListeFrame;
    private JFrame mitgliedBearbeitenFrame;
            
    public static void main(String[] args) {
        SQLMitglied.getAll();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vereinsverwaltung frame = new Vereinsverwaltung();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Vereinsverwaltung() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnVereinBeitreten = new JButton("Verein beitreten");
        btnVereinBeitreten.setFont(new Font("Arial", Font.PLAIN, 24));
        btnVereinBeitreten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openVereinBeitretenFormular();
            }
        });
        btnVereinBeitreten.setBounds(250, 100, 300, 50);
        contentPane.add(btnVereinBeitreten);

        JButton btnVerlassen = new JButton("Verein verlassen");
        btnVerlassen.setFont(new Font("Arial", Font.PLAIN, 24));
        btnVerlassen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aktion: Verein verlassen");
            }
        });
        btnVerlassen.setBounds(250, 180, 300, 50);
        contentPane.add(btnVerlassen);

        JButton btnBeitreten = new JButton("Mannschaft beitreten");
        btnBeitreten.setFont(new Font("Arial", Font.PLAIN, 24));
        btnBeitreten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMannschaftBeitretenFormular();
            }
        });
        btnBeitreten.setBounds(250, 260, 300, 50);
        contentPane.add(btnBeitreten);

        JButton btnVerlassen_1 = new JButton("Mannschaft verlassen");
        btnVerlassen_1.setFont(new Font("Arial", Font.PLAIN, 24));
        btnVerlassen_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openManschaftverlassenFormular();
            }
        });
        
        btnVerlassen_1.setBounds(250, 340, 300, 50);
        contentPane.add(btnVerlassen_1);
        
        JButton btnMitgliederListe = new JButton("Mitglieder");
        btnMitgliederListe.setFont(new Font("Arial", Font.PLAIN, 24));
        btnMitgliederListe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMitgliederListe();
            }
        });
        
        btnMitgliederListe.setBounds(250, 500, 300, 50);
        contentPane.add(btnMitgliederListe);
        
        
        

        JButton btnAnmelden = new JButton("Als Verwalter anmelden");
        btnAnmelden.setFont(new Font("Arial", Font.PLAIN, 24));
        btnAnmelden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openVerwalterAnmeldungFormular();
            }
        });
        btnAnmelden.setBounds(250, 420, 300, 50);
        contentPane.add(btnAnmelden);
    }

    private void openVereinBeitretenFormular() {
        vereinsBeitrittFrame = new JFrame("Verein beitreten");
        vereinsBeitrittFrame.setBounds(100, 100, 800, 600);
        JPanel panel = new JPanel();
        vereinsBeitrittFrame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Arial", Font.PLAIN, 18));
        lblName.setBounds(100, 100, 100, 20);
        panel.add(lblName);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(250, 100, 300, 30);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblGebDat = new JLabel("Geburtsdatum:");
        lblGebDat.setFont(new Font("Arial", Font.PLAIN, 18));
        lblGebDat.setBounds(100, 150, 150, 20);
        panel.add(lblGebDat);

        JTextField textFieldGebDat = new JTextField();
        textFieldGebDat.setBounds(250, 150, 300, 30);
        panel.add(textFieldGebDat);
        textFieldGebDat.setColumns(10);

        JLabel lblAdresse = new JLabel("Adresse:");
        lblAdresse.setFont(new Font("Arial", Font.PLAIN, 18));
        lblAdresse.setBounds(100, 200, 100, 20);
        panel.add(lblAdresse);

        JTextField textFieldAdresse = new JTextField();
        textFieldAdresse.setBounds(250, 200, 300, 30);
        panel.add(textFieldAdresse);
        textFieldAdresse.setColumns(10);

        JLabel lblEmail = new JLabel("E-Mail:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEmail.setBounds(100, 250, 100, 20);
        panel.add(lblEmail);

        JTextField textFieldEmail = new JTextField();
        textFieldEmail.setBounds(250, 250, 300, 30);
        panel.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblTelefonnummer = new JLabel("Telefonnummer:");
        lblTelefonnummer.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTelefonnummer.setBounds(100, 300, 150, 20);
        panel.add(lblTelefonnummer);

        JTextField textFieldTelefonnummer = new JTextField();
        textFieldTelefonnummer.setBounds(250, 300, 300, 30);
        panel.add(textFieldTelefonnummer);
        textFieldTelefonnummer.setColumns(10);

        JButton btnBestaetigen = new JButton("Bestätigen");
        btnBestaetigen.setFont(new Font("Arial", Font.PLAIN, 18));
        btnBestaetigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String gebDat = textFieldGebDat.getText();
                String adresse = textFieldAdresse.getText();
                String email = textFieldEmail.getText();
                String telefonnummer = textFieldTelefonnummer.getText();

                if (name.isEmpty() || gebDat.isEmpty() || adresse.isEmpty() || email.isEmpty() || telefonnummer.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder aus.");
                } else {
                    System.out.println("Name: " + name + ", Geburtsdatum: " + gebDat + ", Adresse: " + adresse + ", E-Mail: " + email + ", Telefonnummer: " + telefonnummer);
                    JOptionPane.showMessageDialog(null, "Das Formular wurde bestätigt. Sie sind dem Verein beigetreten.");
                    vereinsBeitrittFrame.dispose();
                }
            }
        });
        btnBestaetigen.setBounds(325, 400, 150, 30);
        panel.add(btnBestaetigen);

        vereinsBeitrittFrame.setVisible(true);
    }

    private void openVerwalterAnmeldungFormular() {
        verwalterAnmeldungFrame = new JFrame("Als Verwalter anmelden");
        verwalterAnmeldungFrame.setBounds(100, 100, 800, 600);
        JPanel panel = new JPanel();
        verwalterAnmeldungFrame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblEmail = new JLabel("E-Mail:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEmail.setBounds(100, 100, 100, 20);
        panel.add(lblEmail);

        JTextField textFieldEmail = new JTextField();
        textFieldEmail.setBounds(250, 100, 300, 30);
        panel.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblPasswort = new JLabel("Passwort:");
        lblPasswort.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPasswort.setBounds(100, 150, 100, 20);
        panel.add(lblPasswort);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 150, 300, 30);
        panel.add(passwordField);

        JButton btnAnmelden = new JButton("Anmelden");
        btnAnmelden.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAnmelden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                String passwort = new String(passwordField.getPassword());

                if (email.isEmpty() || passwort.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie Ihre E-Mail und Ihr Passwort ein.");
                } else {
                    // Hier können Sie den Code zur Überprüfung der Anmeldeinformationen des Verwalters implementieren
                    System.out.println("E-Mail: " + email + ", Passwort: " + passwort);
                    JOptionPane.showMessageDialog(null, "Erfolgreich als Verwalter angemeldet.");
                    verwalterAnmeldungFrame.dispose();
                }
            }
        });
        btnAnmelden.setBounds(325, 250, 150, 30);
        panel.add(btnAnmelden);

        verwalterAnmeldungFrame.setVisible(true);
    }
    
    private void openMannschaftBeitretenFormular()
    {
        manschaftBeitretenFrame = new JFrame("Manschaft beitreten");
        manschaftBeitretenFrame.setBounds(100,100,800,600);
        JPanel panel = new JPanel();
        manschaftBeitretenFrame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblEmail = new JLabel("E-Mail:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEmail.setBounds(100, 100, 100, 20);
        panel.add(lblEmail);

        JTextField textFieldEmail = new JTextField();
        textFieldEmail.setBounds(250, 100, 300, 30);
        panel.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblPasswort = new JLabel("Passwort:");
        lblPasswort.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPasswort.setBounds(100, 150, 100, 20);
        panel.add(lblPasswort);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 150, 300, 30);
        panel.add(passwordField);
        
        JLabel lblManschaft = new JLabel("Manschaft:");
        lblManschaft.setFont(new Font("Arial", Font.PLAIN, 18));
        lblManschaft.setBounds(100, 200, 100, 20);
        panel.add(lblManschaft);
        
        JComboBox comboboxManschaft = new JComboBox();
        comboboxManschaft.setBounds(250, 200, 300, 30);
        panel.add(comboboxManschaft);
        
        manschaftBeitretenFrame.setVisible(true);
    } 
    
    private void openManschaftverlassenFormular()
    {
        manschaftVerlassenFrame = new JFrame("Manschaft verlassen");
        manschaftVerlassenFrame.setBounds(100,100,800,600);
        JPanel panel = new JPanel();
        manschaftVerlassenFrame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblEmail = new JLabel("E-Mail:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEmail.setBounds(100, 100, 100, 20);
        panel.add(lblEmail);

        JTextField textFieldEmail = new JTextField();
        textFieldEmail.setBounds(250, 100, 300, 30);
        panel.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblPasswort = new JLabel("Passwort:");
        lblPasswort.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPasswort.setBounds(100, 150, 100, 20);
        panel.add(lblPasswort);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 150, 300, 30);
        panel.add(passwordField);
        
        JLabel lblManschaft = new JLabel("Manschaft:");
        lblManschaft.setFont(new Font("Arial", Font.PLAIN, 18));
        lblManschaft.setBounds(100, 200, 100, 20);
        panel.add(lblManschaft);
        
        JComboBox comboboxManschaft = new JComboBox();
        comboboxManschaft.setBounds(250, 200, 300, 30);
        panel.add(comboboxManschaft);
        
        manschaftVerlassenFrame.setVisible(true);
    } 
    private void openMitgliederListe()
    {
        mitgliederListeFrame = new JFrame("MitgliederListen");
        mitgliederListeFrame.setBounds(100,100,1000,800);
        JTabbedPane panel = new JTabbedPane();
        //JPanel panel = new JPanel();
        mitgliederListeFrame.getContentPane().add(panel);
        //panel.setLayout(null);

        DefaultTableModel mitgliederModel = new DefaultTableModel();
        
        mitgliederModel.addColumn("Vorname");
        mitgliederModel.addColumn("Nachname");
        mitgliederModel.addColumn("TelefonNr");
        mitgliederModel.addColumn("E-Mail");
        mitgliederModel.addColumn("Adresse");
        mitgliederModel.addColumn("Abteilungsname");
        mitgliederModel.addColumn("Verwalter");
        mitgliederModel.addColumn("Bearbeiten");
        
        
        ArrayList<Mitglied> mitglieder = SQLMitglied.getAll();
        
        for(Mitglied mitglied: mitglieder){
            
            String verwalter;
            
            if(mitglied.getIstVerwalter() == true){
                    verwalter = "Ja";
                } else{
                    verwalter = "nein";
                }
            
            JButton btnMitgliedBearbeiten = new JButton("Bearbeiten");
            btnMitgliedBearbeiten.setFont(new Font("Arial", Font.PLAIN, 18));
            
            btnMitgliedBearbeiten.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   openMitgliedBearbeitenFormular(mitglied.getId());
                }
            });
            
            //VereinsAbteilung abteilung = SQLVerwaltung.getByID(mitglied.getAbteilung_id());
            
            mitgliederModel.addRow(new Object[]{
                mitglied.getVorname(),
                mitglied.getNachname(),
                mitglied.getTelefon(),
                mitglied.getEmail(),
                mitglied.getAdresse(),
                mitglied.getAbteilung_id(), //abteilung.getName();
                verwalter,
                "Bearbeiten"/*,
                btnMitgliedBearbeiten*/
            });
        }
        
        JTable mitgliederTable = new JTable(mitgliederModel){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex){
                if(colIndex == 7){
                    return true;
                }
                return false;
            }
        };
        //mitgliederTable.getColumn("Bearbeiten").setCellRenderer(new ButtonRenderer());
        //mitgliederTable.getColumn("Bearbeiten").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        Action bearbeiten = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                System.out.println(modelRow);
                openMitgliedBearbeitenFormular(mitglieder.get(modelRow).getId());
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn(mitgliederTable, bearbeiten, 7);
        
        JScrollPane mitgliederPane = new JScrollPane(mitgliederTable);
        panel.addTab("Mitglieder",mitgliederPane);
        
        //mitgliederListeFrame.add(panel);
        
        
        mitgliederListeFrame.setVisible(true);
    } 
    private void openMitgliedBearbeitenFormular(int id){
        mitgliedBearbeitenFrame = new JFrame("Mitglied Bearbeiten");
        mitgliedBearbeitenFrame.setBounds(100,100,1000,800);
        JPanel panel = new JPanel();
        mitgliedBearbeitenFrame.getContentPane().add(panel);
        //panel.setLayout(null);
        
        mitgliedBearbeitenFrame.setVisible(true);
    }
}
