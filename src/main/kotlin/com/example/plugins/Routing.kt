package com.example.plugins

import com.example.generated.openapi.Paths
import com.example.generated.openapi.models.GreetingRequest
import com.example.generated.openapi.models.GreetingResponse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(Resources)
    routing {
        get<Paths.getGreeting> {

            val body = call.receive<GreetingRequest>()

            call.respond(GreetingResponse(message = "Hello, ${body.name}!"))
        }
    }
}
