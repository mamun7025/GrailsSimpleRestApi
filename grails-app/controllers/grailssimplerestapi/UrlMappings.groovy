package grailssimplerestapi

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        // define your api path
        get "/api/getItem"(controller:"ItemRestApi", action:"getItem")
        get "/api/getItem2"(controller:"ItemRestApi", action:"getItem2")
        get "/api/getItem3"(controller:"ItemRestApi", action:"getItem3")
    }
}
