public enum SendType {
    DHL("DHL", new DHL()),
    EMAIL("EMAIL",new Email()),
    PIGEON("PIGEON", new Pigeon());

    private String typeName;
    private MailDeliveryService sender;

    SendType(String typeName, MailDeliveryService sender) {
        this.typeName = typeName;
        this.sender = sender;
    }
}
