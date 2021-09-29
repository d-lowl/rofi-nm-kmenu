package space.dlowl.rofinmkmenu.nm

import space.dlowl.kmenu.utils.executeCommand

object NetworkManager {
    fun getConnections(): List<Network> {
        val allConnections = _getConnections()
        val activeConnectionsUuids = _getConnections(true).map { it.uuid }
        allConnections.forEach { if (it.uuid in activeConnectionsUuids) it.active = true }
        return allConnections
    }

    fun upConnection(uuid: String) {
        executeCommand("nmcli -t c up $uuid")
    }

    fun downConnection(uuid: String) {
        executeCommand("nmcli -t c down $uuid")
    }

    private fun _getConnections(activeOnly: Boolean = false): List<Network> {
        val command = if(activeOnly) "nmcli -t c show -a" else "nmcli -t c show"
        return executeCommand(command)
            .split("\n")
            .map {
                it.split(":")
            }
            .map {
                Network(it[0], it[1], it[2], it[3])
            }
    }
}