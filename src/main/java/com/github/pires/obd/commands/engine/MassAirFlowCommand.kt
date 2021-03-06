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
package com.github.pires.obd.commands.engine

import com.github.pires.obd.commands.ObdCommand
import com.github.pires.obd.enums.AvailableCommandNames

/**
 * Mass Air Flow (MAF)
 *
 */
class MassAirFlowCommand : ObdCommand("01 10") {
    private var maf = -1.0f

    /** {@inheritDoc}  */
    override fun performCalculations() {
        // ignore first two bytes [hh hh] of the response
        maf = (buffer[2] * 256 + buffer[3]) / 100.0f
    }

    /** {@inheritDoc}  */
    override val formattedResult: String get() {
        return String.format("%.2f%s", maf, resultUnit)
    }

    /** {@inheritDoc}  */
    override val calculatedResult: String get() {
        return maf.toString()
    }

    /** {@inheritDoc}  */
    override val resultUnit: String get() {
        return "g/s"
    }

    /**
     *
     * getMAF.
     *
     * @return MAF value for further calculus.
     */
    val mAF: Double
        get() = maf.toDouble()

    /** {@inheritDoc}  */
    override val name: String get() {
        return AvailableCommandNames.MAF.value
    }
}