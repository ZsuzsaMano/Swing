package AddressBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controller extends WindowAdapter implements ActionListener {
    private AddressBookDataModel model;
    private PersonPanel view;
    private FullPersistence persistence;
    private JFrame mainFrame;

    public Controller(AddressBookDataModel model, PersonPanel view,
            FullPersistence persistence, JFrame mainFrame) {
        this.model = model;
        this.view = view;
        this.persistence = persistence;
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createAndShowNewPersonDialog();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            persistence.storeBook(model);
            System.out.println("Adressbuch gespeichert.");
        } catch (AddressBookException abe) {
            System.out.println("Adressbuch konnte nicht gespeichert werden.");
            abe.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    private void createAndShowNewPersonDialog() {
        JDialog newPersonDialog = new JDialog(mainFrame, "Neue Person", true);
        JPanel dataPanel = new JPanel(new GridLayout(3, 2));
        JTextField firstNameTextField = new JTextField(15);
        JTextField lastNameTextField = new JTextField(15);
        JTextField phoneTextField = new JTextField(15);
        dataPanel.add(new JLabel("Vorname: "));
        dataPanel.add(firstNameTextField);
        dataPanel.add(new JLabel("Nachname: "));
        dataPanel.add(lastNameTextField);
        dataPanel.add(new JLabel("Telefon: "));
        dataPanel.add(phoneTextField);
        newPersonDialog.add(dataPanel, BorderLayout.CENTER);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Person newPerson = new Person(firstNameTextField.getText(),
                        lastNameTextField.getText(), phoneTextField.getText());
                model.addPerson(newPerson);
                view.refresh();
                newPersonDialog.dispose();
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.add(okButton);
        newPersonDialog.add(southPanel, BorderLayout.SOUTH);
        newPersonDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                newPersonDialog.dispose();
            }
        });
        newPersonDialog.pack();
        newPersonDialog.setLocationRelativeTo(mainFrame);
        newPersonDialog.setVisible(true);
    }
}