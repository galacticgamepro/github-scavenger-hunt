class CafeteriaOrder {
    private int studentID;
    private String selectedItem;
    private double totalPrice;

    // Constructor
    public CafeteriaOrder(int studentID, String selectedItem, double totalPrice) {
        this.studentID = studentID;
        this.selectedItem = selectedItem;
        this.totalPrice = totalPrice;
    }

    // Getters
    public int getStudentID() { return studentID; }
    public String getSelectedItem() { return selectedItem; }
    public double getTotalPrice() { return totalPrice; }
}


