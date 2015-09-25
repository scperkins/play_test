package models 

import play.api._
import play.api.Play.current

case class Food(val name: String, val desc: String, val thumb: String, val large: String) 
	
object Food {
	val data = scala.xml.XML.loadFile("conf/data.xml")
	def getFood() : List[Food] = {
		(data \ "Food" \ "Item").map { food =>
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
	val data = scala.xml.XML.loadFile("conf/data.xml")
	def getProducts : List[Product] = {
		(data \ "Products" \ "Item").map { product =>
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
	val data = scala.xml.XML.loadFile("conf/data.xml")
	def getItems() : List[Item] = {
		(data \\ "Item").map { item =>
			Item(
				(item \ "Name").text, 
				(item \ "Description").text,
				(item \ "Image" \ "Thumb").text
			)
		}.toList
	}

}