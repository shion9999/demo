package com.example.demo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

data class HelloResponse(val message: String)

interface Greeter {
	fun sayHello(name: String): String
}

@Component
class GreeterImpl : Greeter{
	override fun sayHello(name: String) = "Hello $name"
	}
@RestController
class GreeterController(private val greeter: Greeter){
	@GetMapping("/hello/byservice/{name}")
	fun helloByservice(@PathVariable("name") name: String): HelloResponse{
		val message = greeter.sayHello(name)
		return HelloResponse(message)
	}
}

@SpringBootApplication
class DemoApplication
fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)

}


