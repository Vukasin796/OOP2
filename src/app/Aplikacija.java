package app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modeli.OdgovornaOsoba;
import podaci.OdgovorneOsobePodaci;

import java.util.ArrayList;
import java.util.List;

public class Aplikacija {
    private JFrame frame;


    private List<OdgovornaOsoba> listaOdgovornihOsoba = new ArrayList<>();
    private DefaultTableModel model;
    private JTable tabelaPregleda;
    
    
    private void osveziTabelu() {
        model.setRowCount(0); 

        for (OdgovornaOsoba osoba : listaOdgovornihOsoba) {
            model.addRow(new Object[] {
                osoba.getIme(),
                osoba.getPrezime(),
                osoba.getVisinaPlate(),
                osoba.getZvanje(),
                osoba.getStepenObrazovanja()
            });
        }
    }
    

    public Aplikacija() {
    	frame = new JFrame("Aplikacija za upravljanje Objektima");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	frame.setSize(800, 600);
   
    	
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel pregledPanel = new JPanel();
        model = new DefaultTableModel();
        model.addColumn("Ime");
        model.addColumn("Prezime");
        model.addColumn("Visina Plate");
        model.addColumn("Zvanje");
        model.addColumn("Stepen Obrazovanja");

        
        tabelaPregleda = new JTable(model);

        
        JScrollPane scrollPanePregleda = new JScrollPane(tabelaPregleda);
        pregledPanel.add(scrollPanePregleda);
        for (OdgovornaOsoba osoba : listaOdgovornihOsoba) {
            model.addRow(new Object[] {
                osoba.getIme(),
                osoba.getPrezime(),
                osoba.getVisinaPlate(),
                osoba.getZvanje(),
                osoba.getStepenObrazovanja()
            });
        }
        
     

        JPanel dodavanjeIzmenaPanel = new JPanel();
        dodavanjeIzmenaPanel.setPreferredSize(new Dimension(400, 300));

        final JTextField imeTextField = new JTextField(20);
        final JTextField prezimeTextField = new JTextField(20);
        final JTextField visinaPlateTextField = new JTextField(20);
        final JTextField zvanjeTextField = new JTextField(20);
        final JTextField stepenObrazovanjaTextField = new JTextField(20);

        
 
        dodavanjeIzmenaPanel.add(new JLabel("Ime:"));
        dodavanjeIzmenaPanel.add(imeTextField);
        dodavanjeIzmenaPanel.add(new JLabel("Prezime:"));
        dodavanjeIzmenaPanel.add(prezimeTextField);
        dodavanjeIzmenaPanel.add(new JLabel("Visina plate:"));
        dodavanjeIzmenaPanel.add(visinaPlateTextField);
        dodavanjeIzmenaPanel.add(new JLabel("Zvanje:"));
        dodavanjeIzmenaPanel.add(zvanjeTextField);
        dodavanjeIzmenaPanel.add(new JLabel("Stepen obrazovanja:"));
        dodavanjeIzmenaPanel.add(stepenObrazovanjaTextField);
        
        JButton dodajButton = new JButton("Dodaj");
        dodajButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ime = imeTextField.getText();
                String prezime = prezimeTextField.getText();
                double visinaPlate = Double.parseDouble(visinaPlateTextField.getText());
                String zvanje = zvanjeTextField.getText();
                String stepenObrazovanja = stepenObrazovanjaTextField.getText();
               
                OdgovornaOsoba novaOdgovornaOsoba = new OdgovornaOsoba(ime, prezime, visinaPlate, zvanje, stepenObrazovanja);
              
                
                listaOdgovornihOsoba.add(novaOdgovornaOsoba);
                
                OdgovorneOsobePodaci.sacuvajOdgovorneOsobe(listaOdgovornihOsoba, "podaci.txt");
                
                imeTextField.setText("");
                prezimeTextField.setText("");
                visinaPlateTextField.setText("");
                zvanjeTextField.setText("");
                stepenObrazovanjaTextField.setText("");
                
                osveziTabelu();
         
            }
        });

        dodavanjeIzmenaPanel.add(dodajButton);
        
        
        
        
        tabbedPane.addTab("Pregled objekata", pregledPanel);
        tabbedPane.addTab("Dodavanje/izmena objekata", dodavanjeIzmenaPanel);
    

        frame.add(tabbedPane);
        

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem deleteItem = new JMenuItem("Delete");
        editMenu.add(addItem);
        editMenu.add(editItem);
        editMenu.add(deleteItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        
        frame.setVisible(true);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Aplikacija();
            }
        });
    }
}
