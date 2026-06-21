package AddressBook;

public interface FullPersistence {
    AddressBookDataModel loadBook() throws AddressBookException;

    void storeBook(AddressBookDataModel book) throws AddressBookException;
}
