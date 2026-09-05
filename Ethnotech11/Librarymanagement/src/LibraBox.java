import java.util.ArrayList;

abstract class LibraryItem {
    String title;
    double price;
    String category;

    static int issuedCount = 0;

    LibraryItem(String title, double price, String category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    abstract void prepareIssue();

    double getDiscountPrice(double discount) {
        return price - (price * discount / 100);
    }

    void display() {
        System.out.println(title + " | Rs." + price + " | " + category);
    }
}


class PhysicalBook extends LibraryItem {

    PhysicalBook(String title, double price, String category) {
        super(title, price, category);
    }

    void prepareIssue() {
        System.out.println(title + " - Taken from shelf");
        issuedCount++;
    }
}

// Reference Book
class ReferenceBook extends LibraryItem {
    boolean allowed;

    ReferenceBook(String title, double price, String category, boolean allowed) {
        super(title, price, category);
        this.allowed = allowed;
    }

    void prepareIssue() {
        if (allowed) {
            System.out.println(title + " - Reference book prepared");
            issuedCount++;
        } else {
            System.out.println(title + " - Cannot be issued");
        }
    }
}

// E-Book
class EBook extends LibraryItem {
    String format;

    EBook(String title, double price, String category, String format) {
        super(title, price, category);
        this.format = format;
    }

    void prepareIssue() {
        System.out.println(title + " - Download link generated (" + format + ")");
        issuedCount++;
    }
}

// Issue Record
class IssueRecord {
    String memberName;
    int issueId;
    String status;

    ArrayList<LibraryItem> items = new ArrayList<>();

    static int nextId = 1;

    IssueRecord(String memberName) {
        this.memberName = memberName;
        issueId = nextId++;
        status = "Issued";
    }

    void addItem(LibraryItem item) {
        items.add(item);
    }

    double getTotal() {
        double total = 0;

        for (LibraryItem item : items) {
            total += item.price;
        }

        return total;
    }

    void process() {
        status = "Preparing";

        for (LibraryItem item : items) {
            item.prepareIssue();
        }

        status = "Ready for Pickup";
    }

    void printReceipt(double discount) {

        double subtotal = getTotal();
        double discountAmount = subtotal * discount / 100;
        double afterDiscount = subtotal - discountAmount;

        double serviceCharge = afterDiscount * 5 / 100;

        double finalAmount = afterDiscount + serviceCharge;

        System.out.println("\n========== LIBRABOX RECEIPT ==========");
        System.out.println("Issue ID   : " + issueId);
        System.out.println("Member     : " + memberName);
        System.out.println("Status     : " + status);

        System.out.println("--------------------------------------");

        for (LibraryItem item : items) {
            System.out.println(item.title + " - Rs." + item.price);
        }

        System.out.println("--------------------------------------");
        System.out.println("Subtotal        : Rs." + subtotal);
        System.out.println("Discount (10%)  : Rs." + discountAmount);
        System.out.println("Service (5%)    : Rs." + serviceCharge);
        System.out.println("Final Amount    : Rs." + finalAmount);

        System.out.println("======================================");
    }
}


class Library {

    ArrayList<LibraryItem> catalogue = new ArrayList<>();
    ArrayList<IssueRecord> records = new ArrayList<>();

    void addItem(LibraryItem item) {
        catalogue.add(item);
    }

    void displayCatalogue() {

        System.out.println("\n========== LIBRARY CATALOGUE ==========");

        int i = 1;

        for (LibraryItem item : catalogue) {
            System.out.print(i + ". ");
            item.display();
            i++;
        }
    }

    IssueRecord createRecord(String memberName) {

        IssueRecord record = new IssueRecord(memberName);
        records.add(record);

        return record;
    }

    void showSummary() {

        System.out.println("\n========== TRANSACTION SUMMARY ==========");

        for (IssueRecord r : records) {
            System.out.println(
                    "Member: " + r.memberName +
                            " | ID: " + r.issueId +
                            " | Status: " + r.status
            );
        }
    }
}


public class LibraBox {

    public static void main(String[] args) {

        Library library = new Library();

        // Adding 6 items
        library.addItem(
                new PhysicalBook("Java Programming", 500, "Academic")
        );

        library.addItem(
                new PhysicalBook("Harry Potter", 400, "Fiction")
        );

        library.addItem(
                new PhysicalBook("Magazine", 150, "Magazine")
        );

        library.addItem(
                new ReferenceBook("DBMS Reference", 700, "Academic", true)
        );

        library.addItem(
                new ReferenceBook("Dictionary", 600, "Reference", false)
        );

        library.addItem(
                new EBook("Python Basics", 300, "Programming", "PDF")
        );


        library.displayCatalogue();


        IssueRecord record = library.createRecord("Hemanth");


        record.addItem(library.catalogue.get(0));
        record.addItem(library.catalogue.get(1));
        record.addItem(library.catalogue.get(3));
        record.addItem(library.catalogue.get(5));


        System.out.println("\nProcessing Issue...");
        record.process();


        record.printReceipt(10);


        library.showSummary();

        System.out.println(
                "\nTotal Items Issued: " + LibraryItem.issuedCount
        );
    }
}