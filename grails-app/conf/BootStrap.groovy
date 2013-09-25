import name.stokito.listParamsExample.User

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
                30.times {
                    User.build()
                }
            }
        }
    }

    def destroy = {
    }
}
