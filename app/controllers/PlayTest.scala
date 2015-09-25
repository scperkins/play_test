package controllers

import play.api._
import play.api.mvc._
import models.{Food, Product, Item}
import play.api.Play.current

class PlayTest extends Controller {
	
	def index = Action {
		
		Ok(views.html.index(Item.getItems))
	}

}

class Products extends Controller {

	def list = Action { implicit request =>

    	val products = Product.getProducts
    	Ok(views.html.products.list(products))
  	}

	def show(uuid: String) = Action { implicit request =>
		
		Product.findById(uuid).map { product =>

      		Ok(views.html.products.details(product))

    	}.getOrElse(NotFound)
  	}
}

class Food extends Controller {

	def list = Action { implicit request =>
    	
    	Ok(views.html.food.list(Food.getFood))
  	}

  	def show(name: String) = Action { implicit request =>
		
		Food.findByName(name).map { food =>

      		Ok(views.html.food.details(food))

    	}.getOrElse(NotFound)
  	}

}