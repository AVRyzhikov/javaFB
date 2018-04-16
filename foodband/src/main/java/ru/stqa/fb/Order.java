package ru.stqa.fb;

public class Order {
  public String nameWOK;
  public String typeWOK;
  public int priceWOK;
  public int qtWOK;
  public String commentWOK;
  public String nameDrink;
  public int priceDrink;
  public int qtDrink;
  public String commentDrink;
  public String phoneClient;
  public String nameClient;
  public String addressClient;
  public String paymentTypeClient;
  public String filial;
  public String source;
  public int deal;

  public Order(String nameWOK, String typeWOK, int priceWOK, int qtWOK, String commentWOK,
               String nameDrink, int priceDrink, int qtDrink, String commentDrink,
               String phoneClient, String nameClient, String addressClient, String paymentTypeClient,
               String filial, String source, int deal) {
    this.nameWOK = nameWOK;
    this.typeWOK = typeWOK;
    this.priceWOK = priceWOK;
    this.qtWOK = qtWOK;
    this.commentWOK = commentWOK;

    this.nameDrink = nameDrink;
    this.priceDrink = priceDrink;
    this.qtDrink = qtDrink;
    this.commentDrink = commentDrink;

    this.phoneClient = phoneClient;
    this.nameClient = nameClient;
    this.addressClient = addressClient;
    this.paymentTypeClient = paymentTypeClient;
    this.filial = filial;
    this.source = source;
    this.deal = deal;
  }

  public int costWOK() {
    return this.priceWOK * this.qtWOK;
  }

  public int costDrink() {
    return this.priceDrink * this.qtDrink;
  }
}
