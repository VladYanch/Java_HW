public class Registration {
    private int size;
    private  int capacity;
    private Booking[] bookingArray;

//    public boolean status;

    public Registration(int capacity) {
        this.capacity =capacity;
        bookingArray = new Booking[capacity];
        size =0;
    }

    public void addBooking(Booking booking){
        if(size<bookingArray.length){
            bookingArray[size]=booking;
            size++;
//            return status=true;
//        } else {
//            return status=false;
        }
    }

    public void delBooking(int room) {
        bookingArray[room]=null;
    }

    public String toString(){
        String res="";
        for (int i=0; i<bookingArray.length && i<size;i++){
            res+=bookingArray[i]+System.lineSeparator();
        }
        res+="---------------"+System.lineSeparator()+ "Total: "+ size +" booking";
        return res;
    }

    public Booking get(int index){
        if (index<size) {
            return bookingArray[index];
        } else {
            return null;
        }
    }
}

