package AddressBook;

import java.io.*;

public class SerializationToFilePersistence implements FullPersistence {
    private String addressBookPath;

    public SerializationToFilePersistence(String addressBookPath) {
        this.addressBookPath = addressBookPath;
    }

    @Override
    public AddressBookDataModel loadBook() throws AddressBookException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(addressBookPath));
            return (AddressBookDataModel) ois.readObject();
        } catch (IOException e) {
            throw new AddressBookException(e);
        } catch (ClassNotFoundException e) {
            throw new AddressBookException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    // Hier ist nichts mehr zu tun
                }
            }
        }
    }

    @Override
    public void storeBook(AddressBookDataModel book) throws AddressBookException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(addressBookPath));
            oos.writeObject(book);
        } catch (IOException e) {
            throw new AddressBookException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    // Hier ist nichts mehr zu tun
                }
            }
        }
    }
}
