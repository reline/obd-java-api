/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pires.obd.commands

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

/**
 * Container for multiple [com.github.pires.obd.commands.ObdMultiCommand] instances.
 */
class ObdMultiCommand {
    private val commands: ArrayList<ObdCommand> = ArrayList()

    /**
     * Add ObdCommand to list of ObdCommands.
     *
     * @param command a [com.github.pires.obd.commands.ObdCommand] object.
     */
    fun add(command: ObdCommand) {
        commands.add(command)
    }

    /**
     * Removes ObdCommand from the list of ObdCommands.
     *
     * @param command a [com.github.pires.obd.commands.ObdCommand] object.
     */
    fun remove(command: ObdCommand) {
        commands.remove(command)
    }

    /**
     * Iterate all commands, send them and read response.
     *
     * @param in  a [java.io.InputStream] object.
     * @param out a [java.io.OutputStream] object.
     * @throws java.io.IOException            if any.
     * @throws java.lang.InterruptedException if any.
     */
    @Throws(IOException::class, InterruptedException::class)
    fun sendCommands(`in`: InputStream?, out: OutputStream?) {
        for (command in commands) command.run(`in`, out)
    }

    /**
     *
     * getFormattedResult.
     *
     * @return a [java.lang.String] object.
     */
    val formattedResult: String
        get() {
            val res = StringBuilder()
            for (command in commands) res.append(command.formattedResult).append(",")
            return res.toString()
        }
}