public class BookCopy {
    private int copyNumber;
    private Status status;

    public BookCopy(int copyNumber) {
        this.copyNumber = copyNumber;
        this.status = Status.AVAILABLE;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    // public void setCopyNumber(int copyNumber) {
    // this.copyNumber = copyNumber;
    // }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
