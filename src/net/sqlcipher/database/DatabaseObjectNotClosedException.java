package net.sqlcipher.database;

public class DatabaseObjectNotClosedException extends RuntimeException {
    private static final String f9161s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(f9161s);
    }
}
