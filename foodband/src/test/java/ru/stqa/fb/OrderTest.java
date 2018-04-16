package ru.stqa.fb;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OrderTest extends TestBase {

  @Test
  public void orderAndClientTest() {

    signUp();  // залогинились, перешли к списку заказов


    OrderListPage orderListPage  = new OrderListPage(driver); //

    ProductsPage productsPage=orderListPage.submitProductsPage();
    // проверяем, что попали на страницу списка продуктов нового заказа
    assertTrue(productsPage.isInitialized());

    productsPage.wokChoice();
    productsPage.wokChoice();
    productsPage.productSelect(orderG.nameWOK,orderG.typeWOK);
    productsPage.inComment(1,orderG.commentWOK);

    // проверка продукта
    productsPage.testProduct(orderG,1);

    productsPage.drinkChoice();
    productsPage.nonAlcocolChoice();
    productsPage.drinkSelect(orderG.nameDrink);

    productsPage.qtDrink(orderG.qtDrink);
    productsPage.inComment(2,orderG.commentDrink);

    // проверка напитка
    productsPage.testProduct(orderG,2);

    // переход навкладку Заказ
    OrderPage orderPage=productsPage.submitOrder();

    orderPage.fill(orderG.phoneClient,orderG.nameClient,orderG.addressClient,orderG.paymentTypeClient);

    // проверка автоматически заполненных полей заказа
    orderPage.testProduct(orderG);

    orderPage.ready.click();

    // проверяем, что попали на страницу operator/all
    orderListPage  = new OrderListPage(driver);
    assertTrue(orderListPage.isInitialized());

    //assertEquals("Thank you", receiptPage.confirmationHeader());
  }
}

