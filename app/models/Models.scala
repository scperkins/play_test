package models 

import global.Global
import play.api._
import play.api.Play.current

case class Food(val name: String, val desc: String, val thumb: String, val large: String) 
	
object Food {
	
	def getFood() : List[Food] = {
		(Global.xmlData \ "Food" \ "Item").map { food =>
			Food(
				(food \ "Name").text, 
				(food \ "Description").text,
				(food \ "Image" \ "Thumb").text,
				(food \ "Image" \ "Large").text
			)
		}.toList
	}

	def findByName(name: String) = getFood.find(_.name == name)
}

case class Product(val name: String, val uuid: String, val desc: String, val price: Double, val thumb: String, val large: String)

object Product {
	
	def getProducts : List[Product] = {
		(Global.xmlData \ "Products" \ "Item").map { product =>
			Product(
				(product \ "Name").text, 
				(product \ "UUID").text,
				(product \ "Description").text,
				(product \ "Price").text.toDouble,
				(product \ "Image" \ "Thumb").text,
				(product \ "Image" \ "Large").text
			)
		}.toList
	}

	def findById(uuid: String) = getProducts.find(_.uuid == uuid)

}

case class Item(val name: String, val desc: String, val thumb: String	)

object Item {
	
	def getItems() : List[Item] = {
		(Global.xmlData \\ "Item").map { item =>
			Item(
				(item \ "Name").text, 
				(item \ "Description").text,
				(item \ "Image" \ "Thumb").text
			)
		}.toList
	}

}