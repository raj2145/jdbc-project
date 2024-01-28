package com.jsp.shop.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jsp.shop.controller.ShopController;
import com.jsp.shop.model.product;

public class ShopView {
	static Scanner myInput = new Scanner(System.in);
	static product prduct = new product();
	static ShopController shopController = new ShopController();

	public static void main(String[] args) throws SQLException {

		do {
			System.out.println("1.Add product\n2.Remove product\n3.Upade product detail\n0.exit");
			System.out.print("Enter digit respective to desired option :");
			int userInput = myInput.nextInt();
			myInput.nextLine();
			switch (userInput) {
			case 0:
			
				myInput.close();
				System.out.println("----EXITED---------");
				System.exit(0);
				break;
			case 1:
				System.out.println("hoew many product do you want to add ?\n1. Single product \n2. multiple product");
				int productCount =myInput.nextInt();
				myInput.nextLine();
				if (productCount == 1) {
					System.out.print("Enter product id :");
					int i_p_id = myInput.nextInt();
					myInput.nextLine();
					System.out.println("Enter product name:");
					String i_p_name = myInput.nextLine();
					System.out.println("Enter price: ");
					int i_p_price = myInput.nextInt();
					myInput.nextLine();
					System.out.println("Enter Quantity :");
					int i_p_quantity = myInput.nextInt();
					myInput.nextLine();
					boolean i_p_avaliblity = false;
					if (i_p_quantity > 0) {	
						i_p_avaliblity = true;
					}
				if ((shopController.addProduct(i_p_id, i_p_name, i_p_price, i_p_quantity, i_p_avaliblity)) !=0) {
					System.out.println("product added");
				}else {
					System.out.println("product not added");
				}  
				} else{  
				boolean toContinue =true;
				ArrayList<product> products =new ArrayList<product>();
				do {
					product Product = new product();
					System.out.println("enter id:");
					Product.setP_id(myInput.nextInt());
					myInput.nextLine();
					System.out.println("enter name :");
					Product.setP_name(myInput.nextLine());
					System.out.println("Enter price:");
					Product.setP_price(myInput.nextInt());
					myInput.nextLine();
					System.out.println("Enter quantity :");
					int quantity =myInput.nextInt();
					Product.setP_quantity(quantity);
					myInput.nextLine();
					boolean i_p_avaliblity =false;
					if (quantity > 0) {
						i_p_avaliblity =true;
					}
				Product.setP_availablity(i_p_avaliblity);	
				products.add(Product);	
				System.out.println("press 1 to continue adding products : ");
				int toAdd = myInput.nextInt();
				if (toAdd == 0) {
					toContinue =false;
					System.out.println("product added");
				}
				} while (toContinue);
				shopController.addMultipleProducts(products);
			}
				break;
			case 2:
				//Handle product remove
				System.out.println("Enter product id to remove: ");
				int productIdRemove = myInput.nextInt();
				myInput.nextLine();
				if (shopController.removeProduct(productIdRemove) != 0) {
					System.out.println("DATA Deleted Successfully");
				} else {
					System.out.println("Product with given id does not exits , no remove operation ");
				}
				System.out.println();
				break;
			case 3:
// handle product detail update
				System.out.println("Enter product id update : ");
				int productIdToUpdate =myInput.nextInt();
				myInput.nextLine();
			ResultSet	Product =shopController.fetchProduct(productIdToUpdate);
			if (Product.next()) {
				System.out.println("what you want to update  ?");
				System.out.println("1.Name\n2.Price\n3.Quantity");
				System.out.println("Enter number respective to desired option :");
				byte updateOption =myInput.nextByte();
				myInput.nextLine();
				switch (updateOption) {
				case 1:
					System.out.println("Enter name to update :");
					String nameToUpdate = myInput.nextLine();
					if (shopController.updateProduct(productIdToUpdate, nameToUpdate)!= 0) {
						System.out.println("Record update .");
					}else {
						System.out.println("Record not updated .");
					}
					break;
case 2:
			System.out.println("Enter price to update :");	
			int  priceToUpdate =myInput.nextInt();
//			
			
					break;
case 3:
	
	break;

				default:
					System.out.println("invelid selection");
					break;
				}
			}else {
				System.out.println("Product with given id does not exist, update operation can not bre performed");
			}
				break;
			case 4:
				System.out.println("Enter Product id to fetch : ");
				int productIdToFind = myInput.nextInt();
				myInput.nextLine();
				ResultSet fetchProduct = shopController.fetchProduct(productIdToFind);
				boolean next = fetchProduct.next();
				if(next) {
					System.out.println("Product details");
					System.out.println("ID : " + fetchProduct.getInt(1));
					System.out.println("Name : " + fetchProduct.getString(2));
					System.out.println("Price : " + fetchProduct.getInt(3));
					System.out.println("Quantity : " + fetchProduct.getInt(4));
					if(fetchProduct.getBoolean(5)) {
						System.out.println("Avilability : Available");
					}else {
						System.out.println("Avilability : Not Available");
					}
					System.out.println();
				}else {
					System.out.println("Product with id : " + productIdToFind + "does not exit.");
					System.out.println();
				}
			
			   break;
			   case 5:
   
				break;

			default:
				System.out.println("----InvalidSection------");
				break;
			}

		} while (true);
	}

}
