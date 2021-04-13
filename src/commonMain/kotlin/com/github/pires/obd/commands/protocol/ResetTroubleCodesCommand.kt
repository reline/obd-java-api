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
package com.github.pires.obd.commands.protocol

import com.github.pires.obd.commands.ObdCommand

/**
 * Reset trouble codes.
 *
 */
class ResetTroubleCodesCommand : ObdCommand("04") {
    /** {@inheritDoc}  */
    override fun performCalculations() {}

    /** {@inheritDoc}  */
    override val formattedResult: String get() {
        return result
    }

    /** {@inheritDoc}  */
    override val calculatedResult: String get() {
        return result
    }

    /** {@inheritDoc}  */
    override val name: String get() {
        return result
    }
}