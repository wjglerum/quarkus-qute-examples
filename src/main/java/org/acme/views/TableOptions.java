package org.acme.views;

public class TableOptions {
    public String name;
    public boolean editable;
    public boolean historic;

    public TableOptions(String name, boolean editable, boolean historic) {
        this.name = name;
        this.editable = editable && !historic;
        this.historic = historic;
    }
}
