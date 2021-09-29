import space.dlowl.kmenu.menu.Menu
import space.dlowl.rofinmkmenu.nm.NetworkManager

fun toggle(uuid: String, active: Boolean) {
    if (active) {
        NetworkManager.downConnection(uuid)
    } else {
        NetworkManager.upConnection(uuid)
    }
}

fun main(args: Array<String>) {
    val connections = NetworkManager.getConnections()
    Menu.menu {
        connections.forEach {
            option {
                label = it.name
                action = { toggle(it.uuid, it.active); "" }
            }
        }
    }.main(args)
}