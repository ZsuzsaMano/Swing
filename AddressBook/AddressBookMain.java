package AddressBook;

import java.io.File;
import java.awt.*;
import javax.swing.*;

public class AddressBookMain {
    private static final String ADDRESSBOOK_DEFAULT_NAME = "test.ab";
    private SerializationToFilePersistence persistence;
    private AddressBookDataModel model;

    public AddressBookMain() throws AddressBookException {
        initModelAndPersistence();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainFrame = new JFrame("Adressbuch");
                mainFrame.setBackground(Color.LIGHT_GRAY);
                PersonPanel personPanel = new PersonPanel(model);
                mainFrame.add(personPanel, BorderLayout.NORTH);
                JPanel southPanel = new JPanel();
                Button newPersonButton = new Button("Neuer Eintrag");
                southPanel.add(newPersonButton);
                mainFrame.add(southPanel, BorderLayout.SOUTH);
                // Erzeugen und Anmelden eines Controllers
                Controller controller = new Controller(model, personPanel,
                        persistence, mainFrame);
                newPersonButton.addActionListener(controller);
                mainFrame.addWindowListener(controller);
                mainFrame.setSize(500, 500);
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
            }
        });
    }

    private void initModelAndPersistence() throws AddressBookException {
        String addressBookDirPath = System.getProperty("user.home") + "/addressbooks";
        File addressBookDir = new File(addressBookDirPath);
        addressBookDir.mkdir();
        String addressBookPath = addressBookDirPath + "/" + ADDRESSBOOK_DEFAULT_NAME;
        persistence = new SerializationToFilePersistence(addressBookPath);
        File addressBookFile = new File(addressBookPath);
        if (addressBookFile.exists()) {
            System.out.println("Adressbuchdatei gefunden, lade Adressbuch.");
            model = persistence.loadBook();
        } else {
            System.out.println("Adressbuchdatei nicht gefunden, erstelle neues Adressbuch.");
            model = new ArrayListAddressBookDataModel();
        }
    }

    public static void main(String[] args) {
        try {
            new AddressBookMain();
        } catch (AddressBookException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
